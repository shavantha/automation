package weather;

import io.restassured.parsing.Parser;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;


import static io.restassured.RestAssured.given;
import java.util.List;

public class WeatherTest {


    @Test
    public void testWeatherResponse1() {

        RestAssured.baseURI ="https://samples.openweathermap.org/data/2.5/";
        RequestSpecification request = RestAssured.given();

        Response response = request.queryParam("q", "London,UK")
                .queryParam("appid", "2b1fd2d7f77ccf1b7de9b441571b39b8")
                .get("/weather");

        String jsonString = response.asString();
        System.out.println(response.jsonPath().prettify());
        Assert.assertEquals(jsonString.contains("London"), true);

        testWeatherResponse2();
    }
    @Test
    public void testWeatherResponse2() {

        RestAssured.baseURI ="https://samples.openweathermap.org/data/2.5/";
        //RequestSpecification request = RestAssured.given();


       Serialization serialization= given().
                queryParam("q", "London,UK").
                queryParam("appid", "2b1fd2d7f77ccf1b7de9b441571b39b8").expect().defaultParser(Parser.JSON).
                when()
                .get("/weather/").as(Serialization.class);

        System.out.println(">>>>>City Name>>>>>>"+serialization.getName());
        System.out.println(">>>>>Coordination Latitude>>>>>>"+serialization.getCoord().getLat());
        System.out.println(">>>>>Coordination Long>>>>>>"+serialization.getCoord().getLon());
        System.out.println(">>>>>Base>>>>>>"+serialization.getBase());
        System.out.println(">>>>>Temp>>>>>>"+serialization.getMain().getTemp());
        System.out.println(">>>>>Visibility>>>>>>"+serialization.getVisibility());
        System.out.println(">>>>>Weather>>>>>>"+serialization.getWeather().get(0).getDescription());
        System.out.println(">>>>>Weather>>>>>>"+serialization.getWeather().get(0).getMain());


        Coord coord=new Coord();

            serialization= given().
                    queryParam("q", "London,UK").
                    queryParam("appid", "2b1fd2d7f77ccf1b7de9b441571b39b8").expect().defaultParser(Parser.JSON).
                    when()
                    .get("/weather/").as(Serialization.class);
        System.out.println(">>>>>>>>>>" +coord.getLon());
        System.out.println(">>>>>>>>>>" +coord.getLat());
    }
}
