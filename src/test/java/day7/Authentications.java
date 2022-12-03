package day7;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class Authentications {
	
	//@Test(priority=1)
	void testBasicAuthentication()
	{
		given()
			.auth().basic("postman", "password")
		
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated",equalTo(true))
			.log().all();
	}
	//@Test(priority=2)
	void testDigetstAuthentication()
	{
		given()
			.auth().digest("postman", "password")
		
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated",equalTo(true))
			.log().all();
	}
	
	//@Test(priority=3)
	void testPreemptiveAuthentication()
	{
		given()
			.auth().preemptive().basic("postman", "password")
		
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated",equalTo(true))
			.log().all();
	}
	
	@Test
	void testBearerTokenAuthentication()
	{
		given()
			.headers("Authorization","Bearer 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")
		
		.when()
			.get("https://api.github.com/user/repos")
		
		.then()
			.statusCode(200)
			.log().all();
	}


}
