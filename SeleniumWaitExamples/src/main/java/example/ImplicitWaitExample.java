package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class ImplicitWaitExample {
    private WebDriver webDriver;
    private int secondsToWait;

    public ImplicitWaitExample (WebDriver webDriver, int secondsToWait) {
        this.webDriver = webDriver;
        this.secondsToWait = secondsToWait;
    }

    public String basicImpWait(String webPage, String elementXpath) {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secondsToWait));
        webDriver.get(webPage);
        WebElement htmlElement = webDriver.findElement(By.xpath(elementXpath));
        String elementText = htmlElement.getText();
        if(elementText.equals("Some text")) {
            // Do something... idk what.
        }
        return elementText;
    }
}
