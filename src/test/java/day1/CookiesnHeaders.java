package day1;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class CookiesnHeaders {
	
	//@Test(priority=1)
	
	void testCookies()
	{
		given()
		
		.when()
			.get("http://www.google.com/")
		
		.then()
			.cookie("AEC","AakniGOYO4DfY1IxeHK3CfZi7XgXhrCgKq0FoYOPxamKBw6FW6jyKb11Tw")
			.log().all();
	}
	
//@Test(priority=2)
	
	void getCookies()
	{
		Response res=given()
		
		.when()
			.get("http://www.google.com/");
		//String cookie_value= res.getCookie("AEC");
		
		//System.out.println("value of cookie is: "+cookie_value);
		

		Map<String, String>cookies_values= res.getCookies();
		
		
		
		for(String k:cookies_values.keySet()) {
			
			String cookie_value=res.getCookie(k);
			System.out.println(k +"      "+cookie_value);
			
		}
			
		
		
	}
@Test(priority=2)
	
	void getHeaders()
	{
		Response res=given()
		
		.when()
			.get("https://www.google.com/");
		Headers myheaders = res.getHeaders();
		for(Header hd:myheaders) {
			System.out.println(hd.getName()+"     "+hd.getValue());
		}
	}
}
