package lib.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import lib.BasePage;

public class LoginPage extends BasePage {
    protected SelenideElement
            PERMISSION_ALLOW_BTN,
            CHROME_WELCOME_PAGE,
            CHROME_USE_WITHOUT_ACCOUNT_BTN,
            UPDATE_DIALOG,
            UPDATE_INSTALL,
            UPDATE_LATER,
            USER_NAME_TEXT_BOX,
            PASSWORD_TEXT_BOX,
            LOGIN_BTN,
            LOGIN_FORM_BTN;

    public LoginPage() {

    }


    public void loginWithUpgrade(String userName, String password) {
        if (updateInstall()) {

            loginWithCredentials(userName, password);
        } else {
            loginWithCredentials(userName, password);
        }
    }

    public void loginWithCredentials(String userName, String password) {
        LOGIN_BTN.shouldBe(Condition.visible).click();
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
        if (UPDATE_DIALOG.isDisplayed()) {
            UPDATE_LATER.click();
        }
    }

    public void updateInstallSelect() {
        if (UPDATE_DIALOG.isDisplayed()) {
            UPDATE_INSTALL.click();
        }
    }

    public Boolean updateInstall() {
        int maxAttempts = 3;
        int attempts = 0;
        boolean isInstallSelected = false;

        while (attempts <= maxAttempts) {
            try {
                if (UPDATE_DIALOG.isDisplayed()) {
                    updateInstallSelect();
                    isInstallSelected = true;
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) { /* Do nothing */ } //TODO:add reliable wait for update downloaded
                    break;
                } else if (LOGIN_BTN.isDisplayed()) {
                    break;
                }
            } catch (Exception e) {
                attempts++;
                System.err.println("Failed to submit update option or find login bnt. Retrying... attempt " + attempts);
            }
        }
        if (isInstallSelected) {
            return true;
        } else {
            throw new RuntimeException("Failed to submit update option or find login bnt. Tried with attempts " + attempts);
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
                } else if (LOGIN_BTN.isDisplayed()) {
                    return;
                }
            } catch (Exception e) {
                attempts++;
                System.err.println("Failed to submit update option or find login bnt. Retrying... attempt " + attempts);
            }
        }
        throw new RuntimeException("Failed to submit update option or find login bnt. Tried with attempts " + attempts);
    }


    public void chromeOptionSelectIfDisplayed() {
        int attempts = 0;

        while (true) {
            try {
                if (USER_NAME_TEXT_BOX.isDisplayed()) {
                    return;
                } else if (CHROME_WELCOME_PAGE.isDisplayed()) {
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
