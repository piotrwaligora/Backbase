package blog.web.pages;

import blog.web.dataset.ArticleData;
import blog.web.DriverDecorator;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import blog.helpers.Log;

public class NewPost extends DriverDecorator {
    private String CONTAINER = ".editor-page" + SPACE;
    private By title = By.cssSelector(CONTAINER + "input[placeholder*='Article Title']");
    private By about = By.cssSelector(CONTAINER + "input[placeholder*='about?']");
    private By article = By.cssSelector(CONTAINER + "textarea[placeholder*='Write your']");
    private By tags = By.cssSelector(CONTAINER + "input[placeholder*='Enter Tags']");
    private By publish = By.cssSelector(CONTAINER + "button");

    @Step("Add post")
    public void addPost(ArticleData articleData) {
        Log.consoleMessage("Adding post(title): " + articleData.getTitle());
        type(this.title, articleData.getTitle());
        type(this.about, articleData.getAbout());
        type(this.article, articleData.getArticle());
        type(this.tags, articleData.getTags());
        publish();
    }

    @Step("Click sign in")
    private void publish() {
        clickOn(publish);
        waitForArticlePage();
    }

    @Step("Wait for article to be loaded")
    private void waitForArticlePage() {
        findElement(new Article().articleAddComment);
    }
}
