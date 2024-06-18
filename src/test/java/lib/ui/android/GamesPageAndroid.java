package lib.ui.android;

import lib.ui.player.PlayerAndroid;
import lib.ui.pages.GamesPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.xpath;

public class GamesPageAndroid extends GamesPage {
    public GamesPageAndroid(PlayerAndroid playerAndroid) {
        super(playerAndroid);
        initElements();
    }

    protected void initElements() {
        MY_GAMES = $(xpath("//*[@resource-id='MyGames']"));
        FAVORITE_GAMES = $(xpath("//*[@resource-id='Favorites']"));
        ALL_GAMES = $(xpath("//*[@resource-id='AllGames']"));
        SCROLL_VIEW = $(xpath("//android.widget.ScrollView"));
        GAMES_SUMMARY_ELEMENT = $(xpath("x"));
        FILTERS = $(xpath("//*[@resource-id='SearchBarFilters'])"));
        FILTER_GO_BACK = $(xpath("//*[@content-desc='Go back']"));
        FILTER_SELECT_NBA = $(xpath("//*[@text='NBA']"));

        ALL_DISPLAYED_GAMES = $$(xpath("//android.widget.ScrollView//*[contains(@resource-id, 'GameSummary')]"));
    }
}
