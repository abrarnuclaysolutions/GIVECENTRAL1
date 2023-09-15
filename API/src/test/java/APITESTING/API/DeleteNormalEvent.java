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
import APITESTING.API.LoginAPI;
public class DeleteNormalEvent {
	static String accesstoken;
	static String strdate;
	static String eventid;

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
	public void event() {
		System.out.println("=====================Events==================");
		RequestSpecification req = RestAssured.given();
		req.baseUri("https://gcapit.myworkforce.org");
		req.basePath("/events");
		String body = "{\n" + "\"eventTitle\":\"apinormal\",\n" + "\"eventStartDate\":\""+strdate+"\",\n"
				+ "\"eventEndDate\":\"2025-12-31\",\n" + "\"eventType\":\"Normal Events\",\n"
				+ "\"eventFrequency\":[\"One-Time\",\"Weekly\",\"Annually\",\"Monthly\"],\n"
				+ "\"minimumAmounts\":[\"1\",\"1\",\"1\",\"1\"],\n" + "\"suggestedAmount\":[\"1\",\"1\",\"1\",\"1\"],\n"
				+ "\"accountsMerchantId\":\"1\",\n" + "\"displayOrder\":\"1\",\n"
				+ "\"categoryId\":[\"asddsfasafds\"],\n" + "\"eventStatus\":\"Active\",\n"
				+ "\"percentageTaxDeduction\":\"2\",\n" + "\"address1\":\"\",\n" + "\"address2\":\"\",\n"
				+ "\"city\":\"\",\n" + "\"state\":\"\",\n" + "\"zip\":\"\",\n" + "\"glCode\":\"\",\n"
				+ "\"class\":\"\",\n" + "\"eventColor\":\"\",\n" + "\"defaultDate\":\"\",\n"
				+ "\"eventTemplateId\":\"\",\n" + "\"tributeGift\":\"\",\n" + "\"tributeLabel\":\"\",\n"
				+ "\"tributeStatus\":\"\",\n" + "\"entityUUId\":\"\",\n" + "\"platform\":\"\",\n"
				+ "\"taxDeductible\":\"\",\n" + "\"restrictDonationsBeyondEndDate\":\"0\",\n"
				+ "\"customFields\":[\"abc\",\"hdf\"],\n" + "\"customFieldValue\": [\"20\",\"23\" ]\n" + "}";

		req.headers("Authorization", accesstoken).contentType(ContentType.JSON).body(body);
		Response res = req.auth().oauth2(accesstoken).post();
		System.out.println(res.getStatusLine());
//		res.prettyPrint();
		ResponseBody bo = res.getBody();
		JsonPath jvp = bo.jsonPath();
		eventid = jvp.getString("event_id");
		System.out.println("Eventid : " + eventid);
		System.out.println(" ");

	}
	@Test(dependsOnMethods = "event")
	public void delete_normal_event() {
		System.out.println("===================Delete-Normal-Event=======================");

		RequestSpecification req = RestAssured.given();
		req.baseUri("https://gcapit.myworkforce.org");
		req.basePath("/events/"+eventid+"");
//		String body = "{\"eventId\":\"33179\" }";
		req.headers("Authorization",accesstoken).contentType(ContentType.JSON);
		Response res = req.auth().oauth2(accesstoken).delete();
		System.out.println("Status Line : "+res.getStatusLine());
		System.out.println("Response Time : "+res.getTime());
		res.prettyPrint();
		
	}
}
