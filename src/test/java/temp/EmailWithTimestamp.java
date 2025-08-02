package temp;

import java.util.Date;

public class EmailWithTimestamp {

	public static void main(String[] args) 
		{
			Date date = new Date();
			String currentDate =date.toString();
			String Removespaces=currentDate.replaceAll("\\s", "");
			String RemoveCollen=Removespaces.replaceAll(":", "");
			String emialWithCurrentTime = RemoveCollen+"@gmail.com";
			System.out.println(emialWithCurrentTime);
		}

	}


