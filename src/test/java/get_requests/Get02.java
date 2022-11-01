package get_requests;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get02 {



    @Test
    public void get01() {



        String url = "https://restful-booker.herokuapp.com/booking/1005";



        Response response = given().when().get(url);

        response.prettyPrint();


        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");

        assertTrue(response.asString().contains("Not Found"));


        assertFalse(response.asString().contains("TechProEd"));

        assertEquals("Cowboy", response.header("Server"));
    }

}

