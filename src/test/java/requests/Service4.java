package requests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Service4 {

    @BeforeTest
    public void getData() throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("//Users//sahabt//Desktop//restApi//restAPIExample//src//files//env.properties");
        prop.load(fis);


        prop.get("Host");


    }


    @Test
    public void AddandDeletePlace(){
String resbody = "{"+
        "\"location\": {"+
        "\"lat\": -33.8669710,"+
        "\"lng\": 151.1958750"+
        "},"+
        "\"accuracy\": 50,"+
        "\"name\": \"Google Shoes!\","+
        "\"phone_number\": \"(02) 9374 4000\","+
        "\"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\","+
        "\"types\": [\"shoe_store\"],"+
        "\"website\": \"http://www.google.com.au/\","+
        "\"language\": \"en-AU\""+
        "}";

    RestAssured.baseURI="http://216.10.245.166";
    Response res = given().
            queryParam("key","qaclick123").
            body(resbody).
            when().
            post("/maps/api/place/add/json").
            then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
            body("status",equalTo("OK")).
    extract().response();
        /*************           Grab the Place ID from the Response             *********/
        String responseString = res.prettyPrint();
   // System.out.println(responseString);
    JsonPath jsp = new JsonPath(responseString);
    String PlaceID = jsp.get("place_id");
    System.out.println("Place ID: "+PlaceID);

        /*************           Place this Place ID in the delete request             *********/


    given().
            queryParam("key","qaclick123").
            body("{"+

                   "\"place_id\": \""+PlaceID+"\" "+
                "}").
            when().
            post("/maps/api/place/delete/json").
            then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
            body("status",equalTo("OK"));
}



}

