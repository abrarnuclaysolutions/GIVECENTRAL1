package APITESTING.API;

import org.testng.annotations.Test;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class GetDonor {
	static String strdate;
	static String accesstoken;
	@Test
	public void oauth() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println(dtf.format(now));  
		strdate = dtf.format(now);
		System.out.println(strdate);
		System.out.println("====================oauth======================");

		RequestSpecification req = RestAssured.given();
		req.baseUri("https://gcapit.myworkforce.org");
		req.basePath("/oauth");
		String body = "{\n"
				+ "  \"username\":\"mral1\",\n"
				+ "  \"password\":\"test123\",\n"
				+ "  \"grant_type\" : \"password\",\n"
				+ "  \"user_type\":\"Location Administrator\"\n"
				+ "}";
		req.contentType(ContentType.JSON).body(body);
		Response res = req.auth().preemptive().basic("stacknew", "test123").post();
//		res.prettyPrint();
		System.out.println(res.getStatusLine());
		ResponseBody bo = res.getBody();
		JsonPath jp = bo.jsonPath();
		accesstoken = jp.get("access_token");
		System.out.println("accesstoken : "+accesstoken);
		System.out.println("==========================================");

	}
	
	@Test(dependsOnMethods = "oauth")
	public void get_Donor() {
		System.out.println("=====================Get-Donor=====================");
		RequestSpecification req = RestAssured.given();
		req.baseUri("https://gcapit.myworkforce.org");
		req.basePath("/donor/1304259");
		req.headers("Authorization",accesstoken).contentType(ContentType.JSON);
		Response res = req.auth().oauth2(accesstoken).get();
		System.out.println("Status Line : "+res.getStatusLine());
		System.out.println("Response Time : "+res.getTime());
		res.prettyPrint();
	}
}
