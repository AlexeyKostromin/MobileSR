package lib.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lib.BasePage;
import lib.ui.player.Player;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.xpath;

public class GamesPage extends BasePage {

    public Player player;

    public GamesPage(Player player) {
        this.player = player;
    }

    public SelenideElement
            MY_GAMES,
            FAVORITE_GAMES,
            ALL_GAMES,
            SCROLL_VIEW,
            GAMES_SUMMARY_ELEMENT,
            FILTERS,
            FILTER_GO_BACK,
            FILTER_SELECT_NBA;
    public ElementsCollection
            ALL_DISPLAYED_GAMES;
//            ALL_DISPLAYED_GAMES = $$(xpath("//android.widget.ScrollView//*[contains(@resource-id, 'GameSummary')]"));


    public void selectAllGames() {
        ALL_GAMES.click();
    }

    public void openGame() {
        ALL_GAMES.click();
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
//        SCROLL_VIEW.shouldBe(Condition.visible);
        GAMES_SUMMARY_ELEMENT.shouldBe(Condition.visible);
        var allGameElements = ALL_DISPLAYED_GAMES;
        for (SelenideElement game : allGameElements) {
            gameList.add(game);
        }
        return gameList;
    }


}
