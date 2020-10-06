package blog.components;

import blog.DriverDecorator;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class NavigationBar extends DriverDecorator {

    @Step("Is new post link displayed")
    public boolean isUserLoggedIn(String userName) {
        return isDisplayed(By.partialLinkText(userName));
    }

    @Step("Click link on navigation bar")
    public void selectLink(String linkText) {
        clickOn(getElementsByAttributeAndText("a", linkText));
    }

}
