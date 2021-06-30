package testCases;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.response.Response;


public class Post_create_a_product {

	@Test
	public void create_certain_product() {
		
		HashMap<String, String> payload = new HashMap<String, String>();
		
		
		payload.put("name", "Macintosh");
		payload.put("description", "intel based processor, blue color");
		payload.put("price", "2999");
		payload.put("category_id", "2");
		payload.put("category_name", "Electronics");
		

		
	Response response =
			
			given() 
			        .baseUri("https://techfios.com/api-prod/api/product")
					.header("Content-Type", "application/json")
					.body(payload)
				
					
		    .when().log().all()
		    .post("/create.php")
			.then().extract().response();
	
	
	
//	
//	String product_id = response.getSessionId();
//	
//	int status_code = response.getStatusCode();
//	String body = response.getBody().prettyPrint();
//	JsonPath jpath = new JsonPath(body);
//	String created_product = jpath.getString("price");
//	
//	System.out.println("New Created product is: "+created_product + "   With ID: "+product_id);
//	System.out.println("The status code is: "+status_code);
	
	}
	
	
}
