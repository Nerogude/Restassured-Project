package day1;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;


public class Practice {
	
	int id;
	
	@Test
	void getUser()
	{
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
			.statusCode(200)
	
			.body("page",equalTo(2))
			.log().all();
	}
	
	@Test
	void createUser() {
		
		JSONObject data = new JSONObject();
		data.put("name", "nero");
		data.put("job", "qa analyst");
		
		
		 id = given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("https://reqres.in/api/users?page=2")
			.jsonPath().getInt("id");
		
		//.then()
			//.statusCode(201)
			//.log().all();
	}

}
