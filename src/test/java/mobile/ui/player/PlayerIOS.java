package mobile.ui.player;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class PlayerIOS extends Player {
    public PlayerIOS() {
        initElements();
    }

    protected void initElements() {
        LOADING_SPINNER = $(xpath(""));
        PLAY_PAUSE = $(xpath(""));
        PLAY_NEXT = $(xpath(""));
        PLAY_PREV = $(xpath(""));
        PLAYER_SETTINGS = $(xpath(""));
        PLAYER_TOGGLE_MUTE = $(xpath(""));
        PLAYER_EXPAND = $(xpath(""));
        PLAYER_TIME = $(xpath(""));
    }
}
