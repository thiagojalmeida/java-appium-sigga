package siggaempower;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.siggaempower.StartPage;
import java.net.MalformedURLException;

public class StartPageLoginTest extends BaseTest {
    StartPage startPage;

    @BeforeMethod
    @Override
    @Parameters({"deviceUdid", "portNumber"})
    public void setup(String deviceUdid, String portNumber) throws MalformedURLException, InterruptedException {
        super.setup(deviceUdid, portNumber);
        startPage = new StartPage();
    }

    @Test(testName = "Test error message when use invalid IDs credentials - correct message")
    public void testWithInvalidCredentialValidTextError(){
        startPage.clickStartServerBtn();
        startPage.getSelectCustomServer();
        startPage.writeServerStg();
        startPage.clickContinueBtn();
        startPage.writeEmailtoLogin();
        startPage.clickContinueBtn();
        startPage.writeIvalidPasswrod();
        startPage.clickSingInBtn();

        String errorText = startPage.getErrorMessage();

        Assert.assertEquals(errorText, startPage.getTextMessageErrorToInvalidCrendential());

        startPage.clickWorningBtnOk();

    }

    //@Test(testName = "Test error message when use invalid IDs credentials - incorrect message")
    public void testWithInvalidCredentialsInValidTextError(){
        startPage.clickStartServerBtn();
        startPage.getSelectCustomServer();
        startPage.writeServerStg();
        startPage.clickContinueBtn();
        startPage.writeEmailtoLogin();
        startPage.clickContinueBtn();
        startPage.writeIvalidPasswrod();
        startPage.clickSingInBtn();

        String errorText = startPage.getErrorMessage();

        Assert.assertEquals(errorText, "Wrong text error!");

        startPage.clickWorningBtnOk();
    }
}
