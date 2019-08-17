package requests;

import pojo.request.ExampleREQ;
import pojo.response.ExampleRES;

import util.BaseAPITest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class Service1 extends BaseAPITest {


    ExampleREQ sd = new ExampleREQ();
    ExampleRES co = new ExampleRES();

    public Service1 exampleReq() {


        given().
                when().
                get("/api/f1/2017/circuits.json").
                then().
                assertThat().
                body("MRData.CircuitTable.Circuits[0].circuitId",equalTo("albert_park")).and().
        header("Server","Apache/2.2.15 (CentOS)");
        //ax.getBody().prettyPrint();


        //String responseBody = ax.getBody().asString();



       //JsonPath jsonPath = new JsonPath(responseBody);


      //sd.circuitId = jsonPath.getString("MRData.CircuitTable.Circuits[0].circuitId");
       //circuitName = jsonPath.getString("MRData.CircuitTable.Circuits[0].circuitName");






        return this;
    }



    public Service1 circiutName() {


        given()
                .param("callback","myParser")
                .get("http://ergast.com/api/f1/drivers.json")

                .then().extract().response();







        //String responseBody = ax.getBody().asString();

        ExampleREQ sd = new ExampleREQ();


        //JsonPath jsonPath = new JsonPath(responseBody);
        //circuitName = jsonPath.getString("MRData.CircuitTable.Circuits[3].circuitName");



        return this;
    }

}
