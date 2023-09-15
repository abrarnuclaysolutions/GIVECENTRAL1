package APITESTING.API;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Post_API {
	@Test
	public void postapi()
	{
		baseURI = "https://reqres.in/";
		basePath = "/api/users";
		String bodypost = "{\n"
				+ "    \"name\": \"morpheus\",\n"
				+ "    \"job\": \"leader\"\n"
				+ "}";
		
		given().
			baseUri(baseURI).
			basePath(basePath).
			contentType(ContentType.JSON).
			body(bodypost).
		when().
			post().
		then().statusCode(201).statusLine("HTTP/1.1 201 Created").log().all();
		
	}
}
