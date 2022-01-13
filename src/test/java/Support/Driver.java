package Support;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {

    @BeforeSuite
    public static AppiumDriver getDriver(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/sanjaysharma/IdeaProjects/AppiumDemoOne/Application/paytmReal.apk");
        capabilities.setCapability("appPackage", "net.one97.paytm");
        capabilities.setCapability("appActivity", "net.one97.paytm.app.LauncherActivity");
        URL url = null;
        try {
            url = new URL("http://0.0.0.0:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        AppiumDriver driver = new AndroidDriver(url, capabilities);
        System.out.println("Settig up driver");
        return driver;
    }

}
