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

        String deviceName;
        String appName;

        if(realDevice) {
            deviceName = "Android Device";
            appName = "ApiDemos-debug-11.apk";
        } else {
            deviceName = "phone09";
            appName = "ApiDemos-debug.apk";
        }

        File dir = new File("app");
        File file = new File(dir, appName);

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        caps.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());

        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

}
