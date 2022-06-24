import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Base {

    public static AndroidDriver<AndroidElement> Capabilities(boolean realDevice) throws MalformedURLException {

        String deviceName = realDevice ? "Android Device" : "phone09";
        String automationName = "uiautomator2";
        String appName = "General-Store.apk";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);
        caps.setCapability(MobileCapabilityType.APP, getAbsolutePath(appName));

        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public static String getAbsolutePath(String appName) {
        var dir = new File("app");
        var file = new File(dir, appName);
        return file.getAbsolutePath();
    }

}
