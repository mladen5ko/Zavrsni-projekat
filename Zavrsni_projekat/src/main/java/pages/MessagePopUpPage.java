package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//metodu koja ceka da pop up bude vidljiv
//Elemente koji u sebi sadrze tekstove poruke
//Close dugme
//
//metodu koja ceka da se verify your account dijalog pojavi
//metodu koja vraca zaglavlje iz verify your account dijaloga koji sadrzi tekst IMPORTANT: Verify your account
//
//Close dugme iz verify account dijaloga

public class MessagePopUpPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public MessagePopUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getErrorWindow(){
        return driver.findElement(By.tagName("li"));
    }
    public void waitUntilErrorWindowShowUp(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Close']")));
    }

    public WebElement closeButtonFromPopupWindow(){
        return driver.findElement(By.xpath("//*[text()='Close']"));
    }


    public WebElement getVerifyAccountWindow(){
        return driver.findElement(By.xpath("//*[contains(text(), 'IMPORTANT: Verify your account')]"));
    }

    public void waitUntilVerifyAccountWindowShowUp(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'IMPORTANT: Verify your account')]")));
    }
}
