package APITESTING.API;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Digest_auth {
	@Test
	public void digestauth()
	{   //http://httpbin.org/digest-auth//kaif/kaif
		RequestSpecification req = RestAssured.given();
		
		req.baseUri("http://httpbin.org");
		req.basePath("/digest-auth/undefined/kaif/kaif");
		
		Response res = req.auth().digest("kaif", "kaif").get();
		
		System.out.println("Response StatusLine : "+res.statusLine());
		System.out.println("Response Status-Code : "+res.getStatusCode());
		System.out.println("Response Time : "+res.getTime());
		System.out.println("Response Content_Type : "+res.getContentType());
		System.out.println("Response Body : "+res.getBody().asString());
	}
}
