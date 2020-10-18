package blog.api;

import blog.helpers.Log;

public class BodyBuilder {

    public String Login(String user, String password) {
        StringBuilder login = new StringBuilder();
        login
                .append("{\"user\":{\"email\":\"")
                .append(user)
                .append("\",\"password\":\"")
                .append(password)
                .append("\"}}");
        Log.consoleMessage("Body build: " + login);
        return String.valueOf(login);
    }

    public String Article(String title, String description, String body) {
        StringBuilder article = new StringBuilder();
        article
                .append("{\"article\": {\"title\": \"")
                .append(title)
                .append("\",\"description\": \"")
                .append(description)
                .append("\",\"body\": \"")
                .append(body)
                .append("\",\"tagList\": [\"magic\", \"cool\", \"dragons\"]}}");
        Log.consoleMessage("Body build: " + article);
        return String.valueOf(article);
    }
}
