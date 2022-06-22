package pages;

//Nav Page
//Home link /
//About link /
//My profile link /
//Admin dugme /
//Cities link iz padajuceg Admin menija
//Users link iz padajuceg Admin menija
//Logout dugme
//Dugme za izbor jezika
//EN dugme iz padajuceg menija za izbor jezika
//ES dugme iz padajuceg menija za izbor jezika
//FR dugme iz padajuceg menija za izbor jezika
//CN dugme iz padajuceg menija za izbor jezika

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public NavPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getHomeLink(){
        return driver.findElement(By.className("btnHome"));
    }

    public WebElement getAboutLink(){
        return driver.findElement(By.className("btnAbout"));
    }

    public WebElement getSignUplink(){
        return driver.findElement(By.xpath("//a[contains(@class, 'btnLogin')][2]"));
    }

    public WebElement getLoginLink(){
        return driver.findElement(By.className("btnLogin"));
    }

    public WebElement getMyProfileLink(){
        return driver.findElement(By.className("btnProfile"));
    }

    public WebElement getAdminButton(){
        return driver.findElement(By.className("btnAdmin"));
    }

    public WebElement getCitiesFromAdmin(){
        return driver.findElement(By.className("btnAdminCities"));
    }

    public WebElement getUsersFromAdmin(){
        return driver.findElement(By.className("btnAdminUsers"));
    }

    public WebElement getLogOutButton(){
        return driver.findElement(By.className("btnLogout"));
    }

    public WebElement getLanguageButton(){
        return driver.findElement(By.className("btnLocaleActivation"));
    }

    public WebElement getEnFromLanguage(){
        return driver.findElement(By.className("btnEN"));
    }

    public WebElement getEsFromLanguage(){
        return driver.findElement(By.className("btnES"));
    }

    public WebElement getFrFromLanguage(){
        return driver.findElement(By.className("btnFR"));
    }

    public WebElement getCnFromLanguage(){
        return driver.findElement(By.className("btnCN"));
    }

    public void waitUntilLoguoutButtonShowUp(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("btnLogout")));
    }

    public WebElement getHeaderOfPage(){
        return driver.findElement(By.className("display-2"));
    }
}
