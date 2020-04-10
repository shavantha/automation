package SpecBuilder;

import io.restassured.builder.ResponseSpecBuilder;
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
import java.io.IOException;
import java.io.PrintStream;
import static io.restassured.RestAssured.given;

public class SpecBuilderTest extends GlobalVariables{

    public static  PrintStream log;
    SpecBuilderUtil apiResource;
    RequestSpecification requestSpecification;


    @BeforeTest
    public RequestSpecification requestSpec() throws java.io.IOException {

        if (requestSpecification == null) {
            log = new PrintStream(new FileOutputStream("new-log3.txt"), true);
            log.append("*********************TestResults**********************\r");

            requestSpecification = new RequestSpecBuilder()
                    .setBaseUri(GlobalVariables.getGlobalVariables("baseURL"))
                    .setContentType(ContentType.JSON)
                    .addFilter(new RequestLoggingFilter(log))
                    .addFilter(new ResponseLoggingFilter(log))
                    .build();
            return requestSpecification;
        }
        return requestSpecification;
    }

    public ResponseSpecification responseSpec()throws IOException {

        int code=Integer.parseInt(GlobalVariables.getGlobalVariables("HTTPOK"));
        ResponseSpecification responseSpecification=new ResponseSpecBuilder()
                .expectStatusCode(code)
                .expectContentType(ContentType.JSON)
                .build();

        return  responseSpecification;
    }
    @Test
    public void testLKCode() throws java.io.IOException {
        apiResource= SpecBuilderUtil.valueOf(GlobalVariables.getGlobalVariables("lkEndPoint"));

        given().
                spec(requestSpec()).
                when().
                get(apiResource.getResource()).
                then()
                .spec(responseSpec());
    }

    @Test
     public void testUSCode() throws java.io.IOException {
        apiResource= SpecBuilderUtil.valueOf(GlobalVariables.getGlobalVariables("usEndPoint"));
        given().
                spec(requestSpec()).
                when().log().all().
                get(apiResource.getResource()).
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
