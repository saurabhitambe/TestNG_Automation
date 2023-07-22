package Test_Classes;

import java.time.LocalDateTime;
import org.testng.Assert;
import org.testng.annotations.Test;
import Common_API_Methods.Put_API_Method;
import RequestRepository.Put_Repository;
import io.restassured.path.json.JsonPath;

public class Put_TC1 {
@ Test
	public static void extractor() {
		
		int statusCode = Put_API_Method.ResponseStatusCode(Put_Repository.BaseURI(), Put_Repository.Put_Resource(), 
				         Put_Repository.Put_TC1());
		System.out.println(statusCode);
		
		String ResponseBody = Put_API_Method.ResponseBody(Put_Repository.BaseURI(), Put_Repository.Put_Resource(), 
				              Put_Repository.Put_TC1());
		System.out.println(ResponseBody);
		

		LocalDateTime currentdate = LocalDateTime.now();
		String expecteddate = currentdate.toString().substring(0, 11);
		JsonPath JspResponse = new JsonPath(ResponseBody);
		String Res_name = JspResponse.getString("name");
		String Res_job = JspResponse.getString("job");
		String Res_updatedAt = JspResponse.getString("updatedAt");
		Res_updatedAt = Res_updatedAt.substring(0, 11);

        //Validate the ResponseBody parameters
		Assert.assertEquals(Res_name, "Saurabhi");
		Assert.assertEquals(Res_job, "Client Service Engineer");
		Assert.assertEquals(Res_updatedAt, expecteddate);
	}
}
