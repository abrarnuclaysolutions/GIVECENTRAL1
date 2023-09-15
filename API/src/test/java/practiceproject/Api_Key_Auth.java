package practiceproject;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Api_Key_Auth {

	@Test
	public void apikeyauth()
	{
		//URL : https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
		//api key : 2b9afc1ffb487081e56a5e936af013d1
		
		RequestSpecification req = RestAssured.given();
		
		req.baseUri("https://api.openweathermap.org");
		req.basePath("/data/2.5/weather");
		req.queryParam("q", "sansarpur").queryParam("appid", "2b9afc1ffb487081e56a5e936af013d1");
		
		Response res = req.get();
		
		AssertJUnit.assertEquals(res.getStatusLine(), "HTTP/1.1 200 OK");
		
		System.out.println();
		System.out.println("Response Statusline : "+res.getStatusLine());
		System.out.println();
		System.out.println("Response ContentType : "+res.getContentType());
		System.out.println();
		System.out.println("Response Time : "+res.getTime());
		System.out.println();
		System.out.println("Response Body : "+res.getBody().asString());
		System.out.println();
	}
}
