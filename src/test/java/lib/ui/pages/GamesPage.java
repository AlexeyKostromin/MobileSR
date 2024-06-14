package lib.ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lib.BasePage;
import lib.ui.strategy.AppActionsStrategy;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class GamesPage extends BasePage {
    public SelenideElement

            MY_GAMES = $(xpath("//*[@resource-id='MyGames']")),
            FAVORITE_GAMES = $(xpath("//*[@resource-id='Favorites']")),
            ALL_GAMES = $(xpath("//*[@resource-id='AllGames']")),
            FILTERS = $(xpath("//*[@resource-id='SearchBarFilters'])")),
            FILTER_GO_BACK = $(xpath("//*[@content-desc='Go back']")),
            FILTER_SELECT_NBA = $(xpath("//*[@text='NBA']"));

    public ElementsCollection
            ALL_DISPLAYED_GAMES = $$(xpath("//android.widget.ScrollView//*[contains(@resource-id, 'GameSummary')]"));

    public GamesPage(AppActionsStrategy appStrategy) {
        super(appStrategy);
    }


    public void selectAllGames() {
        ALL_GAMES.click();
    }

    public void openGame() {
        ALL_GAMES.click();
    }

    public void openFirstGame() {
        //TODO: wait list loaded
        var gameList = getListOfAllDisplayedGames();
        if (!gameList.isEmpty()) {
            gameList.get(0).click();
        } else {
            throw new RuntimeException("Game list was empty!");
        }
    }

    public List<SelenideElement> getListOfAllDisplayedGames() {
        List<SelenideElement> gameList = new ArrayList<>();
        var allGameElements = ALL_DISPLAYED_GAMES;
        for (SelenideElement game : allGameElements) {
            gameList.add(game);
        }
        return gameList;
    }


}
