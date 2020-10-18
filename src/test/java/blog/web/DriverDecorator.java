package blog.web;

import blog.helpers.Log;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;



public class DriverDecorator extends UIInteractionSteps {
    protected String SPACE = " ";
    public boolean isUserLoggedInFlag = true;

    private By waitForElement(By locator) {
        try {
            withTimeoutOf(Duration.ofSeconds(10)).find(locator);
            waitForCondition().until(ExpectedConditions.presenceOfElementLocated(locator));
            waitForCondition().until(ExpectedConditions.elementToBeClickable(locator));
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return locator;
    }

    public List<WebElement> findElements(By locator) {
        withTimeoutOf(Duration.ofSeconds(10)).find(locator);
        try {
            waitForCondition().until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return getDriver().findElements(locator);
    }


    public int getCountOfElements(By locator) {
        Log.consoleMessage("GETTING COUNT OF ELEMENTS: " + locator);
        return findElements(locator).size();
    }

    protected void clickOn(By element) {
        Log.consoleMessage("CLICK ON ELEMENT: " + element);
        findElement(element).click();
    }

    protected void type(By element, String text) {
        Log.consoleMessage("TYPE INTO: " + element + ", TEXT: " + text);
        findElement(element).sendKeys(text);
    }

    public WebElement findElement(By element) {
        Log.consoleMessage("WAITING FOR ELEMENT: " + element);
        return find(waitForElement(element));
    }

    protected boolean isDisplayed(By element) {
        Log.consoleMessage("VERIFY IF ELEMENT: " + element + " IS DISPLAYED");
        return findElement(element).isDisplayed();
    }

    protected boolean isPresent(By element) {
        Log.consoleMessage("VERIFY IF ELEMENT: " + element + " IS PRESENT");
        return findElements(element).size() > 0;
    }

    protected By getElementsByAttributeAndText(String attribute, String text) {
        return By.xpath(elementsByAttributeAndText(attribute, text));
    }

    protected String elementsByAttributeAndText(String attribute, String text) {
        return String.format("//%s[contains(text(),'%s')]", attribute, text);
    }

    protected String getText(By element) {
        Log.consoleMessage("GETTING TEXT OF ELEMENT: " + element);
        return findElement(element).getText();
    }

}
