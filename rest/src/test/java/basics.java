import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class basics {

    public static void main(String args[])
    {

        RestAssured.baseURI = "https://maps.googleapis.com";

        given().
                param("location","-33.8670522,151.1957362").
                param("radius","1500").
                param("key","AIzaSyAQkEsSsZRZYnmoiVvlWpdm7f4DvEIbQFs").
                when().
                get("/maps/api/place/nearbysearch/json").
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
                body("results[0].geometry.location.lat",equalTo("-33.8688197"));
        

    }

}
