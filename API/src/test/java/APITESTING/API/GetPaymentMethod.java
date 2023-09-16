package APITESTING.API;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetPaymentMethod {

	static String accesstoken;

	@Test
	public void oauth() {

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

		System.out.println("Status code : " + res.getStatusLine());
		res.prettyPrint();
		accesstoken = res.getBody().path("access_token");
		System.out.println("AccessToken : " + accesstoken);
		System.out.println(" ");
		System.out.println("======================================================");

	}
	@Test(dependsOnMethods = "oauth")
	public void getpaymentmethod() {
		System.out.println("=================getpaymentmethod====================");
		RequestSpecification req = RestAssured.given();
		req.baseUri("https://gcapit.myworkforce.org");
		req.basePath("/paymentMethods/5231");
		req.headers("Authorization","accesstoken").contentType(ContentType.JSON);
		Response res = req.auth().oauth2(accesstoken).get();
		res.prettyPrint();
	}

}
