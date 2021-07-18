import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class MobileBrowser extends BaseBrowser {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = Capabilities();
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();
        driver.findElement(By.cssSelector(".nav-link[routerlink='/products']")).click();
        driver.quit();
    }
}
