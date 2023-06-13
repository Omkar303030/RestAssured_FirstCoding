package RestAssuredPkg;


import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class Tc_01_ReadAllBooks {

	    @Test
		public void readAllBooks() {
			
			given()
				.auth().preemptive().basic("user4", "hlB5U1rA")
			 .when()
			 	.get("http://77.102.250.113:17354/api/v1/books")
			.then()
				.statusCode(200)
				.statusLine("HTTPS/1.1 200 OK")
				
				.assertThat().body("id", equalTo("1"))
				.assertThat().body("name", equalTo("Clean Code: A Handbook of Agile Software Craftsmanship"))
				.assertThat().body("author", equalTo("Robert C. Martin"))
				.assertThat().body("publication", equalTo("Prentice Hall"))
				.assertThat().body("category", equalTo("Programming"))
				.assertThat().body("pages", equalTo("464"))
				.assertThat().body("price", equalTo("22"))
				
				.assertThat().body("id", equalTo("2"))
				.assertThat().body("name", equalTo("Test Driven Development: By Example"))
				.assertThat().body("author", equalTo("Kent Beck"))
				.assertThat().body("publication", equalTo("Addison-Wesley Professional"))
				.assertThat().body("category", equalTo("Programming"))
				.assertThat().body("pages", equalTo("240"))
				.assertThat().body("price", equalTo("29.26"));
			
		}
}
