package tests;

import lib.PageFactory;
import lib.ui.pages.DashboardPage;
import lib.ui.pages.GamesPage;
import lib.ui.pages.LoginPage;
import lib.ui.player.Player;
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

        loginPage.allowPermissions();//move to method launch app
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
//        loginPage.allowPermissions();//move to method launch app

        loginPage.updateInstall();
        loginPage.closeAppFromAppSwitch();
        loginPage.activateApp();

        loginPage.loginWithCredentials(USERNAME, PASSWORD);

        dashboardPage.skipIntro();
        dashboardPage.openGames();

        GamesPage gamesPage = PageFactory.getGamesPage();
        gamesPage.selectAllGames();
        gamesPage.openFirstGame();
        gamesPage.player.pause();
        gamesPage.player.next();
//        Player player = new Player();
//        gamesPage.player.pause();
//        player.next();

    }

    @Test
    @Tag("android_local")
    @DisplayName("Launch app")
    void LaunchAppTest2() {
        LoginPage loginPage = PageFactory.getLoginPage();
        DashboardPage dashboardPage = PageFactory.getDashboardPage();
//        loginPage.allowPermissions();//move to method launch app

//        loginPage.updateInstall();
//        loginPage.closeAppFromAppSwitch();
//        loginPage.activateApp();

        loginPage.loginWithCredentials(USERNAME, PASSWORD);

        dashboardPage.skipIntro();
        dashboardPage.openGames();

        GamesPage gamesPage = PageFactory.getGamesPage();
        gamesPage.selectAllGames();
        gamesPage.openFirstGame();
        gamesPage.player.pause();
        gamesPage.player.next();
//        Player player = new Player();
//        gamesPage.player.pause();
//        player.next();

    }

    @Test
    @Tag("android_local")
    @DisplayName("Launch app")
    void LaunchAppIOSTest() {
        LoginPage loginPage = PageFactory.getLoginPage();
        DashboardPage dashboardPage = PageFactory.getDashboardPage();
        loginPage.closeAppFromAppSwitch();
//        loginPage.allowPermissions();//move to method launch app
        loginPage.activateApp();
//        loginPage.updateInstall();
        loginPage.terminateApp();
        loginPage.closeAppFromAppSwitch();
        loginPage.activateApp();

        loginPage.loginWithCredentials(USERNAME, PASSWORD);

        dashboardPage.skipIntro();
        dashboardPage.openGames();

        GamesPage gamesPage = PageFactory.getGamesPage();
        gamesPage.selectAllGames();
        gamesPage.openFirstGame();
        gamesPage.player.pause();
        gamesPage.player.next();
//        Player player = new Player();
//        gamesPage.player.pause();
//        player.next();

    }

}
