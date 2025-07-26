package temp;

import java.util.Date;

public class EmailWithTimestamp {

	public static void main(String[] args) {
	
		Date date = new Date();
		String currentdate=date.toString();
		String removespacesDate=currentdate.replaceAll("\\s", "");
		String removeSpacesAndColonDate = removespacesDate.replaceAll("\\:", "");
		String EmailWithTimeStamp=removeSpacesAndColonDate+"@gmail.com";
		System.out.println(EmailWithTimeStamp);

	}

}
