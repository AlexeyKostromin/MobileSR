package lib.ui.player;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.*;

public class Player {
    public SelenideElement
            LOADING_SPINNER,
            PLAY_PAUSE,
            PLAY_NEXT,
            PLAY_PREV,
            PLAYER_SETTINGS,
            PLAYER_TOGGLE_MUTE,
            PLAYER_EXPAND,
            PLAYER_TIME;

    public void pause() {
        try {
            Thread.sleep(4000); //TODO:update with proper wait of start a playback
        } catch (InterruptedException e) {
        }
        PLAY_PAUSE.click();
    }

    public void next() {
        PLAY_NEXT.click();
    }

}
