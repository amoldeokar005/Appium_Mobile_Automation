package android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static com.google.gson.internal.bind.TypeAdapters.URI;

public class SendMessage
{
    private AndroidDriver driver ;
    private static final String APPIUM_SERVER_URL = "https://127.0.0.1:4723";
    private static final String MOBILE_NUMBER = "555-123-4567";
    private static final String MESSAGE = "This is message from Amol";

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("appium:automationName", "UiAutomator2");
        dc.setCapability("appium:appPackage", "com.google.android.apps.messaging");
        dc.setCapability("appium:appActivity", ".ui.ConversationListActivity");

        driver = new AndroidDriver(new URL(APPIUM_SERVER_URL), dc);
    }


    @Test
    public void sendMessage()
    {

        driver.sendSMS(MOBILE_NUMBER, MESSAGE);
    }

    @AfterTest
    public void close()
    {
        driver.quit();
    }

}
