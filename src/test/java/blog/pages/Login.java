package blog.pages;

import blog.DriverDecorator;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class Login extends DriverDecorator {
    private String CONTAINER = ".auth-page" + SPACE;
    private By user = By.cssSelector(CONTAINER + "input[placeholder='Username']");
    private By pass = By.cssSelector(CONTAINER + "input[placeholder='Password']");
    private By signIn = By.cssSelector(CONTAINER + ".btn-lg");

    @Step("Login user")
    public void loginUser(String name, String password) {
        type(user, name);
        type(pass, password);
        signIn();
    }

    @Step("Click sign in")
    private void signIn() {
        clickOn(signIn);
    }
}
