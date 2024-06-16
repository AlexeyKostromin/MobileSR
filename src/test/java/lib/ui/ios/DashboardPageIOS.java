package lib.ui.ios;

import lib.ui.pages.DashboardPage;
import lib.ui.strategy.AppActionsStrategy;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static org.openqa.selenium.By.xpath;

public class DashboardPageIOS extends DashboardPage {
    public DashboardPageIOS() {
        initElements();
    }

    protected void initElements() {
        SKIP_FOR_NOW = $(xpath(""));
        DRIVE_STRAIGHT_IT_BTN = $(id(""));
        MAIN_MENU = $(id(""));
        SETTINGS = $(xpath(""));
        PROFILE_SETTINGS = $(xpath(""));
        CURRENT_SPORT_DROP_DOWN = $(id(""));
        SPORT_BASKETBALL = $(xpath(""));
        SAVE_PROFILE_SETTINGS_BTN = $(xpath(""));
        MENU_BLOCK = $(xpath(""));
        MENU_DASHBOARD = $(xpath(""));
        MENU_EDITS = $(xpath(""));
        MENU_GAMES = $(xpath(""));
        GAMES_ACTION_ITEM = $(xpath(""));
        EDIT_ACTION_ITEM = $(xpath(""));
    }
}
