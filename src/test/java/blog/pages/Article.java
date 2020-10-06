package blog.pages;

import blog.DriverDecorator;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class Article extends DriverDecorator {

    private By articleContent = By.cssSelector(".row.article-content p");

    @Step("Get article content")
    public String getArticleContext() {
        return getText(articleContent);
    }
}
