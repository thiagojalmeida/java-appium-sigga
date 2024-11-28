package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AppDriver {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static  AppDriver instance = null;

    private AppDriver() {
        /** **/
    }

    public static  AppDriver getInstance() {
        if(instance == null) {
            instance = new AppDriver();
        }
        return instance;
    }

    public WebDriver getDriver() {
        return driver.get(); // <-- local thread
    }

    public static WebDriver getCurrentDriver() {
        return getInstance().getDriver();
    }

    public static void setDriver(WebDriver d) {
        driver.set(d);
        System.out.println("Driver is set: "+ d.toString());
    }

}
