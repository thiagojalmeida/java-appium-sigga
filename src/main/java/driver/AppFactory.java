package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URL;

public class AppFactory {

    static AppiumDriver driver;

    private  static void androidLauchApp(String deviceUdid, String portNumber ) throws MalformedURLException {
        //udidDevice. = "emulator-5554";
        UiAutomator2Options options = new UiAutomator2Options();

        options
                .setAutomationName("UiAutomator2")
                .setPlatformName("android")
                .setUdid(deviceUdid)
                .setAppPackage("com.sigga.platform.empower.pr")
                .setAppActivity("crc6442cd7d981b8a9420.MainActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:"+ portNumber +"/"), options);
        AppDriver.setDriver(driver);
    }

    public static void launchApp(String deviceUdid, String portNumber) throws MalformedURLException {
        System.out.println("Entering into launchapp");
        androidLauchApp(deviceUdid, portNumber);

    }
}
