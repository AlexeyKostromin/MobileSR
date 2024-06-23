package mobile.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import mobile.ui.base.BasePage;
import mobile.factory.PageFactory;

public class DashboardPage extends BasePage {

    public SelenideElement
            WELCOME_PAGE_THE_FINAL_THIRD,
            WELCOME_PAGE_SKIP_FOR_NOW,
            WELCOME_PAGE_WELCOME_TO_THE_TEAM,
            WELCOME_PAGE_DRIVE_STRAIGHT_IT_BTN,
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
        var welcomeFinalThirdPage = WELCOME_PAGE_THE_FINAL_THIRD;
        welcomeFinalThirdPage.shouldBe(Condition.visible);
        WELCOME_PAGE_SKIP_FOR_NOW.click();
        welcomeFinalThirdPage.shouldBe(Condition.disappear);

        var welcomeToTheTeamPage = WELCOME_PAGE_WELCOME_TO_THE_TEAM;
        welcomeToTheTeamPage.shouldBe(Condition.exist);
        WELCOME_PAGE_DRIVE_STRAIGHT_IT_BTN.shouldBe(Condition.exist).click();
        welcomeToTheTeamPage.shouldBe(Condition.not(Condition.visible));
//        tryClickElementAndWaitNotVisible(WELCOME_PAGE_DRIVE_STRAIGHT_IT_BTN, 3);
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
