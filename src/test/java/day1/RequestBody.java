package day1;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.json.JSONObject;

public class RequestBody {
	
	//@Test(priority=1)
	void testHashMap() {
		
		HashMap data = new HashMap();
		data.put("name", "pavan");
		data.put("location", "uk");
		data.put("phone", "123456");
		
		String courseArr[]= {"C#","C++"};
		data.put("courses", courseArr);
		
		
		given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("http://localhost:3000/students")
		
		.then()
			.statusCode(201)
			.body("name",equalTo("pavan"))
			.body("courses[0]",equalTo("C#"))
			.body("courses[1]",equalTo("C++"))
			.log().all();
	}
	//@Test(priority=2)
	void deleteData() {
		given()
		
		.when()
			.delete("http://localhost:3000/students/4")
		
		.then()
			.statusCode(200);
	}
	@Test(priority=1)
	
	void testJsonObj() {
		
		JSONObject data = new JSONObject();
		data.put("name", "pavan");
		data.put("location", "uk");
		data.put("phone", "123456");
		
		String courseArr[]= {"C#","C++"};
		data.put("courses","courseArr");
		
		given()
			.contentType("application/json")
			.body(data.toString())
		
		.when()
			.post("http://localhost:3000/students")
		
		.then()
			.statusCode(201)
			.body("name",equalTo("pavan"))
			.body("location",equalTo("uk"))
			.log().all();
	}
	//@Test(priority=2)
	void delData() {
		given()
		
		.when()
			.delete("http://localhost:3000/students/4")
		
		.then()
			.statusCode(200);
	}
	
	@Test
	void test_Pojo() {
		
		PlainOldJavaObject pojo= new PlainOldJavaObject();
		pojo.setName("pavan");
		pojo.setLocation("uk");
		pojo.setPhone("123456");
		
		String courseArr[]= {"C+","C#"};
		
		pojo.setCourses(courseArr);
		
		
		given()
			.contentType("application/json")
			.body(pojo)
		
		.when()
			.post("http://localhost:3000/students")
		
		.then()
			.statusCode(201)
			.log().headers();
		
	}
	

}
