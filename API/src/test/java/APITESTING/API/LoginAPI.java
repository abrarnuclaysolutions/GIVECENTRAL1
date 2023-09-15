package APITESTING.API;

import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import freemarker.core._DelayedFTLTypeDescription;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class LoginAPI {
	// 1.oauth
	// 2.event
	// 3.donor
	// 4.paymentmethod
	// 5.giftbox
	// 6.signup
	public static String accessToken;
	static String id;
	public static String eventid;
	static String frequency;
	static String startdate;
	static String enddate;
	static String sessionid;
	static String amount;
	static String date;
	static String gcid;
	static String userid;
	static String pmid;
	static String strDate;
	

	@Test
	public void oauth() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println(dtf.format(now));  
		strDate = dtf.format(now);
		System.out.println(strDate);
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

		accessToken = res.getBody().path("access_token");
		System.out.println(" ");

		System.out.println("accessToken : " + accessToken);
		System.out.println(" ");

	}

	@Test(dependsOnMethods = "oauth")
	public void event() {
		System.out.println("=====================Events==================");
		RequestSpecification req = RestAssured.given();
		req.baseUri("https://gcapit.myworkforce.org");
		req.basePath("/events");
		String body = "{\n" + "\"eventTitle\":\"apinormal\",\n" + "\"eventStartDate\":\""+strDate+"\",\n"
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

		req.headers("Authorization", accessToken).contentType(ContentType.JSON).body(body);
		Response res = req.auth().oauth2(accessToken).post();
		System.out.println(res.getStatusLine());
		res.prettyPrint();
		ResponseBody bo = res.getBody();
		JsonPath jvp = bo.jsonPath();
		eventid = jvp.getString("event_id");
		System.out.println("Eventid : " + eventid);
		System.out.println(" ");

	}

	@Test(dependsOnMethods = "event")
	public void Donor() {
		System.out.println("==================Donor====================");
		RequestSpecification req = RestAssured.given();
		req.baseUri("https://gcapit.myworkforce.org");
		req.basePath("/donor");
		String body = "{\n" + "\"userid\": \"24092012\",\n" + "\"address1\":\"MyWorkForce Technologies\",\n"
				+ "\"address2\":\"\",\n" + "\"city\":\"delhi\",\n" + "\"country\":\"US\",\n"
				+ "\"current_employer\":\"Nuclay\",\n" + "\"date_of_birth\":\"2001-09-05\",\n"
				+ "\"email\":\"manishmanral@myworkforce.org\",\n" + "\"first_name\":\"mark\",\n"
				+ "\"gender\":\"Not Applicable\",\n" + "\"language\":\"English\",\n" + "\"last_name\":\"guera\",\n"
				+ "\"middle_name\":\"\",\n" + "\"occupation\":\"\",\n" + "\"parishid\":\"0000\",\n"
				+ "\"phone\":\"8447843869\",\n" + "\"primary_location_id\":\"1\",\n" + "\"religion\":\"\",\n"
				+ "\"sf_api_call\":\"1\",\n" + "\"special_needs\":\"None\",\n" + "\"state\":\"IL\",\n"
				+ "\"suffix_code\":\"CMF\",\n" + "\"telephone_type\":\"\",\n" + "\"user_title\":\"Mr\",\n"
				+ "\"zip\":\"11004\"\n" + "}";

		req.headers("Authorization", accessToken).contentType(ContentType.JSON).body(body);
		Response res = req.auth().oauth2(accessToken).post();
		res.prettyPrint();
		System.out.println(res.getStatusLine());
		System.out.println("Response body : " + res.getBody().asString());
		System.out.println("========================");
		ResponseBody bo = res.getBody();
		JsonPath jvp = bo.jsonPath();
		gcid = jvp.getString("gcid");
		System.out.println("gcid : " + gcid);
		userid = jvp.getString("userid");
		System.out.println("userid : " + userid);

	}

	@Test(dependsOnMethods = "Donor")
	public void paymentmethod() {
		System.out.println("==================payment-method====================");
		RequestSpecification req = RestAssured.given();
		req.baseUri("https://gcapit.myworkforce.org");
		req.basePath("/paymentMethods");
		String body = "{\"gcid\":\""+gcid+"\",\"address1\":\"address1\",\"address2\":\"address2\",\"donor_city\":\"donor_city\",\"donor_state\":\"donor_state\",\"zip\":\"zip\",\"country\":\"country\",\"payment_method_type\":\"Electronic_Check\",\"ec_account_name\"\n"
				+ ":\"ec_account_name\",\"ec_account_type\":\"Saving\",\"ec_bank_name\":\"ec_bank_name\",\"ec_routing\":\"123456789\",\"ec_account_no\":\"afe2f2104fe65e6e199e7708526b6f8d\",\"type\":\"donor\",\"session_id\":\"IPHSWIPEDA86C86D-4VB7-48A1-AA20-1X2ooD530B36\",\"memo\":\"first memo\",\"supressMail\":\"0\",\"suppressGcid\":\"no\",\"firmware\":\"3.2.0.1\"}";
		req.headers("Authorization", accessToken).contentType(ContentType.JSON).body(body);
		Response res = req.auth().oauth2(accessToken).post();
		res.prettyPrint();
		System.out.println(res.getStatusLine());
		System.out.println("Response body : " + res.getBody().asString());
		System.out.println("========================");
		//x.donor_payment_method_id
		ResponseBody bo = res.getBody();
		JsonPath jvp = bo.jsonPath();
		pmid = jvp.getString("donor_payment_method_id\n");
		System.out.println("pmid : " + pmid);
	}

	@Test(dependsOnMethods = "paymentmethod")
	public void giftbox() {
		System.out.println("===============GiftBox-Methods======================");
		RequestSpecification req = RestAssured.given();
		// url :
		// /gift-basket-checkout?isLoggedIn=Yes&sessionId=715hlhpl69m97lj5f15bj5a9j3
		// req.baseUri("https://gcapit.myworkforce.org");
		req.baseUri("https://gcapit.myworkforce.org");
		req.basePath("/gift-basket-checkout");
		req.queryParam("isLoggedIn", "Yes").queryParam("sessionId", "715hlhpl69m97lj5f15bj5a9j3");
		String body = "{\"data\":[\n" + "\n" + "           {\n" + "             \"userid\":\"" + userid + "\",\n"
				+ "            \"eventId\":\"" + eventid + "\",\n" + "            \"locationId\":\"1\",\n"
				+ "           \"frequency\":\"Annually\",\n" + "           \"firstPaymentDate\":\""+strDate+"\",\n"
				+ "            \"installmentAmount\":\"1\",\n" + "           \"tributeGift\":\"\",\n"
				+ "            \"neverEndDate\":\"Yes\"\n" + "\n" + "         }]}";
		String at = accessToken;
		req.headers("Authorization", accessToken).contentType(ContentType.JSON).body(body);
		Response res = req.auth().oauth2(accessToken).post();
//		Assert.assertEquals(res.getStatusCode(), 201);
		res.prettyPrint();
		System.out.println(res.getStatusLine());
		System.out.println("Response body : " + res.getBody().asString());
		System.out.println("========================");
//		
		ResponseBody bo = res.getBody();
		JsonPath jvp = bo.jsonPath();
		id = jvp.getString("data[\"gift Summary\"][0].id");
		System.out.println("id : " + id);
//		data["gift Summary"][0].eventId
//		eventid = jvp.getString("data[\"gift Summary\"][0].eventId");
//		System.out.println("Event-id : "+eventid);
		frequency = jvp.getString("data[\"gift Summary\"][0].frequency");
		System.out.println("frequency : " + frequency);

		startdate = jvp.getString("data[\"gift Summary\"][0].startDate");
		System.out.println("startDate : " + startdate);
		enddate = jvp.getString("data[\"gift Summary\"][0].endDate");
		System.out.println("endDate : " + enddate);

		sessionid = jvp.getString("data[\"gift Summary\"][0].session_id");
		System.out.println("sessionid : " + sessionid);

		amount = jvp.getString("data[\"gift Summary\"][0].amount");
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
				+ startdate + "\",\n" + "\"payment_end_date\":\"" + enddate + "\",\n" + "\"amount\":\"" + amount
				+ "\",\n" + "\"donor_payment_method_id\":\""+pmid+"\",\n" + "\"never_end_date\":\"false\",\n"
				+ "\"session_id\":\"" + sessionid + "\",\n" + "\"cartId\":\"" + id + "\",\n"// +
																							// "\"cartId\":\"2896\",\n"
				+ "\"custom_field_id\": [ \"29929\"],\n" + "\"custom_field_value\": [\"hema\" ],\n"
				+ "\"device_type\":\"Mobile\",\n" + "\"memo\":\"65ghvh\",\n" + "\"allowAllStatus\":\"No\"\n" + "}";
		req.headers("Authorization", accessToken).contentType(ContentType.JSON).body(Body);
		Response res = req.auth().oauth2(accessToken).post();
		System.out.println(res.getStatusLine());
		res.prettyPrint();
		System.out.println("Response Body : " + res.getBody().asString());
		System.out.println("status code : "+res.getStatusCode());

	}

}
