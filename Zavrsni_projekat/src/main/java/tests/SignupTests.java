package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest {

    //Test #1: Visits the signup page
    //Koraci:
    //Klik na sign up dugme iz navigacije
    //Verifikovati da se u url-u stranice javlja /signup ruta
    @Test(priority = 10)
    public void visitsTheSignupPage() {
        navPage.getSignUplink().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "[ERROR] Url don't contains /signup");
    }

    //Test #2: Checks input types
    //Koraci:
    //Klik na sign up dugme iz navigacije
    //Verifikovati da polje za unos emaila za atribut type ima vrednost email
    //Verifikovati da polje za unos lozinke za atribut type ima vrednost password
    //Verifikovati da polje za unos lozinke za potvrdu za atribut type ima vrednost password
    @Test(priority = 20)
    public void checksInputTypes() {
        navPage.getSignUplink().click();
        Assert.assertEquals(signupPage.getEmail().getAttribute("type"),
                "email",
                "[ERROR] Email input type is not email");
        Assert.assertEquals(signupPage.getPassword().getAttribute("type"),
                "password",
                "[ERROR] Password input type is not password");
        Assert.assertEquals(signupPage.getConfirmPassword().getAttribute("type"),
                "password",
                "[ERROR] Confirm password input type is not password");
    }

    //Test #3: Displays errors when user already exists
    //Podaci:
    //name: Another User
    //email: admin@admin.com
    //password: 12345
    //confirm password: 12345
    //Koraci:
    //Klik na sign up dugme iz navigacije
    //Verifikovati da se u url-u stranice javlja /signup ruta
    //Popuniti formu za registraciju podacima
    //Klik na sign up dugme
    //Sacekati da popu za prikaz poruke bude vidljiv
    //Verifikovati da greska sadrzi poruku E-mail already exists
    //Verifikovati da se u url-u stranice javlja /signup ruta
    @Test(priority = 30)
    public void displaysErrorsWhenUserAlreadyExists() {
        String name = "Another User";
        String email = "admin@admin.com";
        String password = "12345";
        String confPass = "12345";

        navPage.getSignUplink().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "[ERROR] Url don't contains /signup");
        signupPage.getName().sendKeys(name);
        signupPage.getEmail().sendKeys(email);
        signupPage.getPassword().sendKeys(password);
        signupPage.getConfirmPassword().sendKeys(confPass);
        signupPage.getSignupButton().click();
        messagePopUpPage.waitUntilErrorWindowShowUp();
        Assert.assertTrue(messagePopUpPage.getErrorWindow().getText().contains("E-mail already exists"),
                "[ERROR] PopUp massage 'E-mail already exists");
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "[ERROR] Url don't contains /signup");
    }

    //Test #4: Signup
    //Podaci:
    //name: Ime i prezime polaznika
    //email template: ime.prezime@itbootcamp.rs
    //password: 12345
    //confirm password: 12345
    //Koraci:
    //Klik na sign up dugme iz navigacije
    //Popuniti formu podacima za registraciju
    //Klik na sign up dugme
    //Verifikovati da dijalog za obavestenje sadrzi tekst IMPORTANT: Verify your account
    //Kliknuti na Close dugme iz dijaloga
    //Kliknuti na logout

    @Test(priority = 40)
    public void signup() {
        String name = "Mladen Petkovic";
        String email = "petkovic.mladen@itbootcamp.rs";
        String password = "12345";
        String confPass = "12345";

        navPage.getSignUplink().click();
        signupPage.getName().sendKeys(name);
        signupPage.getEmail().sendKeys(email);
        signupPage.getPassword().sendKeys(password);
        signupPage.getConfirmPassword().sendKeys(confPass);
        signupPage.getSignupButton().click();
        messagePopUpPage.waitUntilVerifyAccountWindowShowUp();
        messagePopUpPage.closeButtonFromPopupWindow().click();
        navPage.getLogOutButton().click();

    }
}
