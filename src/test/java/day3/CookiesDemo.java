package day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesDemo {
	
	//@Test(priority=1)
	
	void testCookies() {
		
		given()
		
		.when()
			.get("https://www.google.com/")
		
		.then()
			.cookie("AEC","AakniGOLdcambmloOVwvfrvfGA0WQK8PXei5Zv0IXp-qAiPAswf_0KXrtMo")
			.log().all();
		
	}
	
	@Test
	void getCookiesInfo() {
		
		Response response=given()
		
		.when()
		.get("https://www.google.com/");
		
		//String cookie_value= response.getCookie("AEC");
		//System.out.println("value of cookie is: "+ cookie_value);
		
		Map<String,String>cookies_values= response.getCookies();
		
		
		
		for(String k:cookies_values.keySet()) {
			String cookie_value=response.getCookie(k);
			System.out.println(k+ "        "+ cookie_value);
			
		}
		
	}

}
