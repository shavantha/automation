package SpecBuilder;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.FileOutputStream;
import java.io.PrintStream;
import static io.restassured.RestAssured.given;

public class SpecBuilderTest {

    public static  PrintStream log;

    @BeforeTest
    public RequestSpecification requestSpec() throws java.io.IOException {


        log=new PrintStream(new FileOutputStream("new-log3.txt"),true);
        log.append("*********************TestResults**********************\r");

        RequestSpecification requestSpecification =new RequestSpecBuilder()
                .setBaseUri("http://api.zippopotam.us")
                .setContentType(ContentType.JSON)
                .addFilter(new RequestLoggingFilter(log))
                .addFilter(new ResponseLoggingFilter(log))
                .build();
        return requestSpecification;
    }

    public ResponseSpecification responseSpec()  {

        ResponseSpecification responseSpecification=new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();

        return  responseSpecification;
    }
    @Test
    public void testLKCode() throws java.io.IOException {

        given().
                spec(requestSpec()).
                when().
                get("/lk/10350").
                then()
                .spec(responseSpec());
    }

    @Test
     public void testUSCode() throws java.io.IOException {
        given().
                spec(requestSpec()).
                when().log().all().
                get("/us/90201").
                then()
                .spec(responseSpec());
    }

    @AfterTest
    public void cleanup(){

        log.append("*********************AfterTestResults**********************");
        log.flush();
        log.close();
    }
}
