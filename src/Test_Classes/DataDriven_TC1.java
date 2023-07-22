package Test_Classes;

import java.io.IOException;
import java.time.LocalDateTime;

import org.testng.Assert;
import Common_API_Methods.Common_Utility_Method;
import RequestRepository.DataDriven_RequestRepository;
import io.restassured.path.json.JsonPath;

public class DataDriven_TC1 {

	public static void extractor() throws IOException {

		int statusCode = Common_Utility_Method.ResponseStatusCode(DataDriven_RequestRepository.BaseURI(),
				DataDriven_RequestRepository.Post_Resource(), DataDriven_RequestRepository.Post_TC2());
		System.out.println(statusCode);

		String ResponseBody = Common_Utility_Method.ResponseBody(DataDriven_RequestRepository.BaseURI(),
				DataDriven_RequestRepository.Post_Resource(), DataDriven_RequestRepository.Post_TC2());
		System.out.println(ResponseBody);
	

		LocalDateTime currentdate = LocalDateTime.now();
		String expecteddate = currentdate.toString().substring(0, 11);
		JsonPath JspResponse = new JsonPath(ResponseBody);
		String Res_name = JspResponse.getString("name");
		String Res_job = JspResponse.getString("job");
		String Res_createdAt = JspResponse.getString("createdAt");
		Res_createdAt = Res_createdAt.substring(0, 11);

        //Validate the ResponseBody parameters
		Assert.assertEquals(Res_name, "Saurabhi");
		Assert.assertEquals(Res_job, "Client Service Engineer");
		Assert.assertEquals(Res_createdAt, expecteddate);

	}
}
