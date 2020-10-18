package blog.steps;

import blog.helpers.Rest;
import blog.api.BodyBuilder;
import blog.web.components.NavigationBar;
import blog.web.dataset.ArticleData;
import blog.web.navigation.Navigation;
import blog.web.pages.Article;
import blog.web.pages.Home;
import blog.web.pages.Login;
import blog.web.pages.NewPost;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Steps;
import org.apache.http.HttpStatus;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static blog.api.Constants.ARTICLES_ENDPOINT;
import static blog.api.Constants.LOGIN_ENDPOINT;
import blog.helpers.Log;

public class Articles {
    private ArticleData javaBook = new ArticleData("Java 8", "its about java", "java is sometimes hard to understand", "java");
    private Rest restHelper = new Rest();
    private boolean useBrowser = true;
    private String token;
    private String title;
    private String description;
    private String body;

    @Before
    public void before() {
        Log.consoleMessage("Test start");
    }

    @After
    public void after() {
        if (useBrowser) {
            login.logoutUser();
            Log.consoleMessage("Test stop");
        }
    }

    @Steps
    private Navigation navigation;

    @Steps
    private Home home;

    @Steps
    private Login login;

    @Steps
    NavigationBar navigationBar;

    @Steps
    NewPost newPost;

    @Steps
    Article article;

    @Given("FE: User login with credentials userName {string} and password {string}")
    public void feUserLoginWithCredentialsUserNameAndPassword(String user, String password) {
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

    @And("he adds new articles with empty fields")
    public void heAddsNewArticlesWithEmptyFields(DataTable loginData) {
        List<List<String>> list = loginData.asLists(String.class);
        IntStream.range(1, list.size()).mapToObj(row ->
                new ArticleData(list.get(row).get(0), list.get(row).get(1), list.get(row).get(2), list.get(row).get(3))).
                forEach(pwPost -> {
                    newPost.addPost(pwPost);
                    navigationBar.selectLink("New Post");
                });
    }

    @Then("articles are previewed on home page")
    public void articlesArePreviewedOnHomePage(DataTable postData) {
        login.logoutUser();
        navigation.openHomePage();

        List<List<String>> dataToCheckList = postData.asLists(String.class);
        int size = dataToCheckList.size();

        IntStream.range(1, size).forEach(row -> {
            String articlePreviewText = home.getArticleText(row - 1);
            String title = dataToCheckList.get(row).get(0);
            String about = dataToCheckList.get(row).get(1);
            String tags = dataToCheckList.get(row).get(2);

            Assert.assertTrue(articlePreviewText + "should contains " + title, articlePreviewText.contains(title));
            Assert.assertTrue(articlePreviewText + "should contains " + about, articlePreviewText.contains(about));
            Assert.assertTrue(articlePreviewText + "should contains " + tags, articlePreviewText.contains(tags));
        });
    }


    @Given("BE: User login with credentials userName {string} and password {string}")
    public void beUserLoginWithCredentialsUserNameAndPassword(String user, String password) {
        useBrowser = false;
        Response loginResponse = restHelper.Login()
                .body(new BodyBuilder().Login(user, password))
                .when()
                .post(LOGIN_ENDPOINT);
        restHelper.verifyResponseCode(loginResponse, HttpStatus.SC_OK);
        token = loginResponse.jsonPath().get("user.token");
    }

    @When("user adds article with data: {string}, {string} and {string}")
    public void userAddsArticleWithDataAnd(String title, String description, String body) {
        long currentTime = System.currentTimeMillis();
        this.title = title + currentTime;
        this.description = description + currentTime;
        this.body = body + currentTime;

        restHelper.Login().header("jwtauthorization", "Token " + token)
                .body(new BodyBuilder().Article(title + currentTime, description + currentTime, body + currentTime))
                .when()
                .post(ARTICLES_ENDPOINT).then().statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Then("article is added")
    public void articleIsAdded() {
        Response listOfArticlesResponse = restHelper.Login().when().get(ARTICLES_ENDPOINT);
        restHelper.verifyResponseCode(listOfArticlesResponse, HttpStatus.SC_OK);

        ArrayList titles = listOfArticlesResponse.jsonPath().get("articles.title");
        ArrayList descriptions = listOfArticlesResponse.jsonPath().get("articles.description");
        ArrayList bodies = listOfArticlesResponse.jsonPath().get("articles.body");

        Assert.assertTrue("Correct title is not added to articles", titles.contains(title));
        Assert.assertTrue("Correct description is not added to articles", descriptions.contains(description));
        Assert.assertTrue("Correct body is not added to articles", bodies.contains(body));
    }
}
