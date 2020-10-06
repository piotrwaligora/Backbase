package blog.steps;

import blog.components.NavigationBar;
import blog.navigation.Navigation;
import blog.pages.Login;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class LoginSteps {

    @Before
    public void initiation() {
        //todo if necessary
    }

    @After
    public void after() {
        //todo if necessary
    }

    @Steps
    private Navigation navigation;

    @Steps
    private Login login;

    @Steps
    NavigationBar navigationBar;

    @Given("^(?:.*) opens login page")
    public void openLoginPage() {
        navigation.openLoginPage();
    }

    @When("he login with credentials userName {string} and password {string}")
    public void heLoginWithCredentialsUserNameAndPassword(String user, String password) {
        login.loginUser(user, password);
    }

    @Then("user {string} is logged in")
    public void isLoggedIn(String user) {
        Assert.assertTrue(navigationBar.isUserLoggedIn(user));
    }
}
