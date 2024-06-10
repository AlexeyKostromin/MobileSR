package lib.ui;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static org.openqa.selenium.By.xpath;

public class LoginPage {
    public SelenideElement
            PERMISSION_ALLOW_BTN = $(id("com.android.permissioncontroller:id/permission_allow_button")),
            CHROME_WELCOME_PAGE = $(id("com.android.chrome:id/fre_pager")),
            CHROME_USE_WITHOUT_ACCOUNT_BTN = $(id("com.android.chrome:id/signin_fre_dismiss_button")),
            UPDATE_DIALOG = $(xpath("//android.widget.TextView[@text='Update available']")),
            UPDATE_INSTALL = $(xpath("//android.widget.Button[@text='INSTALL']")),
            UPDATE_LATER = $(xpath("//android.widget.Button[@text='LATER']")),
            LOGIN_BTN = $(id("login-button")),
            USER_NAME_TEXT_BOX = $(id("Username")),
            PASSWORD_TEXT_BOX = $(id("Password")),
            LOGIN_FORM_BTN = $(xpath("//*[@text='Login']"));


    public void loginWithCredentials(String userName, String password) {
        LOGIN_BTN.click();
        chromeOptionSelectIfDisplayed();
        USER_NAME_TEXT_BOX.click();
        USER_NAME_TEXT_BOX.sendKeys(userName);
        PASSWORD_TEXT_BOX.click();
        PASSWORD_TEXT_BOX.sendKeys(password);
        LOGIN_FORM_BTN.click();
    }

    public void allowPermissions() {
        if (PERMISSION_ALLOW_BTN.exists()) {
            try {
                PERMISSION_ALLOW_BTN.click();
            } catch (Exception e) {
                System.err.println("Failed to click the allow permissions button");
                e.printStackTrace();
            }
        } else {
            System.out.println("There was no allow permissions dialog");
        }
    }

    private void updateLaterSelect() {
        if (UPDATE_DIALOG.isDisplayed()){
            UPDATE_LATER.click();
        }
    }

    public void updateInstall() {
        if (UPDATE_DIALOG.isDisplayed()){
            UPDATE_INSTALL.click();
        }
    }

    public void updateLater() {
        int maxAttempts = 3;
        int attempts = 0;

        while (attempts <= maxAttempts) {
            try {
                if (UPDATE_DIALOG.isDisplayed()) {
                    updateLaterSelect();
                    return;
                } else if (LOGIN_BTN.isDisplayed()){
                    return;
                }
            } catch (Exception e) {
                attempts++;
                System.err.println("Failed to submit update option or find login bnt. Retrying... attempt " + attempts);
            }
        }
        throw new RuntimeException("Failed to submit update option or find login bnt. Tried with attempts " + attempts);
    }


    public void chromeOptionSelectIfDisplayed(){
        int attempts = 0;

        while (true){
            try {
                if (USER_NAME_TEXT_BOX.isDisplayed()){
                    return;
                } else if (CHROME_WELCOME_PAGE.isDisplayed()){
                    chromeUseWithoutAccountSelect();
                    return;
                }
            } catch (Exception e) {
                attempts++;
                System.err.println("Failed to submit chromeUseWithoutAccount option or find login form. Retrying... attempt " + attempts);
                if (attempts >= 3) {
                    throw new RuntimeException("Failed to submit chromeUseWithoutAccount option or find login form. Tried with attempts " + attempts);
                }
            }
        }
    }

    private void chromeUseWithoutAccountSelect() {
        if (CHROME_WELCOME_PAGE.exists()) {
            try {
                CHROME_USE_WITHOUT_ACCOUNT_BTN.click();
            } catch (Exception e) {
                System.err.println("Failed to click the 'Use without an account' button");
                e.printStackTrace();
            }
        } else {
            System.out.println("There was no Chrome welcome page dialog");
        }
    }


}
