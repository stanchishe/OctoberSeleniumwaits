package example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class SwitchToAlertTest {
    static final String expectedAlertText = "Hello! I am an alert box!";
    static WebDriver webDriver;

    @BeforeAll
    public static void initiate() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("Start-Maximized");
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterAll
    public static void cleanup() {
        webDriver.close();
        webDriver.quit();
    }

    @Test
    @DisplayName("should test if alert was created with the correct text")
    public void checkForAlert() {
        SwitchToAlert switchToAlert = new SwitchToAlert(webDriver);
        Assertions.assertEquals(switchToAlert.createAlert(), expectedAlertText, "The alert texts was now as we expected");
    }
}
