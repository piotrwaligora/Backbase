package blog.web.pages;

import blog.helpers.Log;
import blog.web.DriverDecorator;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class Article extends DriverDecorator {

    public By articleContent = By.cssSelector(".row.article-content p");
    public By articleAddComment = By.cssSelector("app-add-comment textarea");

    @Step("Get article content")
    public String getArticleContext() {
        Log.consoleMessage("Getting article context");
        return getText(articleContent);
    }
}
