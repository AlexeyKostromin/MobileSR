package tests;

import lib.PageFactory;
import lib.ui.pages.DashboardPage;
import lib.ui.pages.GamesPage;
import lib.ui.pages.LoginPage;
import lib.ui.pages.LoginPageDef;
import lib.ui.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class DashboardTests extends TestBase {



    String USERNAME = "green-basketball-men-ak-01@mailinator.com";
    String PASSWORD = "BasketBallD@01";

    @Test
    @Tag("android_local")
    @DisplayName("Login to home page")
    void LoginToDashboardPageTest() {
        LoginPage loginPage = PageFactory.getLoginPage();
        DashboardPage dashboardPage = PageFactory.getDashboardPage();

        loginPage.allowPermissions();
//        loginPage.updateLater();
        loginPage.updateInstall();
        loginPage.loginWithCredentials(USERNAME, PASSWORD);
        dashboardPage.skipIntro();
        dashboardPage.openGames();

        GamesPage gamesPage = PageFactory.getGamesPage();
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
        LoginPage loginPage = PageFactory.getLoginPage();
        DashboardPage dashboardPage = PageFactory.getDashboardPage();
//        loginPage.allowPermissions();
//        loginPage.updateLater();
        loginPage.updateInstall();
//        BasePage basePage = PageFactory.getBasePage();
        loginPage.closeAppFromAppSwitch();
        loginPage.activateApp();

        loginPage.loginWithCredentials(USERNAME, PASSWORD);

        dashboardPage.skipIntro();
        dashboardPage.openGames();

        GamesPage gamesPage = PageFactory.getGamesPage();
        gamesPage.selectAllGames();
        gamesPage.openFirstGame();
        Player player = new Player();
        player.pause();

//        homePageSr.goToProfileSettings();
//        homePageSr.setSportBasketball();
//        homePageSr.goBackToDashboardPage();
    }

}
