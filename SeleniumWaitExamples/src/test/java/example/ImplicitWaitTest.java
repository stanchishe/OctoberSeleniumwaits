package example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ImplicitWaitTest {
    static WebDriver webDriver;
    static int secondsToWait = 10;
    static String elementXpath = "/html/body/pre";
    static String webAddress = "https://reqres.in/api/users?delay=3";

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
        String expectedResult = "charles.morris@reqres.in";
        ImplicitWaitExample implicitWaitExample = new ImplicitWaitExample(webDriver, secondsToWait);
        String basicReply = implicitWaitExample.basicImpWait(webAddress, elementXpath);
        Assertions.assertTrue(basicReply.contains(expectedResult), "We didn't find him in the group!");
    }
}
