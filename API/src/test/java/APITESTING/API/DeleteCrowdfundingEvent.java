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

public class DeleteCrowdfundingEvent {
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
	public void crowdfunding() {
		System.out.println("");
		System.out.println("================Crowdfunding-Event===================");

		RequestSpecification req = RestAssured.given();
		req.baseUri("https://gcapit.myworkforce.org");
		req.basePath("/events");
		
		String body = "	{\n"
				+ "		\"eventTitle\":\"ApiCrowdfunding\",\n"
				+ "		\"eventStartDate\":\""+strdate+"\",\n"
				+ "		\"eventEndDate\":\"2025-12-31\",\n"
				+ "		\"eventType\":\"Crowdfunding\",\n"
				+ "		\"eventFrequency\":[\"One-Time\"],\n"
				+ "		\"minimumAmounts\":[\"2\"],\n"
				+ "		\"suggestedAmount\":[\"2\"],\n"
				+ "		\"accountsMerchantId\":\"1\",\n"
				+ "		\"displayOrder\":\"1\",\n"
				+ "		\"categoryId\":[\"test category\"],\n"
				+ "		\"eventStatus\":\"Active\",\n"
				+ "		\"percentageTaxDeduction\":\"2\",\n"
				+ "		\"goalAmount\":\"3\",\n"
				+ "		\"address1\":\"\",\n"
				+ "		\"address2\":\"\",\n"
				+ "		\"city\":\"\",\n"
				+ "		\"state\":\"\",\n"
				+ "		\"zip\":\"\",\n"
				+ "		\"glCode\":\"\",\n"
				+ "		\"class\":\"\",\n"
				+ "		\"eventColor\":\"\",\n"
				+ "		\"defaultDate\":\"\",\n"
				+ "		\"eventTemplateId\":\"\",\n"
				+ "		\"tributeGift\":\"\",\n"
				+ "		\"tributeLabel\":\"\",\n"
				+ "		\"tributeStatus\":\"\",\n"
				+ "		\"entityUUId\":\"\",\n"
				+ "		\"platform\":\"\",\n"
				+ "		\"taxDeductible\":\"Yes\",\n"
				+ "		\"restrictDonationsBeyondEndDate\":\"1\",\n"
				+ "		\"customFields\":[\"abc\",\"hdf\"],\n"
				+ "		\"customFieldValue\": [\"20\",\"23\" ]\n"
				+ "		}\n"
				+ "";
		req.headers("Authorization",accesstoken).contentType(ContentType.JSON).body(body);
		Response res = req.auth().oauth2(accesstoken).post();
//		res.prettyPrint();
		System.out.println(res.getStatusLine());
		ResponseBody bo = res.getBody();
		JsonPath jp = bo.jsonPath();
		eventid = jp.getString("event_id");
		System.out.println("Event-Id : " + eventid);
		System.out.println(" ");
	}
	@Test(dependsOnMethods = "crowdfunding")
	public void delete_pledge_event() {
		System.out.println("===================Delete-Crowdfunding-Event=======================");

		RequestSpecification req = RestAssured.given();
		req.baseUri("https://gcapit.myworkforce.org");
		req.basePath("/events/"+eventid);
//		String body = "{\"eventId\":\""+eventid+"\" }";
		req.headers("Authorization",accesstoken).contentType(ContentType.JSON);
		Response res = req.auth().oauth2(accesstoken).delete();
		System.out.println("Status Line : "+res.getStatusLine());
		System.out.println("Response Time : "+res.getTime());
		res.prettyPrint();
		
	}	
}
