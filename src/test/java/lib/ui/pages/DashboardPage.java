package lib.ui.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class DashboardPage {

    public SelenideElement

            SKIP_FOR_NOW,
            DRIVE_STRAIGHT_IT_BTN,
            MAIN_MENU,
            SETTINGS,
            PROFILE_SETTINGS,
            CURRENT_SPORT_DROP_DOWN,
            SPORT_BASKETBALL,
            SAVE_PROFILE_SETTINGS_BTN,
            MENU_BLOCK,
            MENU_DASHBOARD,
            MENU_EDITS,
            MENU_GAMES,
            GAMES_ACTION_ITEM,
            EDIT_ACTION_ITEM;

    public DashboardPage() {

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
