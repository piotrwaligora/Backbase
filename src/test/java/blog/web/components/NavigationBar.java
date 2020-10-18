package blog.web.components;

import blog.helpers.Log;
import blog.web.DriverDecorator;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class NavigationBar extends DriverDecorator {

    @Step("Click link on navigation bar")
    public void selectLink(String linkText) {
        Log.consoleMessage("Selecting link" + linkText);
        clickOn(getLink(linkText));
    }

    public By getLink(String linkText){
        return getElementsByAttributeAndText("a", linkText);
    }
}
