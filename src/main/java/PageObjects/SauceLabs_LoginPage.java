package PageObjects;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;

public class SauceLabs_LoginPage
{
    private AppiumDriver<WebElement> driver;

    // Locators
    private AppiumBy usernameField = (AppiumBy) AppiumBy.id("com.example.myapp:id/username");
    private AppiumBy passwordField = AppiumBy.id("com.example.myapp:id/password");
    private AppiumBy loginButton = AppiumBy.id("com.example.myapp:id/loginButton");
    private AppiumBy successMessage = AppiumBy.id("com.example.myapp:id/successMessage");

    // Constructor
    public LoginPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    // Actions
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isSuccessMessageDisplayed() {
        return driver.findElement(successMessage).isDisplayed();
    }

}
