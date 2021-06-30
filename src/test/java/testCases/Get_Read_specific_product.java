package testCases;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;


public class Get_Read_specific_product {

	@Test
	public void read_certain_product() {
		
	Response response =
			
			given()
			        .baseUri("https://techfios.com/api-prod/api/product")
					.header("Content-Type", "application/json; charset=UTF-8")
					.queryParam("id", "2030")
					
		    .when().get("/read_one.php")
			.then().extract().response();
	
	
		int Status_code = response.getStatusCode();
		int expected_Status_code = 200;
		
		
	  String body = response.getBody().prettyPrint();
	  
      Long responseTime = response.timeIn(TimeUnit.MILLISECONDS);

		//System.out.println("Response body is:"+ response.getBody().prettyPrint());
		System.out.println("Actual Status code is:"+Status_code);
		System.out.println("Response Time in ms is:"+ responseTime);

		if (Status_code == expected_Status_code)
		{
			System.out.println("STATUS CODE VALIDATE SUCCESFULLY :)" + "TIME IT TAKES ms:"+responseTime);
		}
		else {
			System.out.println("STATUS CODE VALIDATION FAILED!");
			
		};
		
		Assert.assertEquals(Status_code, expected_Status_code);
		
		JsonPath jpath = new JsonPath(body);
		String productname = jpath.getString("name");
		String productdescription = jpath.getString("description");
		String productprice = jpath.getString("price");
		System.out.println("the product name is: "+productname + "    the product price is: "+productprice+ "   the product description: "+productdescription);
	}
	
	
}
