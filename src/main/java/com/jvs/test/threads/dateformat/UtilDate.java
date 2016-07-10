package com.jvs.test.threads.dateformat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilDate {
	public static final DateFormat MMMMdCommaYYYYFormat = new SimpleDateFormat("MMMM d, yyyy");
	public static final DateFormat MMMMddCommaYYYYFormat = new SimpleDateFormat("MMMM dd, yyyy");
	
	public static String getFormattedDate(Date dt, DateFormat dateFormat) {
		if (dt != null) {
			return dateFormat.format(dt);
		}
		return null;
	}

	// USE THIS IMPLEMENTATION
	public static String getFormattedDateMMMMdYYYY_ThreadSafe(Date dt) {
		return getFormattedDate(dt, new SimpleDateFormat("MMMM d, yyyy"));
	}
	public static String getFormattedDateMMMMddYYYY(Date dt) {
		return getFormattedDate(dt, new SimpleDateFormat("MMMM dd, yyyy"));
	}
	
	// DO NOT USE THIS IMPLEMENTATION (THEY ARE NOT THREAD SAFE)
	public static String getFormattedDateMMMMdYYYY_NO_ThreadSafe(Date dt) {
		return getFormattedDate(dt, MMMMdCommaYYYYFormat);
	}
	public static String getFormattedDateMMMMddYYYY_NO_ThreadSafe(Date dt) {
		return getFormattedDate(dt, MMMMddCommaYYYYFormat);
	}
}
