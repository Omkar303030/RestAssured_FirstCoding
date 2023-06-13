package RestAssuredPkg;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Tc_03_CreateAbook {
	
	public static HashMap<String, String> map= new HashMap<String, String>();
	
	@BeforeClass
	public void testdata() {
		map.put("name", "Refactoring: Improving the Design of Existing Code");
		map.put("author", "Martin Fowler");
		map.put("publication", "Addison-Wesley Professional");
		map.put("category", "Programming");
		map.put("pages", "448");
		map.put("price", "35.50");
		
		RestAssured.baseURI="http://77.102.250.113:17354";
		RestAssured.basePath="/api/v1/books";
		
	}
	
	@Test
	public void createBook() {
		
		given()
		.auth().preemptive().basic("user4", "hlB5U1rA")
		.contentType("application/json")
		.body(map)
		
		 .when()
		 
		 	.post()
		 	
		.then()
			.statusCode(200)
				.and()
					.body("id", equalTo("2"))
					.body("name", equalTo("Test Driven Development: By Example"))
					.body("author", equalTo("Kent Beck"))
					.body("publication", equalTo("Addison-Wesley Professional"))	
					.body("category", equalTo("Programming"))
					.body("pages", equalTo("240"))
					.body("price", equalTo("29.40"));
		
	}
}
