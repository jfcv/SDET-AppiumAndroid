import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;

public class MobileGestures extends Base {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AndroidDriver<AndroidElement> driver = Capabilities();

        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();

        // tap gesture
        TouchAction action = new TouchAction(driver);
        MobileElement expandableList = driver.findElementByAccessibilityId("Expandable Lists");
        action.tap(tapOptions().withElement(element(expandableList))).perform();
        driver.findElementByAccessibilityId("1. Custom Adapter").click();
        MobileElement peopleNamesOption = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
        action.longPress(longPressOptions().withElement(element(peopleNamesOption)).withDuration(ofSeconds(2))).release().perform();
        System.out.println(driver.findElementById("android:id/title").isDisplayed());
    }
}
