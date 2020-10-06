package blog;

import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class DriverDecorator extends UIInteractionSteps {
    protected String SPACE = " ";

    private By waitForElement(By locator) {
        withTimeoutOf(Duration.ofSeconds(10)).find(locator);
        waitForCondition().until(ExpectedConditions.presenceOfElementLocated(locator));
        waitForCondition().until(ExpectedConditions.elementToBeClickable(locator));
        return locator;
    }

    protected void clickOn(By element) {
        find(waitForElement(element)).click();
    }

    protected void type(By element, String text) {
        find(waitForElement(element)).sendKeys(text);
    }

    protected boolean isDisplayed(By element) {
        return find(waitForElement(element)).isDisplayed();
    }

    protected By getElementsByAttributeAndText(String attribute, String text) {
        return By.xpath(elementsByAttributeAndText(attribute, text));
    }

    protected String elementsByAttributeAndText(String attribute, String text) {
        return String.format("//%s[contains(text(),'%s')]", attribute, text);
    }

    protected String getText(By element) {
        return find(waitForElement(element)).getText();
    }

}
