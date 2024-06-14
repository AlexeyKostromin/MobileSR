package lib.ui.pages;

import com.codeborne.selenide.SelenideElement;
import lib.ui.strategy.AndroidAppStrategy;
import lib.ui.strategy.AppActionsStrategy;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static org.openqa.selenium.By.xpath;

public class DashboardPage {

    public SelenideElement

            SKIP_FOR_NOW = $(xpath("//*[@text='Skip for now']")),
            DRIVE_STRAIGHT_IT_BTN = $(id("DiveStraightInButton")),
            MAIN_MENU = $(id("drawerId")),
            SETTINGS = $(xpath("//*[@text='SETTINGS']")),
            PROFILE_SETTINGS = $(xpath("//*[@text='Profile Settings']")),
            CURRENT_SPORT_DROP_DOWN = $(id("textInput")),
            SPORT_BASKETBALL = $(xpath("//*[@text='Basketball']")),
            SAVE_PROFILE_SETTINGS_BTN = $(xpath("//*[@text='SAVE']")),
            MENU_BLOCK = $(xpath("//*[@content-desc='Go back']")),
            MENU_DASHBOARD = $(xpath("//*[@text='DASHBOARD']")),
            MENU_EDITS = $(xpath("//*[@content-desc='EDITS']")),
            MENU_GAMES = $(xpath("//*[@content-desc='GAMES']")),
            GAMES_ACTION_ITEM = $(xpath("//*[@resource-id='GamesActionItem']")),
            EDIT_ACTION_ITEM = $(xpath("//*[@resource-id='EditsActionItem']"));

    public DashboardPage(AppActionsStrategy appActionsStrategy) {

    }


    public void skipIntro() {
        SKIP_FOR_NOW.click();
        DRIVE_STRAIGHT_IT_BTN.click();
    }

    public void goToProfileSettings() {
        MAIN_MENU.click();
        SETTINGS.click();
        PROFILE_SETTINGS.click();
    }

    public void setSportBasketball() {
        CURRENT_SPORT_DROP_DOWN.click();
        SPORT_BASKETBALL.click();
        SAVE_PROFILE_SETTINGS_BTN.click();
    }

    public void goBackToDashboardPage() {
        MENU_BLOCK.click();
        MENU_DASHBOARD.click();
    }
    public void openEdits() {
        EDIT_ACTION_ITEM.click();
    }

    public void openGames() {
        GAMES_ACTION_ITEM.click();
    }


}
