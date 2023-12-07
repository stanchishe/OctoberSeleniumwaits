package example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ExplicitWaitTest {
    static WebDriver webDriver;
    static int secondsToWait = 10;

    @BeforeAll
    public static void initiate() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("Start-Maximized");
        webDriver = new ChromeDriver(options);
    }

    @AfterAll
    public static void exit() {
        webDriver.close();
        webDriver.quit();
    }

    @Test
    @DisplayName("should fetch elements values from a page")
    public void shouldFetchValue() {
        String expectedResult = "Yahoo";
        ExplicitWaitExample explicitWaitExample = new ExplicitWaitExample(webDriver, secondsToWait);
        String firstResult = explicitWaitExample.basicExpWait();
        Assertions.assertTrue(firstResult.contains(expectedResult), "Something other than Yahoo :( ");
    }
}
