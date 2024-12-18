package steps;

import PageObjects.SauceLabs_LoginPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class SauceLabs_LoginSteps
{
    private AppiumDriver driver;
    private SauceLabs_LoginPage loginPage;

    @Given("the user launches the application")
    public void theUserLaunchesTheApplication() {
        // Setup Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "12.0"); // Replace with your device version
        caps.setCapability("deviceName", "Android Emulator"); // Replace with your device/emulator name
        caps.setCapability("app", "/path/to/your/app.apk"); // Replace with the path to your app
        caps.setCapability("appPackage", "com.example.myapp"); // Replace with your app's package name
        caps.setCapability("appActivity", "com.example.myapp.MainActivity"); // Replace with your app's main activity
        caps.setCapability("noReset", true);

        try {
            // Initialize the Appium Driver
            driver = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
            loginPage = new SauceLabs_LoginPage(driver);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Appium server URL");
        }
    }

    @When("the user enters a valid username and password")
    public void theUserEntersAValidUsernameAndPassword() {
        loginPage.enterUsername("testuser");
        loginPage.enterPassword("testpassword");
    }

    @When("the user clicks on the login button")
    public void theUserClicksOnTheLoginButton() {
        loginPage.clickLogin();
    }

    @Then("the user should see a success message")
    public void theUserShouldSeeASuccessMessage() {
        boolean isDisplayed = loginPage.isSuccessMessageDisplayed();
        if (!isDisplayed) {
            throw new AssertionError("Success message is not displayed");
        }
    }



}
