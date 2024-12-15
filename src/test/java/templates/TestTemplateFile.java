package templates;

import base.BaseTest;
import driver.AppDriver;
import driver.AppFactory;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.siggaempower.StartPage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;

public class TestTemplateFile extends BaseTest {
    //StartPage startPage;

    @BeforeMethod
    @Override
    @Parameters({"deviceUdid", "portNumber"})
    public void setup(String deviceUdid, String portNumber) throws MalformedURLException, InterruptedException {
        super.setup(deviceUdid, portNumber);
        //startPage = new StartPage();

    }

    @Test(testName = "Template")
    private static void readFile(String cmd, String xpath, @Optional String text) throws IOException {
        WebDriver driver = AppDriver.getCurrentDriver();
        BufferedReader objReader = null;

        try {
            String strCurrentLine;
            objReader = new BufferedReader(new FileReader("src/main/resources/stepsTest.txt"));
            while ((strCurrentLine = objReader.readLine()) != null) {
                String[] split = strCurrentLine.split("&");

                System.out.println(split[0] +" "+ split[1]);

                switch (split[0].toLowerCase()) {
                    case "click":
                        driver.findElement(AppiumBy.xpath(split[1])).click();
                        break;
                    case "write":
                        driver.findElement(AppiumBy.xpath(split[1])).sendKeys(split[2]);
                        break;
                    case "gettext":
                        System.out.println(
                                driver.findElement(AppiumBy.xpath(split[1])).getText()
                        );
                    default:
                        break;
                }

                Thread.sleep(3*1000);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
