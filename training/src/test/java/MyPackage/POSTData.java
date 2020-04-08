package MyPackage;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;


public class POSTData {

    public  static Map<String,String> buildData=new HashMap<String,String>();

    @BeforeTest
    public void data(){
        buildData.put("userId","2");
        buildData.put("id","19");
        buildData.put("title", "this is projectdebug.com");
        buildData.put("body", "this is REST-Assured Tutorial");
        baseURI= "http://jsonplaceholder.typicode.com";
        basePath= "/posts/";
    }

    @Test
    public void testPOST(){
        given()
                .contentType("application/json")
                .body(buildData)
                .when()
                .post()
                .then()
                .statusCode(201)
                .and()
                .body("title", equalTo("this is projectdebug.com"));
    }

}
