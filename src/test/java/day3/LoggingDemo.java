package day3;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class LoggingDemo {
	
	@Test(priority=1)
	void testLogs()
	{
		given()
		
		.when()
			.get("https://www.google.com/")
		
		.then()
			//.log().cookies();
			//.log().headers();
			.log().all();
	}

}
