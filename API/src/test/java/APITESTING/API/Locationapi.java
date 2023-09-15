package APITESTING.API;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Locationapi {
	@Test
	public void locationapi()
	{
		RequestSpecification req = RestAssured.given();
		
		req.baseUri("https://gcapit.myworkforce.org");
		req.basePath("/locations/1");
		
		Response res = req.get();
		
		System.out.println(res.getStatusCode());
		System.out.println(res.getBody().asString());
	}
}
