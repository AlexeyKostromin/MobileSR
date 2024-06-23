package mobile.platformActions;

import java.time.Duration;

public interface PlatformActionsStrategy {
    void activateApp();

    void terminateApp();

    void closeAppFromAppSwitch();

    void pressHomeButton();

    void runAppInBackground(Duration duration);

    void installApp();

    void uninstallApp();
}
