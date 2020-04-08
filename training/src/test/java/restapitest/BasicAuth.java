package restapitest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class BasicAuth {

    @Test
    public void testBaicAuth() {
        given()
            .auth().basic("postman", "password").
                when().
                get("https://postman-echo.com/basic-auth").
                then().
                assertThat().
                statusCode(200).
                and().
                contentType(ContentType.JSON);
    }
}
