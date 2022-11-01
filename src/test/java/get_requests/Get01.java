package get_requests;

import io.restassured.response.Response;
import org.junit.Test;
import org.testng.util.Strings;

import static io.restassured.RestAssured.*;

public class Get01 {

  /*

    Postman manuel API testi için kullanilir.

    API otomasyon testi icin Rest-Assured Library kullaniyoruz.

    Otomasyon kodlarinin yazimi icin su adimlari izliyoruz.

    - Gereksinimleri anlamak

    - Test Case in yazimi icin Gherkin Language kullaniyoruz

    Gherkin bazi keywordlere sahip:

    Given: Önkoşullar
    When: Aksiyonlar => get, put
    Then: Dönütler  =>
    And: Çoklu amaclar icin kullanilir


    Testing kodunun yazimi

    Set the URL
    Set the expected data POST-PUT-PATCH
    Type code to send request
    Do Assertion

/*
        Given
            https://restful-booker.herokuapp.com/booking/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
   */

    @Test
    public void get01() {
        //Set the URL
        String url = "https://restful-booker.herokuapp.com/booking/55";

        // Set the expected data POST-PUT-PATCH

        // Type code to send request
        Response response = given().when().get(url);

        response.prettyPrint();

        // Do Assertion

        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");

        // status code nasil yazdirilir?
        System.out.println("response.statusCode() = " + response.statusCode());
        System.out.println("response.statusLine() = " + response.statusLine());
        System.out.println("response.contentType() = " + response.contentType());


        // Header nasil yazilir?
        System.out.println(response.header("User-Agent"));

       //Headers nasil yazilir?
        System.out.println("Headers:\n"+response.headers());

        //Time nasil yazdirilir?
        System.out.println("Time:"+response.getTime());


    }
}