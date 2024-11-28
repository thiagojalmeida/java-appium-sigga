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

    @Test(testName = "Test error message when use invalid Server")
    public void testWithInvalidServerOption(){
        startPage.clickStartServerBtn();
        startPage.getSelectCustomServer();
        startPage.writeWrongServerStg("ABC");
        startPage.clickContinueBtn();

        String errorText = startPage.getScreenErrorMessageAfterIsertWrongSerer();

        Assert.assertEquals(errorText, startPage.getTextWrongServerErrorMessage());
        //Assert.assertEquals(errorText, "wrong text error");

        startPage.clickWorningBtnOk();

    }

    @Test(testName = "Test error message when use invalid Email ID credential")
    public void testWithInvalidEmailCredential(){
        startPage.clickStartServerBtn();
        startPage.getSelectCustomServer();
        startPage.writeServerStg();
        startPage.clickContinueBtn();
        startPage.writeEmailtoLogin("no_candidato@google.com");
        startPage.clickContinueBtn();

        String errorText = startPage.getScreenErrorMessageAfterIsertWrongSerer();

        Assert.assertEquals(errorText, startPage.getTextMessageErrorToInvalidCrendential());
        //Assert.assertEquals(errorText, "wrong text error");

        startPage.clickWorningBtnOk();

    }


    @Test(testName = "Test error message when use invalid password credentials - correct message")
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
        //Assert.assertEquals(errorText, "wrong text error");

        startPage.clickWorningBtnOk();

    }

}
