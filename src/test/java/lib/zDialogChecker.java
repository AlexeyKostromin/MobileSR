package lib;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;


public class zDialogChecker {
    private final SelenideElement dialogElement;

    public zDialogChecker(SelenideElement dialogElement) {
        this.dialogElement = dialogElement;
    }

    public Boolean waitForDialogIfExist(int timeInSeconds){
        try{
            dialogElement.should(Condition.visible, Duration.ofSeconds(timeInSeconds));
            return true;
        } catch (AssertionError e){
            return false;
        }
    }
}
