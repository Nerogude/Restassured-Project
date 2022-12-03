package day8;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

public class CreateUser {
	
	@Test
	void tes_createUser(ITestContext context) {
		Faker faker = new Faker();
		
		JSONObject data = new JSONObject();
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "inactive");
		
		String bearerToken="278b799ac5bd242afd863a3a9e9e43f7d9d29f5ddf5524a3651274277b56388a";
		
		int id=given()
			.contentType("application/json")
			.body(data.toString())
			.headers("Authorization","Bearer "+bearerToken)
		
		.when()
			.post("https://gorest.co.in/public/v2/users")
			.jsonPath().getInt("id");
		System.out.println("value of id is: "+id);
		context.setAttribute("user_id", id);
		
		
	}

}
