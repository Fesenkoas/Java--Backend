package telran.validator.utils;

public class Validator {
	public static boolean checkCreditCardNumber(String str) {
		String pattern = "\\d{8,16}";
		return str.matches(pattern);
	}
	
	public static boolean checkDateFormatEU(String str) {
		String pattern = "([0][1-9]|[1-2][0-9]|[3][1])(\\.)([0][0-9]|[1][0-2])(\\.)\\d{4}";
		return str.matches(pattern);
	}
	
	public static boolean checkDateFormatUS(String str) {
		String pattern = "\\d{4}(-)([0][0-9]|[1][0-2])(-)([0][1-9]|[1-2][0-9]|[3][1])";
		return str.matches(pattern);
	}
	
	public static boolean checkPhoneNumber(String str) {
		String pattern = "\\+\\d{2}[(]\\d{2}[)]\\d{4}(-)\\d{4}";
		return str.matches(pattern);
	}
	
	public static boolean checkLessEquals255(String str) {
		String pattern = "([1-9]|[1-9][0-9]|[1][0-9][0-9]|[2][0-4][0-9]|[2][5][0-5])";
		return str.matches(pattern);
	}
}
