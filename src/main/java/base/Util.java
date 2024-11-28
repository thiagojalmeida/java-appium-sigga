package base;

import browserstack.shaded.ch.qos.logback.core.util.FileUtil;
import com.google.common.collect.ImmutableMap;
import driver.AppDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    public static String getScreenshot(String imgName) throws IOException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timeStamp = simpleDateFormat.format(new Date());

        TakesScreenshot ts = (TakesScreenshot) AppDriver.getCurrentDriver();
        File f1 = ts.getScreenshotAs(OutputType.FILE);

        String filePath = System.getProperty("user.dir") +  File.separator
                +"screenshots"+ File.separator + imgName+timeStamp+".png";

        FileUtils.copyFile(f1, new File(filePath));

        return filePath;
    }

}
