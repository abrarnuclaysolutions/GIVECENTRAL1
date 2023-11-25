package APITESTING.API;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthorizeUserProfile {
	static String accesstoken;
	
	@Test
	public void oauth() {
		RequestSpecification req = RestAssured.given();
		req.baseUri("https://gcapit.myworkforce.org");
		req.basePath("/oauth");
		JSONObject jo = new JSONObject();
		jo.put("username","mral1");
		jo.put("password","test123");
		jo.put("grant_type","password");
		jo.put("user_type","Location Administrator");
		
		req.contentType(ContentType.JSON).body(jo.toJSONString());
		Response res = req.auth().preemptive().basic("stacknew", "test123").post();
		System.out.println(res.getStatusLine());
		res.prettyPrint();
		accesstoken = res.getBody().path("access_token");
		System.out.println("AccessToken : "+ accesstoken);

		System.out.println("============================================================");
		
	}
	@Test(dependsOnMethods = "oauth")
	public void getauthorizeuserprofile() {
		System.out.println("==========================AuthorizeUserProfile==================================");

		RequestSpecification req = RestAssured.given();
		req.baseUri("https://gcapit.myworkforce.org");
		req.basePath("/get-authorize-user-profile/"+accesstoken+"");
		
		Response res = req.auth().oauth2(accesstoken).get();
		System.out.println(res.getStatusLine());

		res.prettyPrint();
	}
}
