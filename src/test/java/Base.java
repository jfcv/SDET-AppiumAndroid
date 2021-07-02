import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Base {

    public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException {
        final String deviceName = "phone09";

        File dir = new File("app");
        File file = new File(dir, "ApiDemos-debug.apk");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        caps.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());

        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        return driver;
    }

}
