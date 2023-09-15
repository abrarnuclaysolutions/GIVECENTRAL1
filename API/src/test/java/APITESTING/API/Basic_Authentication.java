package APITESTING.API;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Basic_Authentication {
	@Test
	public void basicauth()
	{
//		http://httpbin.org/basic-auth/kaif/kaif
//		given().baseUri("http://postman-echo.com").basePath("/basic-auth")
//		.when().auth().basic("kaifaslam","kaif12345khan").get();
//		.then().statusCode(200).log().all();
		RequestSpecification reqspe = RestAssured.given();
		reqspe.baseUri("http://httpbin.org");
		
		reqspe.basePath("/basic-auth/kaif/kaif");
		
		Response res = reqspe.auth().basic("kaif", "kaif").get();
		System.out.println("Response Body :"+res.getBody().asString());
		System.out.println("Response Content_Type :"+res.getContentType());
		System.out.println("Response Time :"+res.getTime());
		System.out.println("Response Status-Code :"+res.getStatusCode());
		System.out.println("Response StatusLine :"+res.statusLine());
	}

}
