package MyPackage;


import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import static  org.hamcrest.Matchers.*;

public class DataDriven {

    @DataProvider(name = "md5hashes")
    public Object[][] createMD5TestData() {

        return new String[][] {
                {"testcaseOne", "4ff1c9b1d1f23c6def53f957b1ed827f"},
                {"testcaseTwo", "39738347fb533d798aca9ae0f56ca126"},
                {"testcaseThree", "db6b151bb4bde46fddb361043bc3e2d9"}
        };
    }

    @Test(dataProvider = "md5hashes")
    public void md5JsonTest(String originalText, String md5Hash) {

        given().
                queryParam("text", originalText).
                when().
                get("http://md5.jsontest.com").
                then().
                assertThat().body("md5", equalTo(md5Hash));


    }


}
