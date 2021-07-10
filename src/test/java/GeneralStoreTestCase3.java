import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class GeneralStoreTestCase3 extends Base {
    public static void main(String[] args) throws MalformedURLException {
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
        String product = "Jordan 6 Rings";
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()" +
                ".resourceId(\"com.androidsample.generalstore:id/rvProductList\"))" +
                ".scrollIntoView(new UiSelector().text(\""+ product + "\"));");
        // picking a product dynamically from the list
        int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        for (int i=0;i<count;i++) { //O(n) time complexity
            String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if (productName.equalsIgnoreCase("Jordan 6 Rings")) {
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
                break;
            }
        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

    }
}
