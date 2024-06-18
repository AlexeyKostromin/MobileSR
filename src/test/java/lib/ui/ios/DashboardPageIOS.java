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
        SKIP_FOR_NOW = $(xpath("notImplementedYet"));
        DRIVE_STRAIGHT_IT_BTN = $(id("notImplementedYet"));
        MAIN_MENU = $(id("notImplementedYet"));
        SETTINGS = $(xpath("notImplementedYet"));
        PROFILE_SETTINGS = $(xpath("notImplementedYet"));
        CURRENT_SPORT_DROP_DOWN = $(id("notImplementedYet"));
        SPORT_BASKETBALL = $(xpath("notImplementedYet"));
        SAVE_PROFILE_SETTINGS_BTN = $(xpath("notImplementedYet"));
        MENU_BLOCK = $(xpath("notImplementedYet"));
        MENU_DASHBOARD = $(xpath("notImplementedYet"));
        MENU_EDITS = $(xpath("notImplementedYet"));
        MENU_GAMES = $(xpath("notImplementedYet"));
        GAMES_ACTION_ITEM = $(xpath("notImplementedYet"));
        EDIT_ACTION_ITEM = $(xpath("notImplementedYet"));
    }
}
