import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class GeneralStoreTestCase5 extends Base {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AndroidDriver<AndroidElement> driver = Capabilities(true);

        // locators
        MobileElement countryDropdown = driver.findElementById("com.androidsample.generalstore:id/spinnerCountry");
        MobileElement inputText = driver.findElementById("com.androidsample.generalstore:id/nameField");
        MobileElement radioFemale = driver.findElementById("com.androidsample.generalstore:id/radioFemale");
        MobileElement shopButton = driver.findElementById("com.androidsample.generalstore:id/btnLetsShop");

        // positive path flow
        inputText.click();
        inputText.sendKeys("hello");
        driver.hideKeyboard();
        radioFemale.click();
        countryDropdown.click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))");
        driver.findElementByXPath("//android.widget.TextView[@text='Argentina']").click();
        shopButton.click();

        driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(0).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        int SECONDS_TO_WAIT = 4;
        int MILISECS_IN_A_SEC = 1000;
        /*
         * this wait is needed so appium has time to process the change of view
         */
        Thread.sleep(SECONDS_TO_WAIT*MILISECS_IN_A_SEC);

        TouchAction action = new TouchAction(driver);
        MobileElement checkbox = driver.findElement(By.className("android.widget.CheckBox"));
        action.tap(tapOptions().withElement(element(checkbox))).perform();
        MobileElement termsBtn = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
        action.longPress(longPressOptions().withElement(element(termsBtn)).withDuration(ofSeconds(2))).release().perform();
        MobileElement closeBtn = driver.findElement(By.id("android:id/button1"));
        action.tap(tapOptions().withElement(element(closeBtn))).perform();
        MobileElement proceedBtn = driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed"));
        action.tap(tapOptions().withElement(element(proceedBtn))).perform();

        //
        /*
         * this wait is needed so appium has time to process the change to the web view
         */
        SECONDS_TO_WAIT = 7;
        Thread.sleep(SECONDS_TO_WAIT*MILISECS_IN_A_SEC);
        Set<String> contexts = driver.getContextHandles();
        for(String context:contexts) {
            System.out.println(context);
            /*
             * NATIVE_APP [0]
             * WEBVIEW_com.androidsample.generalstore [1]
             */
        }
        /*
         * switching to web view context
         */
        driver.context((String) contexts.toArray()[1]);
        System.out.println("switching to " + contexts.toArray()[1] + " context.");
        MobileElement input = driver.findElement(By.cssSelector("input[name='q']"));
        input.sendKeys("hello");
        input.sendKeys(Keys.ENTER);
        SECONDS_TO_WAIT = 2;
        Thread.sleep(SECONDS_TO_WAIT*MILISECS_IN_A_SEC);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        /*
         * switching to native context
         */
        driver.context((String) contexts.toArray()[0]);
        System.out.println("switching to " + contexts.toArray()[0] + " context.");
        Thread.sleep(SECONDS_TO_WAIT*MILISECS_IN_A_SEC);

        /*
         * closes all the active web driver instances
         */
        driver.quit();
    }
}
