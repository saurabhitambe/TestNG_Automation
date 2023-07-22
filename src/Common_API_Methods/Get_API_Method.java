package Common_API_Methods;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class Get_API_Method {

	public static int ResponseStatusCode(String BaseURI, String Resource) {

		RestAssured.baseURI = BaseURI;
		int statusCode = given().header("Content-Type", "application/json").when().get(Resource).then().extract()
				.statusCode();
		return statusCode;

	}

	public static String ResponseBody(String BaseURI, String Resource) {

		RestAssured.baseURI = BaseURI;
		String ResponseBody = given().header("Content-Type", "application/json").when().get(Resource).then().extract()
				.response().asPrettyString();
		return ResponseBody;

	}
}
