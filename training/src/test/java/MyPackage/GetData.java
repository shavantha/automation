package MyPackage;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import message.Message;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import io.restassured.parsing.Parser;


public class GetData {

    @Test
    public void testFor200() {

                    given() .baseUri("http://restapi.demoqa.com/")
                            .basePath("utilities/weather/city/Colombo")
                            .contentType(ContentType.JSON)
                    .when().get("/city/{cityName}","Colombo")
                    .then()
                           .statusCode(200);
    }

    @Test
    public void testFor400(){

        given() .baseUri("http://restapi.demoqa.com/")
                .basePath("utilities/weather/city/Colombo")
                .contentType(ContentType.JSON)
                .when().get("/city/{cityName}","Abcd")
                .then()
                .statusCode(400);

    }

    @Test
    public void validateMessage(){
        Message message = new Message();
        message.setMessage("hi shavantha");
        message.setID("1");

        given()
                .body(message).
                when().
                post("/message");

    }

    public static Response responseValidation(String endpoint) {

        RestAssured.defaultParser = Parser.JSON;

        return
                given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                        when().get(endpoint).
                        then().contentType(ContentType.JSON).extract().response();

    }

    @Test
    public void validateResponse() {
        Response response = responseValidation("http://restapi.demoqa.com/utilities/weather/city/Colombo");


        String responseValue = response.jsonPath().getString("City");
        System.out.println(">>>>>>>>>>>>" + responseValue);
        Assert.assertEquals(responseValue, "Colombo");
    }
}
