package blog.steps;

import blog.Dataset.ArticleData;
import blog.components.NavigationBar;
import blog.navigation.Navigation;
import blog.pages.Article;
import blog.pages.Login;
import blog.pages.NewPost;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class ArticleSteps {
    private ArticleData javaBook = new ArticleData("Java 8", "its about java", "java is sometimes hard to understand", "java");

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

    @Steps
    NewPost newPost;

    @Steps
    Article article;

    @Given("User login with credentials userName {string} and password {string}")
    public void userLoginWithCredentialsUserNameAndPassword(String user, String password) {
        navigation.openLoginPage();
        login.loginUser(user, password);
    }

    @When("user clicks on new article")
    public void clickOnNewArticle() {
        navigationBar.selectLink("New Post");
    }

    @And("he fill in all article fields and press publish article")
    public void heFillInAllArticleFieldsAndPressPublishArticle() {
        newPost.addPost(javaBook);
    }

    @Then("article is added and contains text {string}")
    public void articleIsAddedAndContainsText(String articleText) {
        Assert.assertTrue("article is not added", article.getArticleContext().contains(articleText));

    }
}
