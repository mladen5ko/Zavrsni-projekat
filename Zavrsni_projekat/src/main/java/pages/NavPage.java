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

public class NavPage {
    private WebDriver driver;

    public NavPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getHomeLink(){
        return driver.findElement(By.className("btnHome"));
    }

    public WebElement getAboutLink(){
        return driver.findElement(By.className("btnAbout"));
    }

    public WebElement getMyProfileLink(){
        return driver.findElement(By.className("btnProfile"));
    }

    public WebElement getAdminButton(){
        return driver.findElement(By.className("btnAdmin"));
    }

    public WebElement getCitiesFromAdmin(){
        return driver.findElement(By.id("list-item-189"));
    }

    public WebElement getUsersFromAdmin(){
        return driver.findElement(By.id("list-item-192"));
    }

    public WebElement getLogOutButton(){
        return driver.findElement(By.className("btnLogout"));
    }

    public WebElement getLanguageButton(){
        return driver.findElement(By.className("btnLocaleActivation"));
    }

    public WebElement getEnFromLanguage(){
        return driver.findElement(By.id("list-item-198"));
    }

    public WebElement getEsFromLanguage(){
        return driver.findElement(By.id("list-item-200"));
    }

    public WebElement getFrFromLanguage(){
        return driver.findElement(By.id("list-item-202"));
    }

    public WebElement getCnFromLanguage(){
        return driver.findElement(By.id("list-item-204"));
    }
}
