import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class DragAndDropGesture extends Base {
    public static void main(String[] args) throws MalformedURLException {
        var driver = Capabilities(true);

        // drag and drop gesture
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
        driver.findElementByAccessibilityId("Drag and Drop").click();

        TouchAction action = new TouchAction(driver);
        MobileElement element = driver.findElementById("io.appium.android.apis:id/drag_dot_1");
        MobileElement dropPoint = driver.findElementById("io.appium.android.apis:id/drag_dot_3");
        action.longPress(longPressOptions().withElement(element(element))).moveTo(element(dropPoint)).release().perform();
    }
}