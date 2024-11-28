package base;

import driver.AppDriver;
import driver.AppFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.MalformedURLException;

public class BaseTest {
    private AppiumDriverLocalService service;

    @BeforeTest
    @Parameters("portNumber")
    public void setAppiumServer(@Optional("4723") String portNumber) throws InterruptedException {
        startAppiumservice(portNumber);
        Thread.sleep(3*1000);
    }

    @BeforeMethod
    @Parameters({"deviceUdid", "portNumber"})
    public void setup(String deviceUdid, String portNumber) throws MalformedURLException, InterruptedException {
        System.out.println("before class");
        setupDriver(deviceUdid, portNumber);
    }

    @AfterMethod
    public void closeApp(ITestResult result) throws IOException {
        if(result.getStatus() == ITestResult.FAILURE){
            Util.getScreenshot(result.getInstanceName());
        }
        AppDriver.getCurrentDriver().quit();
    }

    @AfterTest
    public void stopServer(){
        if ( service.isRunning()){
            service.stop();
        }
    }

    private void setupDriver(String deviceUdid, String portNumber) throws MalformedURLException {
        AppFactory.launchApp(deviceUdid, portNumber);
    }

    public void startAppiumservice(String portNumber){
        AppiumServiceBuilder builder  = new AppiumServiceBuilder();
        builder.withIPAddress("127.0.0.1");
        builder.usingPort(Integer.parseInt(portNumber));
        service = AppiumDriverLocalService.buildService(builder);
        service.start();

        System.out.println("Service has been start with port number: " + portNumber);
    }

}
