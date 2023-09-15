package APITESTING.API;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BearerTokenAuth {

	@Test
	public void Bearertokenauth()
	{
		//url : https://gorest.co.in/public/v2/users
		//Token : a5444fdcd308db0a4538a53c6a865802a7fc65992e5727542ef8d8e665102dad
		//body : id
//		4240517
//		name Rajinder Khan
//		email khan_rajinder@wisoky.example
//		gender female
//		status inactive
		
		RequestSpecification req = RestAssured.given();
		
		req.baseUri("https://gorest.co.in");
		req.basePath("/public/v2/users");
		
		JSONObject jo = new JSONObject();
		jo.put("name","kaifaslam");
		jo.put("email","kaif@gmail.com");
		jo.put("gender","male");
		jo.put("status","active");
		
		String token = "Bearer a5444fdcd308db0a4538a53c6a865802a7fc65992e5727542ef8d8e665102dad";
		
		req.headers("Authorization", token).contentType(ContentType.JSON).body(jo.toJSONString());
		Response res = req.post();
		Assert.assertEquals(res.getStatusCode(), 201);
		
		System.out.println("Response Statusline : "+res.getStatusLine());
		System.out.println("Response ContentType : "+res.getContentType());
		System.out.println("Response Time : "+res.getTime());
		System.out.println("Response Body : "+res.getBody().asString());
		
		
	}
}
