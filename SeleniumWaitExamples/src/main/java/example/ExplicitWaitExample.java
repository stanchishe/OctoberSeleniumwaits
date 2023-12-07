package example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ExplicitWaitExample {
    private final String urlLink = "https://google.com";
    private final String agree = "L2AGLb";
    private final String searchBox = "q";
    private final String firstResult = "//*[@id=\"rso\"]/div[2]/div[1]/div/div/div/div[1]/div/div/span/a";
    private WebDriver webDriver;
    private int secondsToWait;

    public ExplicitWaitExample(WebDriver webDriver, int secondsToWait) {
        this.webDriver = webDriver;
        this.secondsToWait = secondsToWait;
    }

    public String basicExpWait() {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(secondsToWait));

        webDriver.get(urlLink);
        webDriver.findElement(By.id(agree)).click();

        webDriver.findElement(By.name(searchBox)).sendKeys("Yahoo", Keys.ENTER);

        WebElement firstSearchResult = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath(firstResult))
        );
        return firstSearchResult.getText();
    }
}
