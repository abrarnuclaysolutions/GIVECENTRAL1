package APITESTING.API;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Donor {
	static String strdate;
	static String gcid;
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
	public void Donor() {
		System.out.println("==================Donor====================");
		RequestSpecification req = RestAssured.given();
		req.baseUri("https://gcapit.myworkforce.org");
		req.basePath("/donor");
		String body = "{\n" + "\"userid\": \"Kaifaslam\",\n" + "\"address1\":\"MyWorkForce Technologies\",\n"
				+ "\"address2\":\"\",\n" + "\"city\":\"delhi\",\n" + "\"country\":\"US\",\n"
				+ "\"current_employer\":\"Nuclay\",\n" + "\"date_of_birth\":\"2001-09-05\",\n"
				+ "\"email\":\"manishmanral@myworkforce.org\",\n" + "\"first_name\":\"mark\",\n"
				+ "\"gender\":\"Not Applicable\",\n" + "\"language\":\"English\",\n" + "\"last_name\":\"guera\",\n"
				+ "\"middle_name\":\"\",\n" + "\"occupation\":\"\",\n" + "\"parishid\":\"0000\",\n"
				+ "\"phone\":\"8447843869\",\n" + "\"primary_location_id\":\"1\",\n" + "\"religion\":\"\",\n"
				+ "\"sf_api_call\":\"1\",\n" + "\"special_needs\":\"None\",\n" + "\"state\":\"IL\",\n"
				+ "\"suffix_code\":\"CMF\",\n" + "\"telephone_type\":\"\",\n" + "\"user_title\":\"Mr\",\n"
				+ "\"zip\":\"11004\"\n" + "}";

		req.headers("Authorization", accesstoken).contentType(ContentType.JSON).body(body);
		Response res = req.auth().oauth2(accesstoken).post();
		res.prettyPrint();
		System.out.println(res.getStatusLine());
		System.out.println("Response body : " + res.getBody().asString());
		System.out.println("========================");
		ResponseBody bo = res.getBody();
		JsonPath jvp = bo.jsonPath();
		gcid = jvp.getString("gcid");
		System.out.println("gcid : " + gcid);


	}
}
