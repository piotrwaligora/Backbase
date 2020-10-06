package blog.navigation;

import net.thucydides.core.annotations.Step;

public class Navigation {

    GoHome goHome;
    GoLogin goLogin;

    @Step("Open the Bblog home page")
    public void openHomePage() {
        goHome.open();
    }

    @Step("Open the Bblog login page")
    public void openLoginPage() {
        goLogin.open();
    }
}
