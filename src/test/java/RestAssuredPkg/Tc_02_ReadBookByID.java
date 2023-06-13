package RestAssuredPkg;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class Tc_02_ReadBookByID {

	@Test
	public void readBookByid() {
		
		given()
		 .auth().preemptive().basic("user4", "hlB5U1rA")
		 .when()
		 	.get("http://77.102.250.113:17354/api/v1/books/2")
		.then()
			.statusCode(200)
			.statusLine("HTTPS/1.1 200 OK")
			.assertThat().body("id", equalTo("2"))
			.assertThat().body("name", equalTo("Test Driven Development: By Example"))
			.assertThat().body("author", equalTo("Kent Beck"))
			.assertThat().body("publication", equalTo("Addison-Wesley Professional"))
			.assertThat().body("category", equalTo("Programming"))
			.assertThat().body("pages", equalTo("240"))
			.assertThat().body("price", equalTo("29.26"));
		
	}
	
}
