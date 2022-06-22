package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BasicTest {

    private WebDriverWait wait;

    //Test #1: Visits the login page
    //Koraci:
    //Postaviti EN jezik stranice
    //Klik na login dugme iz navigacije
    //Verifikovati da se u url-u stranice javlja ruta /login

    @Test(priority = 10)
    public void visitsTheLoginPage() {
        navPage.getLanguageButton().click();
        navPage.getEnFromLanguage().click();
        navPage.getLoginLink().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "[ERROR] Url dont contains /login");
    }
    //Test #2: Checks input types
    //Koraci:
    //Klik na login dugme iz navigacije
    //Verifikovati da polje za unos emaila za atribut type ima vrednost email
    //Verifikovati da polje za unos lozinke za atribut type ima vrednost password

    @Test(priority = 20)
    public void checksInputTypes() {
        navPage.getLoginLink().click();
        Assert.assertEquals(loginPage.getEmail().getAttribute("type"),
                "email",
                "[ERROR] Email input type is not email");

        Assert.assertEquals(loginPage.getPassword().getAttribute("type"),
                "password",
                "[EROOR] Password input type is not password");
    }

    //Test #3: Displays errors when user does not exist
    //Podaci:
    //email: non-existing-user@gmal.com
    //password: password123
    //Koraci:
    //Klik na login dugme iz navigacije
    //Popuniti login formu podacima za logovanje
    //Klik na login dugme
    //Sacekati da popu za prikaz greske bude vidljiv
    //Verifikovati da greska sadrzi poruku User does not exists
    //Verifikovati da se u url-u stranice javlja /login ruta

    @Test(priority = 30)
    public void displaysErrorsWhenUserDoesNotExist() {
        String email = "non-existing-user@gmal.com";
        String password = "password123";

        navPage.getLoginLink().click();
        loginPage.getEmail().sendKeys(email);
        loginPage.getPassword().sendKeys(password);
        loginPage.getLoginButton().click();
        messagePopUpPage.waitUntilErrorWindowShowUp();
        Assert.assertTrue(messagePopUpPage.getErrorWindow().getText().contains("User does not exists"),
                "[ERROR] PopUp massage 'User does not exists' do not show");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "[ERROR] Url dont contains /login");
    }

    //Test #4: Displays errors when password is wrong
    //Podaci:
    //email: admin@admin.com
    //password: password123
    //Koraci:
    //Klik na login dugme iz navigacije
    //Popuniti login formu podacima za logovanje
    //Klik na login dugme
    //Sacekati da popu za prikaz poruke bude vidljiv
    //Verifikovati da greska sadrzi poruku Wrong password
    //Verifikovati da se u url-u stranice javlja /login ruta

    @Test(priority = 40)
    public void displaysErrorsWhenPasswordIsWrong() {
        String email = "admin@admin.com";
        String password = "password123";

        navPage.getLoginLink().click();
        loginPage.getEmail().sendKeys(email);
        loginPage.getPassword().sendKeys(password);
        loginPage.getLoginButton().click();

        messagePopUpPage.waitUntilErrorWindowShowUp();
        Assert.assertTrue(messagePopUpPage.getErrorWindow().getText().contains("Wrong password"),
                "[ERROR] PopUp massage 'User does not exists' do not show");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "[ERROR] Url dont contains /login");
    }

    //Test #5: Login
    //Podaci:
    //email: admin@admin.com
    //password: 12345
    //Koraci:
    //Klik na login dugme iz navigacije
    //Popuniti login formu podacima za logovanje
    //Verifikovati da se u url-u stranice javlja /home ruta

    @Test(priority = 50)
    public void login(){
        String email = "admin@admin.com";
        String password = "12345";

        navPage.getLoginLink().click();
        loginPage.getEmail().sendKeys(email);
        loginPage.getPassword().sendKeys(password);
        loginPage.getLoginButton().click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/home"));
    }

    //Test #6: Logout
    //Koraci:
    //Verifikovati da je dugme logout vidljivo na stranici
    //Kliknuti na logout dugme

    @Test(priority = 60)
    public void logout() {
        Assert.assertTrue(navPage.getLogOutButton().isDisplayed(),
                "[ERROR] Logout Button do not exist");
        navPage.getLogOutButton().click();
    }
}
