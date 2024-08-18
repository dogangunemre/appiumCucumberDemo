import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class runAppiumDriver {
    public static AppiumDriver<MobileElement> appiumDriver;
    String apkPath = new File("src/test/resources/apk/ApiDemos.apk").getAbsolutePath();

    public AppiumDriver<MobileElement> createAppiumDriver() throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("app", apkPath);

        appiumDriver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723"), capabilities);

        TimeUnit.SECONDS.sleep(2);
        return appiumDriver;
    }
}