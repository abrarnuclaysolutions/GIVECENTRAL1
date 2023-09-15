package APITESTING.API;

import org.testng.annotations.Test;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Ticket_Event {
	static String strdate;
	static String accesstoken;
	static String eventid;
	static String userid;
	static String gcid;
	static String pmid;
	static String id;
	static String frequency;
	static String startdate;
	static String enddate;
	static String sessionid;
	static String amount;
	@Test
	public void oauth() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println(dtf.format(now));  
		strdate = dtf.format(now);
		System.out.println(strdate);
//		{
//			  "username":"mral1",
//			  "password":"test123",
//			  "grant_type" : "password",
//			  "user_type":"Donor / Location Administrator"
//			}
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
		System.out.println(res.getStatusCode());
		System.out.println(res.getBody().asString());

		accesstoken = res.getBody().path("access_token");
		System.out.println(" ");

		System.out.println("accessToken : " + accesstoken);
		System.out.println(" ");

	}
	@Test(dependsOnMethods = "oauth")
	public void event() {
		System.out.println("=====================Ticket-Events==================");
		RequestSpecification req = RestAssured.given();
		req.baseUri("https://gcapit.myworkforce.org");
		req.basePath("/events");
		String body = "{\n"
				+ "\"eventTitle\":\"ApiTicketEvent\",\n"
				+ "\"eventStartDate\":\""+strdate+"\",\n"
				+ "\"eventEndDate\":\"2025-12-31\",\n"
				+ "\"eventType\":\"Ticket Events\",\n"
				+ "\"eventFrequency\":[\"One-Time\"],\n"
				+ "\"accountsMerchantId\":\"1\",\n"
				+ "\"displayOrder\":\"1\",\n"
				+ "\"categoryId\":[\"asddsfasafds\"],\n"
				+ "\"ticketAmount\":\"3\",\n"
				+ "\"NoOfTickets\":\"3\",\n"
				+ "\"ticketMin\":\"1\",\n"
				+ "\"ticketMax\":\"3\",\n"
				+ "\"eventStatus\":\"Active\",\n"
				+ "\"percentageTaxDeduction\":\"2\",\n"
				+ "\"address1\":\"\",\n"
				+ "\"address2\":\"\",\n"
				+ "\"city\":\"\",\n"
				+ "\"state\":\"\",\n"
				+ "\"zip\":\"\",\n"
				+ "\"glCode\":\"\",\n"
				+ "\"class\":\"\",\n"
				+ "\"eventColor\":\"\",\n"
				+ "\"defaultDate\":\"\",\n"
				+ "\"eventTemplateId\":\"\",\n"
				+ "\"tributeGift\":\"\",\n"
				+ "\"tributeLabel\":\"\",\n"
				+ "\"tributeStatus\":\"\",\n"
				+ "\"entityUUId\":\"\",\n"
				+ "\"platform\":\"\",\n"
				+ "\"taxDeductible\":\"\",\n"
				+ "\"restrictDonationsBeyondEndDate\":\"0\",\n"
				+ "\"customFields\":[\"abc\",\"hdf\"],\n"
				+ "\"customFieldValue\": [\"20\",\"23\" ]\n"
				+ "}";

		req.headers("Authorization", accesstoken).contentType(ContentType.JSON).body(body);
		Response res = req.auth().oauth2(accesstoken).post();
		System.out.println(res.getStatusLine());
		res.prettyPrint();
		ResponseBody bo = res.getBody();
		JsonPath jvp = bo.jsonPath();
		eventid = jvp.getString("event_id");
		System.out.println("Eventid : " + eventid);
		System.out.println(" ");

	}
	@Test(dependsOnMethods = "event")
	public void donor() {
		System.out.println("======================Donor==================");
		RequestSpecification req = RestAssured.given();
		req.baseUri("https://gcapit.myworkforce.org");
		req.basePath("/donor");
		String body = "{\n" + "\"userid\": \"24092013\",\n" + "\"address1\":\"MyWorkForce Technologies\",\n"
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
		ResponseBody bo = res.getBody();
		JsonPath jp = bo.jsonPath();
		gcid = jp.getString("gcid");
		userid = jp.getString("userid");
		
		System.out.println("gc-id : "+ gcid);
		System.out.println("user-id : "+ userid);
		System.out.println(" ");
	}
	@Test(dependsOnMethods = "donor")
	public void paymentmethod() {
		System.out.println("=======================paymentmethod====================");
		RequestSpecification req = RestAssured.given();
		req.baseUri("https://gcapit.myworkforce.org");
		req.basePath("/paymentMethods");
		
		String body = "{\"gcid\":\""+gcid+"\",\"address1\":\"address1\",\"address2\":\"address2\",\"donor_city\":\"donor_city\",\"donor_state\":\"donor_state\",\"zip\":\"zip\",\"country\":\"country\",\"payment_method_type\":\"Electronic_Check\",\"ec_account_name\"\n"
				+ ":\"ec_account_name\",\"ec_account_type\":\"Saving\",\"ec_bank_name\":\"ec_bank_name\",\"ec_routing\":\"123456789\",\"ec_account_no\":\"afe2f2104fe65e6e199e7708526b6f8d\",\"type\":\"donor\",\"session_id\":\"IPHSWIPEDA86C86D-4VB7-48A1-AA20-1X2ooD530B36\",\"memo\":\"first memo\",\"supressMail\":\"0\"}";
		req.headers("Authorization",accesstoken).contentType(ContentType.JSON).body(body);
		Response res = req.auth().oauth2(accesstoken).post();
		res.prettyPrint();
		System.out.println(res.getStatusLine());
		ResponseBody bo = res.getBody();
		JsonPath jp = bo.jsonPath();
		pmid = jp.getString("donor_payment_method_id");
		System.out.println("Pm-id : "+pmid);
		System.out.println(" ");
	}
	@Test(dependsOnMethods = "paymentmethod")
	public void giftbox() {
		System.out.println(userid);
		System.out.println(eventid);
		System.out.println("====================giftbox================");
		RequestSpecification req = RestAssured.given();
		req.baseUri("https://gcapit.myworkforce.org");
		req.basePath("/gift-basket-checkout");
		req.queryParam("isLoggedIn", "Yes").queryParam("sessionId", "715hlhpl69m97lj5f15bj5a9j3");
		String body = "{\"data\":[\n"
				+ "\n"
				+ "{\n"
				+ "\"userid\":\""+userid+"\",\n"
				+ "\"eventId\":\""+eventid+"\",\n"
				+ "\"locationId\":\"1\",\n"
				+ "\"quantity\":\"1\",\n"
				+ "\"tributeGift\":\"\"\n"
				+ "\n"
				+ "}\n"
				+ "]}";
		req.headers("Authorization",accesstoken).contentType(ContentType.JSON).body(body);
		Response res = req.auth().oauth2(accesstoken).post();
		res.prettyPrint();
		System.out.println(res.getStatusLine());
		ResponseBody bo = res.getBody();
		JsonPath jp = bo.jsonPath();
		id = jp.getString("data[\"gift Summary\"][0].id");
		System.out.println("id : " + id);
//		data["gift Summary"][0].eventId
//		eventid = jvp.getString("data[\"gift Summary\"][0].eventId");
//		System.out.println("Event-id : "+eventid);
		frequency = jp.getString("data[\"gift Summary\"][0].frequency");
		System.out.println("frequency : " + frequency);

		startdate = jp.getString("data[\"gift Summary\"][0].startDate");
		System.out.println("startDate : " + startdate);
		enddate = jp.getString("data[\"gift Summary\"][0].endDate");
		System.out.println("endDate : " + enddate);

		sessionid = jp.getString("data[\"gift Summary\"][0].session_id");
		System.out.println("sessionid : " + sessionid);

		amount = jp.getString("data[\"gift Summary\"][0].amount");
		System.out.println("amount : " + amount);
		System.out.println("==================================================");
		System.out.println(" ");
	}
	@Test(dependsOnMethods = "giftbox")
	public void signup() {
		System.out.println("============SignUP-Methods=========================");
		RequestSpecification req = RestAssured.given();
		req.baseUri("https://gcapit.myworkforce.org");
		req.basePath("/signups");
//
		String Body = "{\n" + "\"event_id\":\"" + eventid + "\",\n" + "\"donor_type\":\"User\",\n" + "\"gcid\":\""
				+ gcid + "\",\n" + "\"payment_frequency\":\"" + frequency + "\",\n" + "\"payment_start_date\":\""
				+ startdate + "\",\n" + "\"no_of_tickets\":\"3\",\n" + "\"amount\":\"" + amount
				+ "\",\n" + "\"donor_payment_method_id\":\""+pmid+"\",\n" + "\"never_end_date\":\"false\",\n"
				+ "\"session_id\":\"" + sessionid + "\",\n" + "\"cartId\":\"" + id + "\",\n"// +
																							// "\"cartId\":\"2896\",\n"
				+ "\"custom_field_id\": [ \"29929\"],\n" + "\"custom_field_value\": [\"hema\" ],\n"
				+ "\"device_type\":\"Mobile\",\n" + "\"memo\":\"65ghvh\",\n" + "\"allowAllStatus\":\"No\"\n" + "}";
		req.headers("Authorization", accesstoken).contentType(ContentType.JSON).body(Body);
		Response res = req.auth().oauth2(accesstoken).post();
		System.out.println(res.getStatusLine());
		res.prettyPrint();
		System.out.println("Response Body : " + res.getBody().asString());

	}
	
}
