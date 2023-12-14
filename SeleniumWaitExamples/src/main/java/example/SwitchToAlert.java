package example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.plaf.TableHeaderUI;

public class SwitchToAlert {
    private WebDriver webDriver;
    private final String testPage = "https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert";
    private final String acceptChoices = "accept-choices";
    private final String iFrameId = "iframeResult";
    private final String xPathIButton = "/html/body/button";
    public SwitchToAlert (WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String createAlert() {
        // Open page and accept choices
        webDriver.get(testPage);
        webDriver.findElement(By.id(acceptChoices)).click();

        // Switch to alert button iFrame
        WebElement resultFrameHTML = webDriver.findElement(By.id(iFrameId));
        webDriver.switchTo().frame(resultFrameHTML);

        // Create the alert
        webDriver.findElement(By.xpath(xPathIButton)).click();
        Alert alert = webDriver.switchTo().alert();
        String alertText = alert.getText();

        // Accept alert
        alert.accept();

        // Return to the base HTML page
        webDriver.switchTo().parentFrame();

        return alertText;
    }
}
