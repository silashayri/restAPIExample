package util;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.requestSpecification;

public class BaseAPITest {
    private Logger log = Logger.getLogger(getClass());




    @BeforeTest
    public void before() {
        {

            RestAssured.baseURI = "http://216.10.245.166";
            //RestAssured.port = 80;
            requestSpecification = new RequestSpecBuilder().build()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON);
            //BasicConfigurator.configure();


        }
    }

    @AfterTest
    public void setupAfterTest()
    {



        RestAssured.reset();
    }

}

