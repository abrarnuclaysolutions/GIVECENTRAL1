package APITESTING.API;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.sql.Date;
import java.time.LocalDate;
//
//import org.testng.Assert;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import org.testng.annotations.Test;
//
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//import APITESTING.API.LoginAPI.*;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
//import java.util.Date;  
import java.util.Calendar; 
//
public class Signup {
	@Test
	public void signup() {
		
//		java.util.Date date = Calendar.getInstance().getTime();
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
//		String strDate = dateFormat.format(date);  
//		System.out.println(strDate);
		
//		Date date = new Date(0);  
//	    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
//	    String strDate = formatter.format(date);  
//	    System.out.println("Date Format with MM/dd/yyyy : "+strDate);  
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println(dtf.format(now));  
		String date = dtf.format(now);
		System.out.println(date);
//        LocalDate date1 = java.time.LocalDate.now(); 
//        System.out.println(date1);
        
//        Date date = (java.sql.Date) Calendar.getInstance().getTime();  
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
//        String strDate = dateFormat.format(date);  
//        System.out.println("Converted String: " + strDate);  

//		RequestSpecification req = RestAssured.given();
//		req.baseUri("https://gcapit.myworkforce.org");
//		req.basePath("/signups");
////
//		String Body = "{\n"
//				+ "\"event_id\":\"33053\",\n"
//				+ "\"donor_type\":\"User\",\n"
//				+ "\"gcid\":\"1304150\",\n"
//				+ "\"payment_frequency\":\"Annually\",\n"
//				+ "\"payment_start_date\":\"2023-08-13\",\n"
//				+ "\"payment_end_date\":\"2025-12-31\",\n"
//				+ "\"amount\":\"1.00\",\n"
//				+ "\"donor_payment_method_id\":\"5065\",\n"
//				+ "\"never_end_date\":\"false\",\n"
//				+ "\"session_id\":\"715hlhpl69m97lj5f15bj5a9j3\",\n"
//				+ "\"cartId\":\"5678\",\n"
//				+ "\"custom_field_id\": [ \"29929\"],\n"
//				+ "\"custom_field_value\": [\"hema\" ],\n"
//				+ "\"device_type\":\"Mobile\",\n"
//				+ "\"memo\":\"65ghvh\",\n"
//				+ "\"allowAllStatus\":\"No\"\n"
//				+ "}";
////		String Body = "{\n"
////				+ "\"event_id\":\""+eventid+"\",\n"
////				+ "\"donor_type\":\"User\",\n"
////				+ "\"gcid\":\"1304150\",\n"
////				+ "\"payment_frequency\":\"\"+frequency+\"\,\n"
////				+ "\"payment_start_date\":\"2016-07-28\",\n"
////				+ "\"payment_end_date\":\"2016-08-15\",\n"
////				+ "\"amount\":\"1\",\n"
////				+ "\"donor_payment_method_id\":\"2059\",\n"
////				+ "\"never_end_date\":\"false\",\n"
////				+ "\"session_id\":\"AND123451518@abc\",\n"
////				+ "\"cartId\":\"2896\",\n"
////				+ "\"custom_field_id\": [ \"29929\"],\n"
////				+ "\"custom_field_value\": [\"hema\" ],\n"
////				+ "\"device_type\":\"Mobile\",\n"
////				+ "\"memo\":\"65ghvh\",\n"
////				+ "\"allowAllStatus\":No\n"
////				+ "}";
//		String at = "a673f7f6d7ad2347b1d417c3843f3211b4592045";
//		req.headers("Authorization",at).contentType(ContentType.JSON).body(Body);
//		Response res = req.auth().oauth2(at).post();
//		res.prettyPrint();
//		System.out.println(res.getStatusLine());
//		System.out.println();
	}
//
}
