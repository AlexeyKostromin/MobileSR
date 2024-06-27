package tests;

import mobile.factory.PageFactory;
import mobile.platformActions.base.PlatformActions;
import mobile.ui.pages.DashboardPage;
import mobile.ui.pages.GamesPage;
import mobile.ui.pages.LoginPage;
import mobile.ui.player.Player;
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
        loginPage.updateApp();
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

        loginPage.updateApp();

        loginPage.loginWithCredentials(USERNAME, PASSWORD);

        dashboardPage.skipIntro();
        dashboardPage.openGames();

        GamesPage gamesPage = PageFactory.getGamesPage();
        gamesPage.selectAllGames();
        gamesPage.applyFilter("NBA");
        gamesPage.openFirstGame();
        gamesPage.player.pause();
        gamesPage.player.next();

    }
    @Test
    @Tag("android_local")
    @DisplayName("Launch app")
    void AttachToAppTest() {
        LoginPage loginPage = PageFactory.getLoginPage();
//        loginPage.updateApp();
//        DashboardPage dashboardPage = loginPage.loginWithCredentials(USERNAME, PASSWORD);
        DashboardPage dashboardPage = PageFactory.getDashboardPage();
        dashboardPage.skipIntro();

//        DashboardPage dashboardPage = PageFactory.getDashboardPage();
        GamesPage gamesPage = dashboardPage.openGames();

        gamesPage.selectAllGames();
        gamesPage.applyFilter("NBA");
        gamesPage.openFirstGame();
        gamesPage.player.pause();
        gamesPage.player.next();
    }

    @Test
    @Tag("android_local")
    @DisplayName("Launch app")
    void InstallAndAttachToAppTest() {
        PlatformActions platformActions = new PlatformActions();
        platformActions.installApp();
        platformActions.activateApp();

        LoginPage loginPage = PageFactory.getLoginPage();
        loginPage.updateApp();
        DashboardPage dashboardPage = loginPage.loginWithCredentials(USERNAME, PASSWORD);

        dashboardPage.skipIntro();

        GamesPage gamesPage = dashboardPage.openGames();

        gamesPage.selectAllGames();
        gamesPage.applyFilter("NBA");
        gamesPage.openFirstGame();
        gamesPage.player.pause();
        gamesPage.player.next();

    }


    @Test
    @Tag("android_local")
    @DisplayName("Launch app")
    void LaunchAppIOSTest() {
        String USERNAME_STAGING = "hawks_staffmax@mailinator.com";
        String PASSWORD_STAGING = "Synergy2022@RANGe";

        PlatformActions platformActions = new PlatformActions();
//        platformActions.installApp();
        platformActions.activateApp();

        LoginPage loginPage = PageFactory.getLoginPage();
        loginPage.updateApp();
        loginPage.loginWithCredentials(USERNAME_STAGING, PASSWORD_STAGING);

        DashboardPage dashboardPage = PageFactory.getDashboardPage();
        dashboardPage.skipIntro();
        dashboardPage.openGames();

        GamesPage gamesPage = PageFactory.getGamesPage();
        gamesPage.selectAllGames();
        gamesPage.openFirstGame();
        gamesPage.player.pause();
        gamesPage.player.next();
    }

    @Test
    @Tag("android_remote")
    @DisplayName("Launch app Android on MAC")
    void LaunchAppAndroidOnMacTest() {
//        String USERNAME_STAGING = "hawks_staffmax@mailinator.com";
//        String PASSWORD_STAGING = "Synergy2022@RANGe";

        PlatformActions platformActions = new PlatformActions();
        platformActions.installApp();
        platformActions.activateApp();

        LoginPage loginPage = PageFactory.getLoginPage();
        loginPage.updateApp();
        loginPage.loginWithCredentials(USERNAME, PASSWORD);

        DashboardPage dashboardPage = PageFactory.getDashboardPage();
        dashboardPage.skipIntro();
        dashboardPage.openGames();

        GamesPage gamesPage = PageFactory.getGamesPage();
        gamesPage.selectAllGames();
        gamesPage.openFirstGame();
        gamesPage.player.pause();
        gamesPage.player.next();
    }

    @Test
    @Tag("android_local")
    @DisplayName("Launch app")
    void InstallAppIOSTest() {
        String USERNAME_STAGING = "hawks_staffmax@mailinator.com";
        String PASSWORD_STAGING = "Synergy2022@RANGe";

        PlatformActions platformActions = new PlatformActions();
        platformActions.installApp();
        platformActions.activateApp();

        LoginPage loginPage = PageFactory.getLoginPage();
        loginPage.updateApp();
        DashboardPage dashboardPage = loginPage.loginWithCredentials(USERNAME_STAGING, PASSWORD_STAGING);

        dashboardPage.skipIntro();
        dashboardPage.openGames();

        GamesPage gamesPage = PageFactory.getGamesPage();
        gamesPage.selectAllGames();
        gamesPage.applyFilter("NBA");
        gamesPage.openFirstGame();
        gamesPage.player.pause();
        gamesPage.player.next();
    }

}
