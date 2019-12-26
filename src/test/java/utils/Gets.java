package utils;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Gets {

	public String get_current_time() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmmss");
		LocalDateTime now = LocalDateTime.now();
		return formatter.format(now);
	}
	
	public String get_current_date() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		LocalDateTime now = LocalDateTime.now();
		return formatter.format(now);
	}
	
	public String get_current_timestamp() {
		return String.format("%s_%s", get_current_date(), get_current_time());
	}
}
