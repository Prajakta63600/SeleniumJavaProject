package utils;

import java.util.Date;

public class CommonUtils {
	
	public static String generateEmail()
	{
	
		return new Date().toString().replaceAll("\\s", "").replaceAll("\\:", "")+"@gmail.com";

	}

}
