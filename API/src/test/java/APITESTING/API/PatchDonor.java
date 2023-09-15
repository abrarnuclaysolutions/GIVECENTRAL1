package APITESTING.API;

import org.testng.annotations.Test;
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

public class PatchDonor {
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
	public void Update_Donor() {
		System.out.println("==================Patch-Donor========================");

		RequestSpecification req = RestAssured.given();
		req.baseUri("https://gcapit.myworkforce.org");
		req.basePath("/donor/1304259");
		String body = "{\n"
				+ "\"address1\":\"MyWorkForce Technologies\",\n"
				+ "\"address2\":\"Sansarpur\",\n"
				+ "\"city\":\"delhi\",\n"
				+ "\"country\":\"US\",\n"
				+ "\"current_employer\":\"NuclaySolutions\",\n"
				+ "\"date_of_birth\":\"2000-01-01\",\n"
				+ "\"email\":\"abrar@myworkforce.org\",\n"
				+ "\"first_name\":\"abrar\",\n"
				+ "\"gender\":\"Male\",\n"
				+ "\"language\":\"English\",\n"
				+ "\"last_name\":\"khan\",\n"
				+ "\"middle_name\":\"Salman\",\n"
				+ "\"occupation\":\"\",\n"
				+ "\"parishid\":\"0000\",\n"
				+ "\"phone\":\"8447843869\",\n"
				+ "\"primary_location_id\":\"569\",\n"
				+ "\"religion\":\"\",\n"
				+ "\"sf_api_call\":\"1\",\n"
				+ "\"special_needs\":\"None\",\n"
				+ "\"state\":\"IL\",\n"
				+ "\"suffix_code\":\"CMF\",\n"
				+ "\"telephone_type\":\"\",\n"
				+ "\"user_title\":\"Mr\",\n"
				+ "\"zip\":\"11004\"\n"
				+ "}";
		req.headers("Authorization",accesstoken).contentType(ContentType.JSON).body(body);
		Response res = req.auth().oauth2(accesstoken).patch();
		res.prettyPrint();
		System.out.println(res.getStatusLine());
	}
	
	
}
