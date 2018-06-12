import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class post {

    @Test
    public  void Test2()
    {
        String b = "{"+
                "\"location\": {"+
                "\"lat\": -33.8669710,"+
                "\"lng\": 151.1958750"+
                "},"+
                "\"accuracy\": 50"+
                "\"name\": \"Google Shoes!\","+
                "\"phone_number\": \"(02) 9374 4000\","+
                "\"addres\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\","+
                "\"types\": [\"shoe_store\"],"+
                "\"website\": \"http://www.google.com.au/\","+
                "\"language\": \"en-AU\""+

                "}";
        RestAssured.baseURI = "https://maps.googleapis.com";

        Response res =given().
                queryParam("key","AIzaSyDuQhCGQGggIDvuv1JVyqtMIz6ziRE4VeM").and().
                body(b).
                when().
                post("/maps/api/place/add/").
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
                body("status",equalTo("OK")).

                extract().response();


        //get response in raw data form, convert into string
        System.out.println(res.toString());





    }




}
