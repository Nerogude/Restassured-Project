package day5;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class ParsingXMLResponse {
	
	//@Test
	void testXMLResponse()
	{
		//Approach1
		
		/*given()
		
		.when()
			.get(" http://restapi.adequateshop.com/api/Traveler?page=1")
		
		.then()
			.statusCode(200)
			.header("Content-Type","application/xml; charset=utf-8" )
			.body("TravelerinformationResponse.page",equalTo("1"))
			.body("TravelerinformationResponse.travelers.Travelerinformation[0].name",equalTo("Developer"));
*/
		
		//Approach2
		
		Response res=given()
		
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		Assert.assertEquals(res.getStatusCode(),200);
		Assert.assertEquals(res.header("Content-Type"),"application/xml; charset=utf-8");
		
		String pageNo= res.xmlPath().get("TravelerinformationResponse.page").toString();
		Assert.assertEquals(pageNo,"1");
		
		String travelName = res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
		Assert.assertEquals(travelName, "Developer");
		
		
	}
	
	@Test
	void testXMLResponseBody()
	{
	
	Response res=given()
			
			.when()
				.get("http://restapi.adequateshop.com/api/Traveler?page=1");
	
	XmlPath xmlobj = new XmlPath(res.asString());
	
	List <String> travellers= xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation");
	
	Assert.assertEquals(travellers.size(), 10);
	
	//verify traveller name is present in response
	
	List <String> travellers_name=xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
	boolean status = false;
	for(String travellername:travellers_name) {
		if(travellername.equals("Developer"))
		{
			status=true;
			break;
		}
	}
	Assert.assertEquals(status, true);
			


			
	}
			

}
