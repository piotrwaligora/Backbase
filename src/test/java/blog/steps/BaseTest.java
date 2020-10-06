package blog.steps;

import blog.navigation.Navigation;
import cucumber.api.java.After;
import net.thucydides.core.annotations.Steps;

public class BaseTest {
    @Steps
    Navigation navigation;

    @After
    public void opensaLoginPage() {

    }
}
