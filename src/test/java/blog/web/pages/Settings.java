package blog.web.pages;

import blog.web.DriverDecorator;
import org.openqa.selenium.By;

public class Settings extends DriverDecorator {
    private String CONTAINER = ".settings-page" + SPACE;
    public By logout = By.cssSelector(CONTAINER + ".btn-outline-danger");
}
