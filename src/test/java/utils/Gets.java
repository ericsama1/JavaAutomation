package utils;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Gets {

	String timeFormat = "HHmmss";
	String dateFormat = "yyyyMMdd";
	
	
	/**
	 * Method to create a String with the current time
	 * @return String with the current time
	 */
	public String get_current_time() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(timeFormat);
		LocalDateTime now = LocalDateTime.now();
		return formatter.format(now);
	}
	
	/**
	 * Method to create a String with the current date
	 * @return String with the current date
	 */
	public String get_current_date() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
		LocalDateTime now = LocalDateTime.now();
		return formatter.format(now);
	}
	
	/**
	 * Method to create a String with the current date and time
	 * @return String with the currente date and time
	 */
	public String get_current_timestamp() {
		return String.format("%s_%s", get_current_date(), get_current_time());
	}
	
	/**
	 * Method to get a date passing X days
	 * @param days number of days to add. If the number is negative, subtract days
	 * @return A new date with add or subtract days
	 */
	public String obtener_dia(int days) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		return formatter.format(now.plusDays(days));
	}
}
