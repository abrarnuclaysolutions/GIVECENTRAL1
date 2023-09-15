package APITESTING.API;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.assertion.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class apidemo {
	@Test
	public void apigetcall() {
		System.out.println("Test-Get");
		Response res = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println("Response Code : "+res.getStatusCode());
		System.out.println(res.getTime());
		System.out.println(res.getBody().asString());
		System.out.println(res.getStatusLine());
		System.out.println(res.getHeader("content-type"));
		System.out.println(" ");
	}


	
	@Test
	public void apipostcall() {
		System.out.println("Test-Post");
		RestAssured.baseURI = "https://reqres.in/api";
		String  JsonPayload = "{\n"
				+ "    \"name\": \"kaif\",\n"
				+ "    \"job\": \"tester\"\n"
				+ "}";
		RestAssured.given().
			contentType(ContentType.JSON).
		body(JsonPayload)
		.when().
			post("/users")
		.then().
			statusCode(201).log().all();
		System.out.println(" ");
		
	}
	@Test
	public void apiputcall() {
		System.out.println("Test-Put");
		String url = "https://reqres.in/api/users/2";
		String body = "{\n"
				+ "    \"name\": \"morpheus\",\n"
				+ "    \"job\": \"zion resident\"\n"
				+ "}";
		
		Response res = RestAssured.given()
				.contentType(ContentType.JSON)
				.body(body).when()
				.put(url);
		int statuscode = res.getStatusCode();
		assert statuscode==200:"expected code"+statuscode;
		System.out.println("response body");
		System.out.println(res.getBody().asString());
		System.out.println(" ");
	}
	@Test
	public void apideletecall() {
		System.out.println("Test-Delete");
		String url = "https://reqres.in/api/users";
		int id = 2;
		RestAssured.
		given().
			baseUri(url).
		when().
			delete("/"+id).
		then().
			statusCode(204).log().all();
	}

}

