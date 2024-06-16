package lib.ui.ios;

import lib.ui.player.PlayerIOS;
import lib.ui.pages.GamesPage;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class GamesPageIOS extends GamesPage {
    public GamesPageIOS(PlayerIOS playerIOS) {
        super(playerIOS);
        initElements();
    }

    protected void initElements() {
        MY_GAMES = $(xpath(""));
        FAVORITE_GAMES = $(xpath(""));
        ALL_GAMES = $(xpath(""));
        SCROLL_VIEW = $(xpath(""));
        FILTERS = $(xpath(""));
        FILTER_GO_BACK = $(xpath(""));
        FILTER_SELECT_NBA = $(xpath(""));
    }
}
