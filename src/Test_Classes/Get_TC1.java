package Test_Classes;

import org.testng.annotations.Test;

import Common_API_Methods.Get_API_Method;
import RequestRepository.Get_Repository;

public class Get_TC1 {
@Test
	public static void extractor() {
		
		int statusCode = Get_API_Method.ResponseStatusCode(Get_Repository.BaseURI(), Get_Repository.Get_Resource());
		System.out.println(statusCode);
		
		String ResponseBody = Get_API_Method.ResponseBody(Get_Repository.BaseURI(), Get_Repository.Get_Resource());
		System.out.println(ResponseBody);
		
	}
}
