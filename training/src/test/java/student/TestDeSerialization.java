package student;

import org.testng.annotations.Test;
import io.restassured.RestAssured;


public class TestDeSerialization {

    @Test
    public void testDeSerialization() {

        Student student = RestAssured.get("http://localhost:9091/students/1").as(Student.class);

        System.out.println(student.toString());
    }

}
