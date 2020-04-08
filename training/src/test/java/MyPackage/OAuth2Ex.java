package MyPackage;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.filter.log.*;
import io.qameta.allure.restassured.AllureRestAssured;

public class OAuth2Ex {

    Response response=null;

    public String getAccessToken(){

      response=  RestAssured.
                given()
                .formParam("client_id","shavantha_test")
                .formParam("client_secret", "5fc9cfc6cc2afff52ef156a20ce7c96e")
                .formParam("grant_type","client_credentials")
                .post(" http://coop.apps.symfonycasts.com/token");

        String accessToken=response.jsonPath().get("access_token");

        return accessToken;
    }

    @Test(description="Testing the web service whether success 200 has been received")
    @Description ("Description : Testing the web service whether success 200 has been received")
    @Severity (SeverityLevel.CRITICAL)
    public void testMethod(){

        String accessToken=getAccessToken();
        response=RestAssured.
                given()
                .filter(new AllureRestAssured())
                .filter(new ResponseLoggingFilter())
                .filter(new RequestLoggingFilter())
                .auth()
                .oauth2(accessToken)
                .post("http://coop.apps.symfonycasts.com/api/817/barn-unlock");

        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(description="Testing the web service whether 401 has been received")
    @Description ("Description : Testing the web service whether success 401 has been received")
    @Severity (SeverityLevel.CRITICAL)
    public void testMethod2(){

        String accessToken=getAccessToken();
        response=RestAssured.
                given()
                .auth()
                .oauth2(accessToken)
                .post("http://coop.apps.symfonycasts.com/api/817/barn-unlock2");

        Assert.assertEquals(response.getStatusCode(),401);
    }
}
