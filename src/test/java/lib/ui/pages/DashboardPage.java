package lib.ui.pages;

import com.codeborne.selenide.SelenideElement;
import lib.PageFactory;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class DashboardPage {

    public SelenideElement

            SKIP_FOR_NOW,
            DRIVE_STRAIGHT_IT_BTN,
            MAIN_MENU,
            SETTINGS,
            DOWNLOADS,
            PROFILE_SETTINGS,
            CURRENT_SPORT_DROP_DOWN,
            SPORT_BASKETBALL,
            SAVE_PROFILE_SETTINGS_BTN,
            MENU_BACK,
            MENU_DASHBOARD,
            MENU_EDITS,
            MENU_GAMES,
            GAMES_ACTION_ITEM,
            EDITS_ACTION_ITEM,
            ANALYTICS_ACTION_ITEM;

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
        MENU_BACK.click();
        MENU_DASHBOARD.click();
    }

    public void openEdits() {
        EDITS_ACTION_ITEM.click();
    }

    public GamesPage openGames() {
        GAMES_ACTION_ITEM.click();
        return PageFactory.getGamesPage();
    }


}
