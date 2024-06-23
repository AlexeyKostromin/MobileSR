package mobile.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import mobile.ui.base.BasePage;
import mobile.ui.player.Player;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class GamesPage extends BasePage {

    public Player player;

    public GamesPage(Player player) {
        this.player = player;
    }

    protected SelenideElement
            MY_GAMES,
            FAVORITE_GAMES,
            ALL_GAMES,
            SCROLL_VIEW,
            GAMES_SUMMARY_ELEMENT,
            FILTERS,
            FILTER_GO_BACK;

    protected ElementsCollection
            ALL_DISPLAYED_GAMES;
    protected String FILTER_SELECT_TPL;

    public void selectAllGames() {
        ALL_GAMES.click();
    }

    public void applyFilter(String league) {
        FILTERS.click();
        selectLeague(league);
        FILTER_GO_BACK.click();
    }

    private void selectLeague(String league) {
        var xpathLeague = FILTER_SELECT_TPL.replace("{LEAGUE}", league);
        var filter = $(xpath(xpathLeague));
        filter.shouldBe(Condition.visible).click();
    }

    public void openFirstGame() {
        var gameList = getListOfAllDisplayedGames();
        if (!gameList.isEmpty()) {
            gameList.get(0).click();
        } else {
            throw new RuntimeException("Game list was empty!");
        }
    }

    public List<SelenideElement> getListOfAllDisplayedGames() {
        List<SelenideElement> gameList = new ArrayList<>();
        GAMES_SUMMARY_ELEMENT.shouldBe(Condition.visible);
        var allGameElements = ALL_DISPLAYED_GAMES;
        for (SelenideElement game : allGameElements) {
            gameList.add(game);
        }
        return gameList;
    }


}
