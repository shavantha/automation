package student;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestSerialization {

    @Test
    public void testSerialization() {

        Response response = null;

        Student student = new Student("Isha Durani", "A", 101);

        response = RestAssured.given()
                .contentType("application/json")
                .body(student)
                .when()
                .post("http://localhost:9091/students");

        assertTrue(response.toString().contains("Student added successfully."));

    }
}
