package mobile.ui.android;

import mobile.ui.player.PlayerAndroid;
import mobile.ui.pages.GamesPage;

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
        GAMES_SUMMARY_ELEMENT = $(xpath("//android.view.ViewGroup[contains(@resource-id, 'GameSummary')]"));
        FILTERS = $(xpath("//*[@resource-id='SearchBarFilters']"));
        FILTER_GO_BACK = $(xpath("//*[@content-desc='Go back']"));

        ALL_DISPLAYED_GAMES = $$(xpath("//android.widget.ScrollView//*[contains(@resource-id, 'GameSummary')]"));

        FILTER_SELECT_TPL = "//*[@text='{LEAGUE}']";
    }


}