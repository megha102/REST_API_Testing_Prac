import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class post {

    @Test
    public void Testb()
    {

        RestAssured.baseURI = "http://restapi.demoqa.com/customer/register";


        RequestSpecification req = RestAssured.given();

        //create a JSON request that contain all fields

        JSONObject reqParam = new JSONObject();
        reqParam.put("FirstName","Megha");
        reqParam.put("LastName","Gulati");
        reqParam.put("UserName","mgula");
        reqParam.put("Password","1234");
        reqParam.put("Email","abc@gmail.com");

        //add header in the request
        req.header("Content-Type", "application/json");


        //add json to the body of the request
        req.body(reqParam.toJSONString());

        //post the request and check the response
        Response res = req.post("/register");

        //validating the response
        int statusCode = res.statusCode();
        Assert.assertEquals(statusCode,200);

        


















    }

    @Test(enabled = false)
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
