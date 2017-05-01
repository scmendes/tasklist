package org.smendes.tasklist.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DateUtil {
	
	private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	public static final String TIMEZONE_AMERICA_SAO_PAULO = "America/Sao_Paulo";

	private static final String NAME_CLASS = DateUtil.class.getName();
	private static final Logger LOGGER = Logger.getLogger(NAME_CLASS);
	
	/**
	 * Return a date as a string. Example: 2014-08-20 15:30 
	 * @return Date as string.
	 */
	public static String dateTimeAsString(Date date){
		String dateAsString = "";
		dateAsString = dateTimeFormat.format(date);
		return dateAsString;
	}
	
	/**
	 * Convert string as a date. 
	 * @return Date.
	 * @throws BusinessException 
	 */
	public static Date toDateTime(final String dateAsString) throws Exception {
		return dateTimeFormat.parse(dateAsString);
	}
	
	public static Date getCurrentDate(final String timezoneId) {
		Date currentDate = getCurrentDateWithTimeZone(timezoneId).getTime();
		return currentDate;
	}
	
	public static Calendar getCurrentDateWithTimeZone(String timezoneId) {

		if (timezoneId == null || timezoneId.trim().isEmpty()) {
			LOGGER.logp(Level.SEVERE, NAME_CLASS, "getCurrentDateWithTimeZone", "Param required 'timezoneId' is null or empty");
			return null;
		}
		
		TimeZone tz = TimeZone.getTimeZone(timezoneId);
		
		if (tz == null) {
			LOGGER.logp(Level.SEVERE, NAME_CLASS, "getCurrentDateWithTimeZone", "TimeZone is null. Param timezoneId=" + timezoneId);
			return null;
		}

		try {
			Date currentDate = new Date();
	
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(currentDate);
			calendar.setTimeZone(tz);			
			
			Calendar resultCalendar = new GregorianCalendar();
			
			resultCalendar.set(calendar.get(Calendar.YEAR), 
					calendar.get(Calendar.MONTH), 
					calendar.get(Calendar.DAY_OF_MONTH), 
					calendar.get(Calendar.HOUR_OF_DAY), 
					calendar.get(Calendar.MINUTE), 
					0);
			resultCalendar.set(Calendar.MILLISECOND, 0);

			return resultCalendar;

		} catch (Exception e) {
			LOGGER.logp(Level.SEVERE, NAME_CLASS, "getCurrentDateWithTimeZone", 
					"Error to get TimeZone", e);
			return null;
		} 
		
	}
	
}
