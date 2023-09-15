package APITESTING.API;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Patch_API {
	@Test
	public void patchapi()
	{
		{
			String putbody = "{\n"
					+ "    \"name\": \"abrar\",\n"
					+ "    \"job\": \"zion resident\"\n"
					+ "}";
			given().
				baseUri("https://reqres.in/").
				basePath("/api/users/464").
				contentType(ContentType.JSON).
				body(putbody).
			when().
				patch().then().statusCode(200).statusLine("HTTP/1.1 200 OK").log().all();
		}
	}
//	@Test
//	public void get464user()
//	{
//		given().
//			baseUri("https://reqres.in").
//			basePath("/api/users/464").
//		when().
//			get().
//		then().
//			log().
//			all();
//	}
}
