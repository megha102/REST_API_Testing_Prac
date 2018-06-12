import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class get {

    @Test
    public void Test1()
    {

        //validating the status code, place_id in body and server in response header
        RestAssured.baseURI = "https://maps.googleapis.com";

        given().
                param("location","-33.8670522,151.1957362").
                param("radius","1500").
                param("key","AIzaSyAQkEsSsZRZYnmoiVvlWpdm7f4DvEIbQFs").
                when().
                get("/maps/api/place/nearbysearch/json").
                then().
                assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
                body("results[0].place_id",equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).and().
                header("server","scaffolding on HTTPServer2");
        

    }

}
