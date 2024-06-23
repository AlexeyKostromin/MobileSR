package lib.ui.android;

import lib.ui.pages.DashboardPage;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static org.openqa.selenium.By.xpath;

public class DashboardPageAndroid extends DashboardPage {

    public DashboardPageAndroid() {
        initElements();
    }

    protected void initElements() {
        WELCOME_PAGE_THE_FINAL_THIRD = $(id("@@@notImplementedYet"));
        WELCOME_PAGE_SKIP_FOR_NOW = $(xpath("//*[@text='Skip for now']"));
        WELCOME_PAGE_WELCOME_TO_THE_TEAM = $(id("@@@notImplementedYet"));
        WELCOME_PAGE_DRIVE_STRAIGHT_IT_BTN = $(id("DiveStraightInButton"));
        MAIN_MENU = $(id("drawerId"));
        SETTINGS = $(xpath("//*[@text='SETTINGS']"));
        DOWNLOADS = $(xpath("notImplementedYet"));
        PROFILE_SETTINGS = $(xpath("//*[@text='Profile Settings']"));
        CURRENT_SPORT_DROP_DOWN = $(id("textInput"));
        SPORT_BASKETBALL = $(xpath("//*[@text='Basketball']"));
        SAVE_PROFILE_SETTINGS_BTN = $(xpath("//*[@text='SAVE']"));
        MENU_BACK = $(xpath("//*[@content-desc='Go back']"));
        MENU_DASHBOARD = $(xpath("//*[@text='DASHBOARD']"));
        MENU_EDITS = $(xpath("//*[@content-desc='EDITS']"));
        MENU_GAMES = $(xpath("//*[@content-desc='GAMES']"));
        GAMES_ACTION_ITEM = $(xpath("//*[@resource-id='GamesActionItem']"));
        EDITS_ACTION_ITEM = $(xpath("//*[@resource-id='EditsActionItem']"));
        ANALYTICS_ACTION_ITEM = $(id("@@@notImplementedYet"));
    }

}
