package APITESTING.API;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_API {
	@Test
	public void Get_api() 
	//https://reqres.in/api/users?page=2
	{
		RequestSpecification reqspe = RestAssured.given();
		
		reqspe.baseUri("https://reqres.in");
		reqspe.basePath("/api/users");
		reqspe.queryParam("page", "2");
		
		Response res = reqspe.get();
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.getBody().asString().contains("Michael"), true);
		System.out.println(res.getStatusLine());
		System.out.println(res.getStatusCode());
		System.out.println(res.getBody().asString());
		System.out.println(res.getTime());
		System.out.println(res.contentType());
		
//		x.data[2].first_name
		JsonPath jp = res.jsonPath();
		String fn = jp.get("data[2].first_name");
		Assert.assertEquals(fn , "Tobias","Verify first name");

	}
}
