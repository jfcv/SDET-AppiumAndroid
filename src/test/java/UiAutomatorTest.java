import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;

public class UiAutomatorTest extends Base {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = Capabilities();

        /*
         * finding elements by Android UI Automator
         */
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();

        // validate clickable feature for all options
        System.out.println(driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size());
    }
}
