package lib.ui.strategy;

import java.time.Duration;

public interface AppActionsStrategy {
    void activateApp();

    void terminateApp();

    void closeAppFromAppSwitch();

    void runAppInBackground(Duration duration);
}
