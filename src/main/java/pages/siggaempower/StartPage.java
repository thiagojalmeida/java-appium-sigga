package pages.siggaempower;

import base.BasePage;
import config.PropertyUtil;
import org.openqa.selenium.By;

public class StartPage extends BasePage {
    private final String MESSAGE_ERROR_LOGIN_INVALID_CREDENTIAL  = "Invalid user!";

    private By serverBtn = By.xpath("//android.widget.Button[@text='Select Server']");
    private By selectCustomServer = By.xpath("//android.widget.TextView[@text='Custom']");
    private By serverTextInput = By.xpath("//android.widget.EditText"); //stg
    private By continueBtn = By.xpath("//android.widget.Button[@text='Continue']"); // for input server and input email
    private By emailTextInput = By.xpath("//android.widget.EditText[@text='example@company.com']"); //candidato@processoseletivo.com
    private By passwordInput = By.xpath("//android.view.ViewGroup[position()=3]/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText");
    private By singInBtn = By.xpath("//android.widget.Button[@text='Sign In']");
    private By errorMessage = By.xpath("//android.widget.TextView[@resource-id='android:id/message']"); //Invalid user!
    private By warningOkBtn = By.xpath("//android.widget.Button[@resource-id='android:id/button2']");

    public  String getTextMessageErrorToInvalidCrendential() {
        return MESSAGE_ERROR_LOGIN_INVALID_CREDENTIAL;
    }

    public void  clickStartServerBtn(){
        getEl(serverBtn).click();
    }

    public void getSelectCustomServer(){
        getEl(selectCustomServer).click();
    }

    public void writeServerStg(){
        waitAndtype(serverTextInput, PropertyUtil.getConfig().stgServer());
    }

    public void clickContinueBtn(){
        getEl(continueBtn).click();
    }

    public void writeEmailtoLogin() {
        waitAndtype(emailTextInput, PropertyUtil.getConfig().userEmail());
    }

    public void writeIvalidPasswrod() {
        waitAndtype(passwordInput, PropertyUtil.getConfig().getInvalidPassword());
    }

    public void clickSingInBtn(){
        getEl(singInBtn).click();
    }

    public String getErrorMessage() {
        return getEl(errorMessage).getText();
    }

    public void clickWorningBtnOk() {
        getEl(warningOkBtn).click();
    }

}
