package blog.web.pages;

import blog.web.DriverDecorator;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class Home extends DriverDecorator {
    private String CONTAINER = ".home-page ";
    private By articles = By.cssSelector(CONTAINER + ".article-preview");

    @Step("Get article text")
    public String getArticleText(int numberOfArticle) {
        return findElements(articles).get(numberOfArticle).getText();
    }
}
