package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AdminCitiesTests extends BasicTest {

    //Test #1: Visits the admin cities page and list cities
    //Podaci:
    //admin email: admin@admin.com
    //admin password: 12345
    //Koraci:
    //Klik na login dugme iz navigacije
    //Prijaviti se na sistem admin kredencijalima
    //Klik na admin dugme iz navigacije
    //Klik na Cities dugme iz padajuceg Admin menija
    //Verifikovati da se u url-u stranice javlja /admin/cities ruta

    @Test(priority = 10)
    public void visitsTheAdminCitiesPageAndListCities() {
        String email = "admin@admin.com";
        String password = "12345";

        navPage.getLoginLink().click();
        loginPage.getEmail().sendKeys(email);
        loginPage.getPassword().sendKeys(password);
        loginPage.getLoginButton().click();
        navPage.getAdminButton().click();
        navPage.getCitiesFromAdmin().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"),
                "[ERROR] Url don't contains /admin/cities");
    }

    //Test #2: Checks input types for create/edit new city
    //Koraci:
    //Klik na admin dugme iz navigacije
    //Klik na Cities dugme iz padajuceg Admin menija
    //Kliknuti na New Item dugme
    //Sacekati da se dijalog za kreiranje i editovanje grada pojavi
    //Verifikovati da polje za unos grada za atribut type ima tekst text

    @Test(priority = 20)
    public void checksInputTypesForCreateEditNewCity() {
        navPage.getAdminButton().click();
        navPage.getCitiesFromAdmin().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitUntilNewItemWindowShowUp();
        Assert.assertEquals(citiesPage.getNewItemNameInput().getAttribute("type"),
                "text",
                "[ERROR] New item name input type is not text");
    }

    //Test #3: Create new city
    //Podaci:
    //city: [Ime i prezime polaznika]’s city
    //Koraci:
    //
    //
    //Klik na admin dugme iz navigacije
    //Klik na Cities dugme iz padajuceg Admin menija
    //Kliknuti na New Item dugme
    //Sacekati da se dijalog za kreiranje i editovanje grada pojavi
    //Uneti ime grada u polje
    //Kliknuti na Save dugme
    //Sacekati da popu za prikaz poruke bude vidljiv
    //Verifikovati da poruka sadrzi tekst Saved successfully

    @Test(priority = 30)
    public void createNewCity() {
        String city = "Mladen Petkovic's city";

        navPage.getAdminButton().click();
        navPage.getCitiesFromAdmin().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitUntilNewItemWindowShowUp();
        citiesPage.getNewItemNameInput().sendKeys(city);
        citiesPage.getSaveButtonFromEditAndNewItemWindows().click();
        citiesPage.waitUntilSuccessSaveCityPopup();
        Assert.assertTrue(citiesPage.getSuccessSaveCityPopUp().getText().contains("Saved successfully"),
                "[ERROR] Popup window don't contains 'Saved successfully'");
    }

    //Test #4: Edit city
    //Podaci:
    //old city name: [Ime i prezime polaznika]’s city
    //new city name: [Ime i prezime polaznika]’s city Edited
    //Koraci:
    //Klik na admin dugme iz navigacije
    //Klik na Cities dugme iz padajuceg Admin menija
    //U polje za pretragu uneti staro ime grada
    //Sacekati da broj redova u tabeli bude 1
    //Kliknuti na dugme Edit iz prvog reda
    //Uneti novo ime za grad
    //Kliknuti na dugme Save
    //Sacekati da popu za prikaz poruke bude vidljiv
    //Verifikovati da poruka sadrzi tekst Saved successfully

    @Test(priority = 40)
    public void editCity() {
        String oldCity = "Mladen Petkovic's city";
        String newCity = "Mladen Petkovic's city Edited";
        navPage.getAdminButton().click();
        navPage.getCitiesFromAdmin().click();
        citiesPage.getSearchInput().sendKeys(oldCity);
        citiesPage.waitUntilShowSelectedNumberOfRows(1);
        citiesPage.getEditButton(1).click();
        citiesPage.getNewItemNameInput().click();
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL)
                .sendKeys(Keys.chord("a"))
                .keyUp(Keys.CONTROL)
                .perform();
        citiesPage.getEditNewCityInput().sendKeys(newCity);
        citiesPage.getSaveButtonFromEditAndNewItemWindows().click();
        citiesPage.waitUntilSuccessSaveCityPopup();
        Assert.assertTrue(citiesPage.getSuccessSaveCityPopUp().getText().contains("Saved successfully"),
                "[ERROR] Popup window don't contains 'Saved successfully'");
    }

    //Test #5: Search city
    //Podaci:
    //city name: [Ime i prezime polaznika]’s city Edited
    //Koraci:
    //Klik na admin dugme iz navigacije
    //Klik na Cities dugme iz padajuceg Admin menija
    //U polje za pretragu uneti staro ime grada
    //Sacekati da broj redova u tabeli bude 1
    //Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage

    @Test(priority = 50)
    public void searchCity() {
        String city = "Mladen Petkovic's city Edited";

        navPage.getAdminButton().click();
        navPage.getCitiesFromAdmin().click();
        citiesPage.getSearchInput().sendKeys(city);
        citiesPage.waitUntilShowSelectedNumberOfRows(1);
        Assert.assertEquals(citiesPage.getSelectedcCell(1, 2).getText(),
                city,
                "[ERROR] Name of the city don't mach with selected name");
    }

    //Test #6: Delete city
    //Podaci:
    //city name: [Ime i prezime polaznika]’s city Edited
    //Koraci:
    //Klik na admin dugme iz navigacije
    //Klik na Cities dugme iz padajuceg Admin menija
    //U polje za pretragu uneti staro ime grada
    //Sacekati da broj redova u tabeli bude 1
    //Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage
    //Kliknuti na dugme Delete iz prvog reda
    //Sacekati da se dijalog za brisanje pojavi
    //Kliknuti na dugme Delete iz dijaloga
    //Sacekati da popu za prikaz poruke bude vidljiv
    //Verifikovati da poruka sadrzi tekst Deleted successfully
    @Test(priority = 60)
    public void deleteCity() {
        String city = "Mladen Petkovic's city Edited";

        navPage.getAdminButton().click();
        navPage.getCitiesFromAdmin().click();
        citiesPage.getSearchInput().sendKeys(city);
        citiesPage.waitUntilShowSelectedNumberOfRows(1);
        Assert.assertEquals(citiesPage.getSelectedcCell(1, 2).getText(),
                city,
                "[ERROR] Name of the city don't mach with selected name");
        citiesPage.getDeleteButton(1).click();
        citiesPage.waitUntilDeleteWindowShow();
        citiesPage.getDeleteButtonFromDeleteWindow().click();
        citiesPage.waitUntilDeletedCityPopup();
    }
}
