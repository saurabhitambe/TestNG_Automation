package Test_Classes;
import org.testng.Assert;
import org.testng.annotations.Test;
import Common_API_Methods.Post_Login_Methods;
import RequestRepository.Post_Login_Repository;
import io.restassured.path.json.JsonPath;

public class Post_Login_TC1 {
	@Test
	public static void extractor() {

		int statusCode = Post_Login_Methods.ResponseStatusCode(Post_Login_Repository.BaseURI(),
				Post_Login_Repository.Post_Resource(), Post_Login_Repository.Post_Req_TC1());
		System.out.println(statusCode);

		String ResponseBody = Post_Login_Methods.ResponseBody(Post_Login_Repository.BaseURI(),
				Post_Login_Repository.Post_Resource(), Post_Login_Repository.Post_Req_TC1());
		System.out.println(ResponseBody);

		JsonPath JspResponse = new JsonPath(ResponseBody);
		String Res_token = JspResponse.getString("token");
		Assert.assertEquals(Res_token, "QpwL5tke4Pnpja7X4");
	}
}