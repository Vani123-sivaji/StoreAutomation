package api.endpoints;

public class routes {

	public static String base_url="https://petstore.swagger.io/v2";
	
	//Store module
	
	
	
	public static String post_url=base_url+"/store/order";
	public static String get_url=base_url+"/store/order/{id}";
	public static String delete_url=base_url+"/store/order/{id}";
	
	//Pet Module
	
	public static String postpet_url=base_url+"/pet";
	public static String getpetId_url=base_url+"/pet/{id}";
	public static String uploadimage_url=base_url+"/pet/{id}/uploadImage";
	public static String putpet_url=base_url+"/pet";
	public static String getPetStatus_url=base_url+"/pet/findByStatus";
	public static String deletepetId_url=base_url+"/pet/{id}";
	public static String postpetId_url=base_url+"/pet";
	
}
