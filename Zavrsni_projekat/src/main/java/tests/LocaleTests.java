package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest{

    //Test #1: Set locale to ES
    //Koraci:
    //Postaviti jezik na ES
    //Verifikovati da se na stranici u hederu javlja tekst Página de aterrizaje

    @Test(priority = 10)
    public void setLocaleToES(){
        navPage.getLanguageButton().click();
        navPage.getEsFromLanguage().click();
        Assert.assertTrue(navPage.getHeaderOfPage().getText().contains("Página de aterrizaje"));
    }

    //Test #2: Set locale to EN
    //Koraci:
    //Postaviti jezik na EN
    //Verifikovati da se na stranici u hederu javlja tekst Landing

    @Test(priority = 20)
    public void setLocaleToEN(){
        navPage.getLanguageButton().click();
        navPage.getEnFromLanguage().click();
        Assert.assertTrue(navPage.getHeaderOfPage().getText().contains("Landing"));
    }

    //Test #3: Set locale to CN
    //Koraci:
    //Postaviti jezik na CN
    //Verifikovati da se na stranici u hederu javlja tekst 首页

    @Test(priority = 30)
    public void setLocaleToCN(){
        navPage.getLanguageButton().click();
        navPage.getCnFromLanguage().click();
        Assert.assertTrue(navPage.getHeaderOfPage().getText().contains("首页"));
    }

    //Test #4: Set locale to FR
    //Koraci:
    //Postaviti jezik na FR
    //Verifikovati da se na stranici u hederu javlja tekst Page d'atterrissage

    @Test(priority = 40)
    public void setLocaleToFR(){
        navPage.getLanguageButton().click();
        navPage.getFrFromLanguage().click();
        Assert.assertTrue(navPage.getHeaderOfPage().getText().contains("Page d'atterrissage"));
    }
}
