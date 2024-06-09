package tests;

import lib.ui.DashboardPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class DashboardTests extends TestBase{

    LoginPage loginPage = new LoginPage();
    DashboardPage homePageSr= new DashboardPage();

    String USERNAME = "green-basketball-men-ak-01@mailinator.com";
    String PASSWORD = "BasketBallD@01";

    @Test
    @Tag("android_local")
    @DisplayName("Search item")
    void successfulSearchTest() {
        loginPage.allowPermissions();
        loginPage.updateLater();
        loginPage.loginWithCredentials(USERNAME , PASSWORD);
        homePageSr.skipIntro();


//        homePageSr.goToProfileSettings();
//        homePageSr.setSportBasketball();
//        homePageSr.goBackToDashboardPage();
    }


}
