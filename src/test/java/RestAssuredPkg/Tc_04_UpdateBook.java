package RestAssuredPkg;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Tc_04_UpdateBook {
	
	public static HashMap<String, String> map= new HashMap<String, String>();
	
	@BeforeClass
	public void testdata() {
		map.put("id", "2");
		map.put("name", "Test Driven Development: By Example");
		map.put("author", "Kent Beck");
		map.put("publication", "Addison-Wesley Professional");
		map.put("category", "Programming");
		map.put("pages", "240");
		map.put("price", "29.26");
		
		RestAssured.baseURI="http://77.102.250.113:17354";
		RestAssured.basePath="/api/v1/books/2";
		
	}
	
	@Test
	public void update() {
		
		given()
		.log().all()
		.auth().preemptive().basic("user4", "hlB5U1rA")
		.contentType("application/json")
		.body(map)
		
		 .when()
		 
		 	.put()
		 	
		.then()
			.statusCode(200)
			.log().all();
		
	}
}
