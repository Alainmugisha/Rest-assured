package testCases;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;


public class Get_Read_all_product {

	@Test
	public void read_all_product() {
		
	Response response =
			
			given()
			.baseUri("https://techfios.com/api-prod/api/product")
					.header("Content-Type", "application/json; charset=UTF-8")
		    .when().get("/read.php")
			.then().extract().response();
	
		int Status_code = response.getStatusCode();

		System.out.println("Actual response is:"+response.prettyPrint());
		
		
		System.out.println("Actual Status code is:"+Status_code);
		
		Assert.assertEquals(Status_code, 200);
		
	}
	
	
}
