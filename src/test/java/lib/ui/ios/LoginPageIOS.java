package lib.ui.ios;

import com.codeborne.selenide.SelenideElement;
import lib.ui.pages.LoginPage;
import lib.ui.pages.LoginPageDef;
import lib.ui.strategy.AppActionsStrategy;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static org.openqa.selenium.By.xpath;

public class LoginPageIOS extends LoginPage {

    public LoginPageIOS(AppActionsStrategy appStrategy) {
        super(appStrategy);
        initElements();
    }

    protected void initElements() {
        PERMISSION_ALLOW_BTN = $(id(""));
        CHROME_WELCOME_PAGE = $(id(""));
        CHROME_USE_WITHOUT_ACCOUNT_BTN = $(id(""));
        UPDATE_DIALOG = $(xpath(""));
        UPDATE_INSTALL = $(xpath(""));
        UPDATE_LATER = $(xpath(""));
        LOGIN_BTN = $(id(""));
        USER_NAME_TEXT_BOX = $(id(""));
        PASSWORD_TEXT_BOX = $(id(""));
        LOGIN_FORM_BTN = $(xpath(""));
    }
}
