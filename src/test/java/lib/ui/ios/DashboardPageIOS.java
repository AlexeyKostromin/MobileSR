package lib.ui.ios;

import lib.ui.pages.DashboardPage;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static org.openqa.selenium.By.xpath;

public class DashboardPageIOS extends DashboardPage {


    public DashboardPageIOS() {
        initElements();
    }

    protected void initElements() {
        WELCOME_PAGE_THE_FINAL_THIRD = $(id("THE FINAL THIRD"));
        WELCOME_PAGE_SKIP_FOR_NOW = $(id("Skip for now"));
        WELCOME_PAGE_WELCOME_TO_THE_TEAM = $(id("WELCOME TO THE TEAM"));
        WELCOME_PAGE_DRIVE_STRAIGHT_IT_BTN = $(id("DiveStraightInButton"));
        MAIN_MENU = $(id("drawerId"));
        SETTINGS = $(xpath("//XCUIElementTypeButton[@name='SETTINGS']"));
        DOWNLOADS = $(xpath("//XCUIElementTypeButton[contains(@name, 'DOWNLOADS')]"));
        PROFILE_SETTINGS = $(id("Profile Settings Button"));
        CURRENT_SPORT_DROP_DOWN = $(id("touchable"));
        SPORT_BASKETBALL = $(id("\uDB80\uDD2C Basketball"));
        SAVE_PROFILE_SETTINGS_BTN = $(id("SAVE"));
        MENU_BACK = $(id("Go back"));
        MENU_DASHBOARD = $(xpath("//XCUIElementTypeButton[@name='DASHBOARD']"));
        MENU_EDITS = $(xpath("//XCUIElementTypeButton[@name='EDITS']"));
        MENU_GAMES = $(xpath("//XCUIElementTypeButton[@name='GAMES']"));
        GAMES_ACTION_ITEM = $(id("GamesActionItem"));
        EDITS_ACTION_ITEM = $(id("EditsActionItem"));
        ANALYTICS_ACTION_ITEM = $(id("AnalyticsActionItem"));
    }
}
