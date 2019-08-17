package pojo.response;

import com.google.gson.annotations.SerializedName;

public class ExampleRES {

	@SerializedName("Id")
	private Integer id;


	public static String ResponseData;

	public Integer respons(){
		return id;
	}



}
