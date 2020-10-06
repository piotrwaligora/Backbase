package blog.Dataset;

public class ArticleData {
    private String title;
    private String about;
    private String article;
    private String tags;

    public ArticleData(String title, String about, String article, String tags) {
        this.title = title;
        this.about = about;
        this.article = article;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
