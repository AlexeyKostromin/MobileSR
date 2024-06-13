package tests;

import lib.BasePage;
import lib.ui.DashboardPage;
import lib.ui.GamesPage;
import lib.ui.LoginPage;
import lib.ui.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class DashboardTests extends TestBase {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    String USERNAME = "green-basketball-men-ak-01@mailinator.com";
    String PASSWORD = "BasketBallD@01";

    @Test
    @Tag("android_local")
    @DisplayName("Login to home page")
    void LoginToDashboardPageTest() {
        loginPage.allowPermissions();
//        loginPage.updateLater();
        loginPage.updateInstall();
        loginPage.loginWithCredentials(USERNAME, PASSWORD);
        dashboardPage.skipIntro();
        dashboardPage.openGames();

        GamesPage gamesPage = new GamesPage();
        gamesPage.selectAllGames();
        gamesPage.openFirstGame();
        Player player = new Player();
        player.pause();

//        homePageSr.goToProfileSettings();
//        homePageSr.setSportBasketball();
//        homePageSr.goBackToDashboardPage();
    }
    @Test
    @Tag("android_local")
    @DisplayName("Launch app")
    void LaunchAppTest() {
//        loginPage.allowPermissions();
//        loginPage.updateLater();
//        loginPage.updateInstall();
        BasePage basePage = new BasePage();
        basePage.terminateApp();
//        basePage.closeApp();
        basePage.activateApp();

        loginPage.loginWithCredentials(USERNAME, PASSWORD);
        dashboardPage.skipIntro();
        dashboardPage.openGames();

        GamesPage gamesPage = new GamesPage();
        gamesPage.selectAllGames();
        gamesPage.openFirstGame();
        Player player = new Player();
        player.pause();

//        homePageSr.goToProfileSettings();
//        homePageSr.setSportBasketball();
//        homePageSr.goBackToDashboardPage();
    }

}
