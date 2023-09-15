package APITESTING.API;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Delete_API {
	@Test
	public void deleteapi()
	{
		given().
			baseUri("https://reqres.in").
			basePath("/api/users/464").
		when()
			.delete().
		then().
			log()
			.all();
	}
	@Test
	public void get464user()
	{
		given().
			baseUri("https://reqres.in").
			basePath("/api/users/464").
		when().
			get().
		then().
			log().
			all();
	}
}
