package APITESTING.API;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetPledgeEvent {
	@Test
	public void get_pledge_event() {
		RequestSpecification req = RestAssured.given();
		req.baseUri("https://gcapit.myworkforce.org");
		req.basePath("/events/33170");
		req.queryParam("locationId", "1");
		Response res = req.get();
		System.out.println("Status Line : "+res.getStatusLine());
		System.out.println("Response Time : "+res.getTime());
		res.prettyPrint();
	}
}
