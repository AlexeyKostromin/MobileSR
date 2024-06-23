package mobile.ui.ios;

import com.codeborne.selenide.Condition;
import mobile.ui.pages.LoginPage;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static org.openqa.selenium.By.xpath;

public class LoginPageIOS extends LoginPage {

    public LoginPageIOS() {
        initElements();
    }

    protected void initElements() {
        PERMISSION_ALLOW_BTN = $(id("notImplementedYet"));
        CHROME_WELCOME_PAGE = $(id("notImplementedYet"));
        CHROME_USE_WITHOUT_ACCOUNT_BTN = $(id("notImplementedYet"));
        UPDATE_DIALOG = $(xpath("//XCUIElementTypeAlert"));
        UPDATE_INSTALL = $(xpath("notImplementedYet"));
        UPDATE_LATER = $(xpath("notImplementedYet"));
        UPDATE_CONTINUE = $(id("Continue"));
        LOGIN_BTN = $(id("login-button"));
        USER_NAME_TEXT_BOX = $(xpath("//XCUIElementTypeTextField[@value='Username']"));
        PASSWORD_TEXT_BOX = $(xpath("//XCUIElementTypeSecureTextField[@value='Password']"));
        LOGIN_FORM_BTN = $(id("Login"));
        VERSION = $(xpath("//XCUIElementTypeStaticText[contains(@name, 'Version')]"));
    }
    @Override
    public String getCurrentVersion() {
        VERSION.shouldBe(Condition.visible);
        return VERSION.attr("name");
    }
}
