package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {
    private static AppiumDriver<WebElement> driver;

    public static void start(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", "192.168.13.101:5555");
        desiredCapabilities.setCapability("appPackage", "com.funplus.fun");
        desiredCapabilities.setCapability("appActivity",".activity.SplashActivity");
        //desiredCapabilities.setCapability("appActivity", ".funhome.activity.FunHomeActivity");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("autoGrantPermissions","true");
        desiredCapabilities.setCapability("noReset","true");

        URL remoteUrl=null;

        try {
            remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
        }catch (Exception e){
            e.printStackTrace();
        }

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    public static AppiumDriver<WebElement> getCurrentDriver(){
        return driver;
    }
}
