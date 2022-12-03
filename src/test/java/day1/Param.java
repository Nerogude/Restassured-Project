package day1;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Param {
	
	@Test
	void pathParam() {
		given()
			.pathParam("mypath", "users")
			.queryParam("page", 2)
			.queryParam("id", 5)
		
		.when()
			.get("https://reqres.in/api/{mypath}")
		
		.then()
			.statusCode(200)
			.log().all();
	}

}
