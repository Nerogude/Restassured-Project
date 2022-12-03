package day4;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;


public class ParsingJsonResponseData {
	
	//@Test(priority=1)
	void testJsonResponse() 
	{
		
		//Approach1
		/*given()
			.contentType(ContentType.JSON)
		
		.when()
			.get("http://localhost:3000/store")
		
		.then()
			.statusCode(200)
			.header("Content-Type", "application/json; charset=utf-8")
			.body("book[3].title", equalTo("The Lord of the Rings"));*/
		
		//Approach2
		
		Response res = given()
			.contentType(ContentType.JSON)
		
		.when()
			.get("http://localhost:3000/store");
		
		Assert.assertEquals(res.getStatusCode(),200);
		Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");
		
		String bookname= res.jsonPath().get("book[3].title").toString();
		Assert.assertEquals(bookname, "The Lord of the Rings");
		
	}
	
	@Test(priority=2)
	void testJsonResponseBodyData() 
	{
		
		
		
		Response res = given()
			.contentType(ContentType.JSON)
		
		.when()
			.get("http://localhost:3000/store");
		
		/*Assert.assertEquals(res.getStatusCode(),200);
		Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");
		
		String bookname= res.jsonPath().get("book[3].title").toString();
		Assert.assertEquals(bookname, "The Lord of the Rings");*/
		
		//Using JSONObject class
		JSONObject jo = new JSONObject(res.toString());
		boolean status=false;
		
		for(int i=0; i<jo.getJSONArray("book").length();i++)
		{
		String bookTitle= jo.getJSONArray("book").getJSONObject(i).get("title").toString();
		
		if(bookTitle.equals("The Lord of the Rings"))
		{
			status=true;
			break;
		}
		}
		Assert.assertEquals(status, true);
		
		//validate total price of books
		
		double totalprice=0;
		for(int i=0; i<jo.getJSONArray("book").length();i++) {
			String price=jo.getJSONArray("books").getJSONObject(i).get("price").toString();
		}
}
