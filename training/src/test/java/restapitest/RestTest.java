package restapitest;


import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static  org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;

public class RestTest {

    @Test
    public void checkCityForZipCode() {
        given().
                pathParam("country","lk").
                pathParam("zipcode","10350").
                when().
                get("http://api.zippopotam.us/{country}/{zipcode}").
                then().
                assertThat().
                body("places.'place name'[0]",equalTo("Dehiwala")).
                statusCode(200).
                and().
                contentType(ContentType.JSON);
    }
}
