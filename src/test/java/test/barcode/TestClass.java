package test.barcode;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import requests.Service1;
import requests.postData;
import util.BaseAPITest;
import static org.hamcrest.CoreMatchers.equalTo;

import static io.restassured.RestAssured.given;



public class TestClass extends BaseAPITest {




	@Test
	public void runTest()
	{
		Service1 app = new Service1();
		app.exampleReq();

	}

	@Test
	public void apiPostTest() {

		postData post1 = new postData();
		post1.postData1();


	}
	@Test
	public void createPlaceAPI()
	{

		given().

				queryParam("key","qaclick123").
				body("{"+"\"location\": {"+ "\"lat\": -33.8669710,"+
								"\"lng\": 151.1958750"+ "},"+ "\"accuracy\": 50,"+"\"name\": \"Google Shoes!\","
								+ "\"phone_number\": \"(02) 9374 4000\","
								+"\"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\","
								+"\"types\": [\"shoe_store\"],"+"\"website\": \"http://www.google.com.au/\","+"\"language\": \"en-AU\""
								+"}").
				when().
				post("/maps/api/place/add/json").
				then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
				body("status",equalTo("OK"));


	}

}