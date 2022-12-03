package day8;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import org.json.JSONObject;
import com.github.javafaker.Faker;

public class UpdateUser {
	
	@Test
	void tes_updateUser(ITestContext context) {
		Faker faker = new Faker();
		
		JSONObject data = new JSONObject();
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "active");
		
		String bearerToken="278b799ac5bd242afd863a3a9e9e43f7d9d29f5ddf5524a3651274277b56388a";
		
		int id=(Integer) context.getAttribute("user_id");
		
		given()
			.contentType("application/json")
			.body(data.toString())
			.pathParam("id", id)
			.headers("Authorization","Bearer "+bearerToken)
		
		.when()
			.put("https://gorest.co.in/public/v2/users/{id}")
			
		.then()
			.statusCode(200)
			.log().all();
			
		System.out.println("value of id is: "+id);
		
		
	}

}
