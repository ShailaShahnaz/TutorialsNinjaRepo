package com.tutorialsninja.utilities;

import java.util.Date;

public class Utilities {
	
	public static String generateDateTimeStamp() {
		  Date date = new Date();
		  String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
		  return timeStamp + "@gmail.com";
	  }
	
	public static final int implicitly_Wait = 10;
	public static final int pageLoad_Timeout = 10;
}
