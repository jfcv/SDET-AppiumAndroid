import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.net.MalformedURLException;

public class GeneralStoreTestCase2 extends Base {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = Capabilities(true);

        // locators
        MobileElement countryDropdown = driver.findElementById("com.androidsample.generalstore:id/spinnerCountry");
        MobileElement inputText = driver.findElementById("com.androidsample.generalstore:id/nameField");
        MobileElement radioFemale = driver.findElementById("com.androidsample.generalstore:id/radioFemale");
        MobileElement shopButton = driver.findElementById("com.androidsample.generalstore:id/btnLetsShop");

        // negative path flow
        radioFemale.click();
        countryDropdown.click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))");
        driver.findElementByXPath("//android.widget.TextView[@text='Argentina']").click();
        shopButton.click();
        String toastMessage = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
        System.out.println(toastMessage);
        Assert.assertEquals(toastMessage, "Please enter your name");
    }
}
