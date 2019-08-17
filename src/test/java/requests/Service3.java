package requests;

import pojo.request.ExampleREQ;
import pojo.response.ExampleRES;

import static io.restassured.RestAssured.given;

public class Service3 {

    ExampleRES ad = new ExampleRES();
    ExampleREQ sd = new ExampleREQ();


    public Service3 Service3Ex() {




        System.out.println("response data " + ad.ResponseData);

        return this;
    }
}
