package mobile.factory;

import mobile.ui.player.PlayerAndroid;
import mobile.ui.player.PlayerIOS;
import mobile.ui.android.DashboardPageAndroid;
import mobile.ui.android.GamesPageAndroid;
import mobile.ui.android.LoginPageAndroid;
import mobile.ui.ios.DashboardPageIOS;
import mobile.ui.ios.GamesPageIOS;
import mobile.ui.ios.LoginPageIOS;
import mobile.ui.pages.DashboardPage;
import mobile.ui.pages.GamesPage;
import mobile.ui.pages.LoginPage;

import static mobile.configs.Platform.isAndroid;
import static mobile.configs.Platform.isIOS;

public class PageFactory {

//    public static PlatformActions getBasePage() {
//        if (isAndroid()) {
//            return new PlatformActions(this);
//        } else if (isIOS()) {
//            return new PlatformActions(this);
//        } else {
//            throw new IllegalStateException("Unsupported platform");
//        }
//    }

    public static LoginPage getLoginPage() {
        if (isAndroid()) {
            return new LoginPageAndroid();
        } else if (isIOS()) {
            return new LoginPageIOS();
        } else {
            throw new IllegalStateException("Unsupported platform");
        }
    }

    public static DashboardPage getDashboardPage() {
        if (isAndroid()) {
            return new DashboardPageAndroid();
        } else if (isIOS()) {
            return new DashboardPageIOS();
        } else {
            throw new IllegalStateException("Unsupported platform");
        }
    }

    public static GamesPage getGamesPage() {
        if (isAndroid()) {
            return new GamesPageAndroid(new PlayerAndroid());
        } else if (isIOS()) {
            return new GamesPageIOS(new PlayerIOS());
        } else {
            throw new IllegalStateException("Unsupported platform");
        }
    }

}
