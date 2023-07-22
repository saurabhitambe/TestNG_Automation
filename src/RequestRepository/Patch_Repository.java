package RequestRepository;

public class Patch_Repository {
	
    public static String BaseURI() {
	     String baseURI = "https://reqres.in/";
	     return baseURI;	
   }

    public static String Patch_Resource() {
	     String Patch_Resource = "api/users/2";
	     return Patch_Resource;
  }

    public static String Patch_TC1() {
	     String RequestBody = "{\r\n"
	     		+ "    \"name\": \"Saurabhi\",\r\n"
	     		+ "    \"job\": \"Client Service Engineer\"\r\n"
	     		+ "}";
	     return RequestBody;
  }

  }