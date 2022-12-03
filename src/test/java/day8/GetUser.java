package day8;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class GetUser {
	
	@Test
	void test_getUser(ITestContext context)
	{
		int id = (Integer) context.getAttribute("user_id");
		String bearerToken="278b799ac5bd242afd863a3a9e9e43f7d9d29f5ddf5524a3651274277b56388a";
		
		given()
			.headers("Authorization","Bearer "+bearerToken)
			.pathParam("id", id)
		
		.when()
			.get("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
			.statusCode(200)
			.log().all();
	}

}
