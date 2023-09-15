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

public class Pledge_Event {
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
	static String cfid1;
	static String cfid2;
	static String pcd;
	static String pamount;

	@Test
	public void oauth() {
		System.out.println(" ");
		System.out.println("==================oauth=====================");

		//print current date 
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		strdate = dtf.format(now);
		System.out.println(strdate);
		RequestSpecification req = RestAssured.given();
		req.baseUri("https://gcapit.myworkforce.org");
		req.basePath("/oauth");
		String body = "{\n"
				+ "  \"username\":\"mral1\",\n"
				+ "  \"password\":\"test123\",\n"
				+ "  \"grant_type\" : \"password\",\n"
				+ "  \"user_type\":\"Location Administrator\"\n"
				+ "}\n"
				+ "";
		req.contentType(ContentType.JSON).body(body);
		Response res = req.auth().preemptive().basic("stacknew", "test123").post();
		res.prettyPrint();
		System.out.println(res.getStatusLine());
		accesstoken = res.getBody().path("access_token");
		System.out.println("Response AccessToken : "+accesstoken);
		System.out.println(" ");

	}
	@Test(dependsOnMethods = "oauth")
	public void pledgeevent() {
		System.out.println(" ");
		System.out.println("===================Pledge-Event=======================");

		RequestSpecification req = RestAssured.given();
		req.baseUri("https://gcapit.myworkforce.org");
		req.basePath("/events");
	
		String body = "{\n"
				+ "\"eventTitle\":\"ApiPledgeEvent\",\n"
				+ "\"eventStartDate\":\""+strdate+"\",\n"
				+ "\"eventEndDate\":\"2025-12-31\",\n"
				+ "\"eventType\":\"Pledged Events\",\n"
				+ "\"eventFrequency\":[\"One-Time\",\"Weekly\"],\n"
				+ "\"minimumAmounts\":[\"2\",\"2\"],\n"
				+ "\"suggestedAmount\":[\"2\",\"2\"],\n"
				+ "\"accountsMerchantId\":\"1\",\n"
				+ "\"displayOrder\":\"1\",\n"
				+ "\"categoryId\":[\"test category\"],\n"
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
				+ "}\n"
				+ "";
		req.headers("Authorization",accesstoken).contentType(ContentType.JSON).body(body);
		Response res = req.auth().oauth2(accesstoken).post();
		res.prettyPrint();
		System.out.println(res.getStatusLine());
		ResponseBody bo = res.getBody();
		JsonPath jp = bo.jsonPath();
		eventid = jp.getString("event_id");
		System.out.println("Event-Id : " + eventid);
		System.out.println(" ");
		cfid1 = jp.getString("customFields[0].customFieldId");
		cfid2 = jp.get("customFields[1].customFieldId");
	}
	@Test(dependsOnMethods = "pledgeevent")
	public void donor() {
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
		userid = jvp.getString("userid");
		System.out.println("userid : " + userid);

	}

	@Test(dependsOnMethods = "donor")
	public void paymentmethod() {
		System.out.println("==================payment-method====================");
		RequestSpecification req = RestAssured.given();
		req.baseUri("https://gcapit.myworkforce.org");
		req.basePath("/paymentMethods");
		String body = "{\"gcid\":\""+gcid+"\",\"address1\":\"address1\",\"address2\":\"address2\",\"donor_city\":\"donor_city\",\"donor_state\":\"donor_state\",\"zip\":\"zip\",\"country\":\"country\",\"payment_method_type\":\"Electronic_Check\",\"ec_account_name\"\n"
				+ ":\"ec_account_name\",\"ec_account_type\":\"Saving\",\"ec_bank_name\":\"ec_bank_name\",\"ec_routing\":\"123456789\",\"ec_account_no\":\"afe2f2104fe65e6e199e7708526b6f8d\",\"type\":\"donor\",\"session_id\":\"IPHSWIPEDA86C86D-4VB7-48A1-AA20-1X2ooD530B36\",\"memo\":\"first memo\",\"supressMail\":\"0\",\"suppressGcid\":\"no\",\"firmware\":\"3.2.0.1\"}";
		req.headers("Authorization", accesstoken).contentType(ContentType.JSON).body(body);
		Response res = req.auth().oauth2(accesstoken).post();
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
		String body = "{\"data\":[\n"
				+ "\n"
				+ "{\n"
				+ "\"userid\":\""+userid+"\",\n"
				+ "\"eventId\":\""+eventid+"\",\n"
				+ "\"locationId\":\"1\",\n"
				+ "\"frequency\":\"One-Time\",\n"
				+ "\"firstPaymentDate\":\""+strdate+"\",\n"
				+ "\"pledgeAmount\":\"2\",\n"
				+ "\"installmentAmount\":\"2\",\n"
				+ "\"tributeGift\":\"\",\n"
				+ "\"customFieldId\":[ \""+cfid1+"\",\""+cfid2+"\"],\n"
				+ "\"customFieldValue\":[\"test1\",\"test2\"]\n"
				+ "}\n"
				+ "]}";
		String at = accesstoken;
		req.headers("Authorization", accesstoken).contentType(ContentType.JSON).body(body);
		Response res = req.auth().oauth2(accesstoken).post();
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
		
		pcd = jvp.getString("data[\"gift Summary\"][0].created_datetime");
		System.out.println("pcd : " + pcd);
		pamount = jvp.getString("data[\"gift Summary\"][0].pledgeAmount");
		System.out.println("pamount : " + pamount);

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
		String Body = "{\n"
				+ "\"event_id\":\""+eventid+"\",\n"
				+ "\"donor_type\":\"User\",\n"
				+ "\"gcid\":\""+gcid+"\",\n"
				+ "\"payment_frequency\":\""+frequency+"\",\n"
				+ "\"payment_start_date\":\""+strdate+"\",\n"
				+ "\"amount\":\""+amount+"\",\n"
				+ "\"pledge_amount\":\""+pamount+"\",\n"
				+ "\"pledge_creation_date\":\""+pcd+"\",\n"
				+ "\"donor_payment_method_id\":\""+pmid+"\",\n"
				+ "\"never_end_date\":\"false\",\n"
				+ "\"session_id\":\""+sessionid+"\",\n"
				+ "\"cartId\":\""+id+"\",\n"
				+ "\"custom_field_id\": [ ],\n"
				+ "\"custom_field_value\": [ ],\n"
				+ "\"device_type\":\"Web\",\n"
				+ "\"memo\":\"65ghvh\",\n"
				+ "\"allowAllStatus\":\"No\",\n"
				+ "\"pageType\":\"religious education\"\n"
				+ "}";
		req.headers("Authorization", accesstoken).contentType(ContentType.JSON).body(Body);
		Response res = req.auth().oauth2(accesstoken).post();
		System.out.println(res.getStatusLine());
		res.prettyPrint();
		
		System.out.println("Response Body : " + res.getBody().asString());
		System.out.println("status code : "+res.getStatusCode());

	}
}
