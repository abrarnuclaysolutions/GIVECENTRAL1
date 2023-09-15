package APITESTING.API;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Put_API {
	@Test
	public void putapi()
	{
		String putbody = "{\n"
				+ "    \"name\": \"Kaif\",\n"
				+ "    \"job\": \"zion resident\"\n"
				+ "}";
		given().
			baseUri("https://reqres.in/").
			basePath("/api/users/464").
			contentType(ContentType.JSON).
			body(putbody).
		when().
			put().then().statusCode(200).statusLine("HTTP/1.1 200 OK").log().all();
	}
}
