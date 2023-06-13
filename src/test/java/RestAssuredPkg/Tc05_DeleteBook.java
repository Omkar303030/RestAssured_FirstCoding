package RestAssuredPkg;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Tc05_DeleteBook {
	
	
	@Test
	public void deleteBook() {
		
		RestAssured.baseURI="http://77.102.250.113:17354";
		RestAssured.basePath="/api/v1/books/1";
		
		Response response=
		
		given()
		.when()
			.delete()
		.then()
		.statusCode(200)
		.log().all()
		.extract().response();
		
	}

}
