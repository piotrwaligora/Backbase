package blog.web.pages;

import blog.web.DriverDecorator;
import blog.web.components.NavigationBar;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import blog.helpers.Log;


public class Login extends DriverDecorator {
    NavigationBar navigationBar;
    Settings settings;
    private String CONTAINER = ".auth-page" + SPACE;
    private By user = By.cssSelector(CONTAINER + "input[placeholder='Username']");
    private By pass = By.cssSelector(CONTAINER + "input[placeholder='Password']");
    private By signIn = By.cssSelector(CONTAINER + ".btn-lg");

    @Step("Login user")
    public void loginUser(String name, String password) {
        Log.consoleMessage("Login user");
        type(user, name);
        type(pass, password);
        signIn();
        isUserLoggedInFlag = true;
    }

    @Step("Click sign in")
    private void signIn() {
        Log.consoleMessage("Sign in user");
        clickOn(signIn);
    }

    @Step("Logout user")
    public void logoutUser() {
        if (isUserLoggedInFlag) {
            Log.consoleMessage("logout user");
            navigationBar.selectLink("Settings");
            clickOn(settings.logout);
            isUserLoggedInFlag = false;
        }
    }
}
