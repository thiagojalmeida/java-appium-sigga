package base;

import driver.AppDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.SupportsContextSwitching;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class BasePage {
    public BasePage(){
        PageFactory.initElements( new AppiumFieldDecorator(AppDriver.getCurrentDriver()), this);
    }
    WebDriverWait wait = new WebDriverWait(AppDriver.getCurrentDriver(), Duration.ofSeconds(10));

    protected WebElement waitForEl(By locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected WebElement getEl(By locator){
        return waitForEl(locator);
    }

    protected void waitAndtype(By locator, String text){
        waitForEl(locator).clear();
        getEl(locator).sendKeys(text);
    }

}
