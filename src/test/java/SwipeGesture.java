import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class SwipeGesture extends Base {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = Capabilities(true);

        // swipe gesture
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
        driver.findElementByAccessibilityId("Date Widgets").click();
        driver.findElementByAccessibilityId("2. Inline").click();
        driver.findElementByAccessibilityId("9").click();

        TouchAction action = new TouchAction(driver);
        MobileElement initialElement = driver.findElementByAccessibilityId("15");
        MobileElement finalElement = driver.findElementByAccessibilityId("45");
        action.longPress(longPressOptions().withElement(element(initialElement))).moveTo(element(finalElement)).release().perform();
    }
}
