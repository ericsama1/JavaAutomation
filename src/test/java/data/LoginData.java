package data;

public class LoginData {

	private static final String USER = "standard_user";
	private static final String LOCKED_USER = "locked_out_user";
	private static final String PASSWORD = "secret_sauce";
	private static final String LOCKED_MESSAGE = "Epic sadface: Sorry, this user has been locked out.";
	private static final String WRONG_USER_PASS = "Epic sadface: Username and password do not match any user in this service";

	public String get_user() {
		return USER;
	}
	
	public String get_lockedUser() {
		return LOCKED_USER;
	}
	
	public String get_password() {
		return PASSWORD;
	}
	
	public String get_lockedMessage() {
		return LOCKED_MESSAGE;
	}
	
	public String get_wrongUserPass() {
		return WRONG_USER_PASS;
	}
}
