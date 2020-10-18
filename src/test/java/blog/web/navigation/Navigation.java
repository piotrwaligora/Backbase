package blog.web.navigation;

import net.thucydides.core.annotations.Step;
import blog.helpers.Log;

public class Navigation {

    GoHome goHome;
    GoLogin goLogin;

    @Step("Open the Bblog home page")
    public void openHomePage() {
        Log.consoleMessage("Opening home page");
        goHome.open();
    }

    @Step("Open the Bblog login page")
    public void openLoginPage() {
        Log.consoleMessage("Opening login page");
        goLogin.open();
    }
}
