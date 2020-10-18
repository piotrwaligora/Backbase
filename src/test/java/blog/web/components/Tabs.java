package blog.web.components;

import blog.web.DriverDecorator;
import net.thucydides.core.annotations.Step;

public class Tabs extends DriverDecorator {

    @Step("Select tab")
    public void selectTab(String linkText) {
        clickOn(getElementsByAttributeAndText("a", linkText));
    }
}
