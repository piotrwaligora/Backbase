package blog.helpers;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;
import org.apache.http.HttpStatus;

import static blog.api.Constants.BASE_URL;
import static blog.api.Constants.BASIC_AUTH;
import static io.restassured.RestAssured.given;

public class Rest {

    public RequestSpecification Login() {
        Log.consoleMessage("Login user");
        return given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .header("authorization", BASIC_AUTH);
    }

    @Step("Verify response is 200")
    public void verifyResponseCode(Response response, int status) {
        Log.consoleMessage("Verifying response status code");
        response.then().statusCode(status);
    }

}