package testCases;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.response.Response;


public class Post_create_a_product_with_imported_jsonFile {

	@Test
	public void create_certain_product_hybdrid() {
		
		String payloadpath = "src\\main\\java\\data_to_import.json";
		
	Response response =
			
			given() .log().all()
			        .baseUri("https://techfios.com/api-prod/api/product")
					.header("Content-Type", "application/json")
					.body(new File (payloadpath))
				
					
		    .when()
		    .post("/create.php")
			.then().extract().response();
	
	}
	
	
}
