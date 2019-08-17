package requests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojo.request.ExampleREQ;
import pojo.response.ExampleRES;

import static io.restassured.RestAssured.given;

public class Service2 {

    ExampleRES ad = new ExampleRES();
    ExampleREQ sd = new ExampleREQ();


    public Service2 service2ExampleReq() {



        System.out.println("circuit id " + ExampleREQ.circuitId);


        Response axd = given()
                .get("http://ergast.com/api/f1/circuits/" + sd.circuitId + ".json")
                .then().extract().response();
       // ax.getBody().jsonPath().get("MRData.CircuitTable.Circuits[0]");
        axd.getBody().prettyPrint();



        ad.ResponseData = axd.asString();
        JsonPath jsonPath = new JsonPath(ad.ResponseData);




        sd.circuitName = jsonPath.getString("MRData.CircuitTable.Circuits[0].circuitName");


        System.out.println("circuit name " + sd.circuitName);



        return this;
    }
}
