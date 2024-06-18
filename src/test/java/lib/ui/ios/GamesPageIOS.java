package lib.ui.ios;

import lib.ui.player.PlayerIOS;
import lib.ui.pages.GamesPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class GamesPageIOS extends GamesPage {
    public GamesPageIOS(PlayerIOS playerIOS) {
        super(playerIOS);
        initElements();
    }

    protected void initElements() {
        MY_GAMES = $(id("MyGames"));
        FAVORITE_GAMES = $(id("Favorites"));
        ALL_GAMES = $(id("AllGames"));
        SCROLL_VIEW = $(id(""));
        GAMES_SUMMARY_ELEMENT = $(xpath("//XCUIElementTypeOther[contains(@name, 'GameSummary')]"));
        FILTERS = $(id("SearchBarFilters"));
        FILTER_GO_BACK = $(id("Go back"));
        FILTER_SELECT_NBA = $(id("NBA"));

        ALL_DISPLAYED_GAMES = $$(xpath("//XCUIElementTypeOther[contains(@name, 'GameSummary')]"));
    }
}
