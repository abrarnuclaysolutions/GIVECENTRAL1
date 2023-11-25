package APITESTING.API;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Receipt {
	static String accesstoken;

	@Test
	public void receipt() {
		RequestSpecification req = RestAssured.given();
		req.baseUri("https://gcapit.myworkforce.org");
		req.basePath("/oauth");
		JSONObject jo = new JSONObject();
		jo.put("username", "mral1");
		jo.put("password", "test123");
		jo.put("grant_type", "password");
		jo.put("user_type", "Location Administrator");
		req.contentType(ContentType.JSON).body(jo.toJSONString());
		Response res = req.auth().preemptive().basic("stacknew", "test123").post();
		res.prettyPrint();
		accesstoken = res.getBody().path("access_token");

		System.out.println("AccessToken : " + accesstoken);
		System.out.println();
		System.out.println("================================Receipt=============================");

		req.baseUri("http://gcapit.myworkforce.org");
		req.basePath("/receipt");
		String body = "{\"session_id\":\"pugbj6ae376t7kasjh0e6ph2i6\",\n"
				+ "\"email_id\":\"mamtabangari@myworkforce.org\"}";
		
		req.headers("Authorization",accesstoken).contentType(ContentType.JSON).body(body);
		Response res1 = req.auth().oauth2(accesstoken).post();
		res1.prettyPrint();
		

		
	}
}
