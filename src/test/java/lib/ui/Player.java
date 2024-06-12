package lib.ui;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.*;

public class Player {
    public SelenideElement
            LOADING_SPINNER = $(xpath("//android.widget.ProgressBar")),
            PLAY_PAUSE = $(xpath("//*[@resource-id='PlayerControlsPlayPause']")),
            PLAY_NEXT = $(xpath("//*[@resource-id='PlayerControlsNext']")),
            PLAY_PREV = $(xpath("//*[@resource-id='PlayerControlsPrevious']")),
            PLAYER_SETTINGS = $(xpath("//*[@resource-id='PlayerControlsSettings']")),
            PLAYER_TOGGLE_MUTE = $(xpath("//*[@resource-id='PlayerControlsToggleMute']")),
            PLAYER_EXPAND = $(xpath("/*[@resource-id='PlayerControlsExpand']")),
            PLAYER_TIME = $(xpath("//android.widget.TextView[@text=\"00:13 / 07:21\"]"));

    public void pause()  {
        try { Thread.sleep(3000); } catch (InterruptedException e) {}
        PLAY_PAUSE.click();
    }

}
