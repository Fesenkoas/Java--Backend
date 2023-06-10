package fesenko.hw.model;

public class User {
	private String email;
	private String password;

	public User(String email, String password) {
		setEmail(email);
		setPassword(password);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (validate(email)) {
			this.email = email;
		} else {
			System.out.println(email + " is not valid");
		}
	}

	private boolean validate(String email) {
		int indexAt = email.indexOf('@');
		if (indexAt == -1 || indexAt != email.lastIndexOf('@')) {
			return false;
		}
		if (email.indexOf('.', indexAt) == -1) {
			return false;
		}
		if (email.lastIndexOf('.') >= email.length() - 2) {
			return false;
		}
		for (int i = 0; i < email.length(); i++) {
			char c = email.charAt(i);
			if (!(Character.isDigit(c) || Character.isAlphabetic(c) || c == '_' || c == '-' || c == '.' || c == '@')) {
				return false;
			}
		}
		return true;
	}

	public String getPassword() {
		return password;
	}

	/*
	 * 1) min 8 symbols 2) min one symbol in upperCase 3) min one symbol in
	 * lowerCase 4) min one digit 5) min one special symbol (!%@*&)
	 */
	public void setPassword(String password) {
		if (validationPass(password)) {
			this.password = password;
		} else {
			System.out.println("\033[1;31m" + password + " is not valid" + "\u001B[0m");
		}

	}

	private boolean validationPass(String password) {
		boolean digit = false, upper = false, lower = false, punct = false, length = password.length() >= 8;

		for (int i = 0; i < password.length(); i++) {
			char pass = password.charAt(i);
			if (Character.isDigit(pass)) {
				digit = Character.isDigit(pass);
			}
			if (Character.isUpperCase(pass)) {
				upper = Character.isUpperCase(pass);

			}
			if (Character.isLowerCase(pass)) {
				lower = Character.isLowerCase(pass);
			}

			if (pass == '!' || pass == '%' || pass == '@' || pass == '*' || pass == '&') {
				punct = true;
			}

		}
		if (digit && upper && lower && punct && length) {
			return true;
		}
		return ErrorMessage(digit, upper, lower, punct, length);
	}

	private boolean ErrorMessage(boolean digit, boolean upper, boolean lower, boolean punct, boolean length) {
		if (!digit) {
			System.out.println("\033[1;31m" + "In your password don't used digit " + "\u001B[0m");
		}
		if (!upper) {
			System.out.println("\033[1;31m" + "In your password don't used upper case " + "\u001B[0m");
		}
		if (!lower) {
			System.out.println("\033[1;31m" + "In your password don't used lower case " + "\u001B[0m");
		}
		if (!punct) {
			System.out.println("\033[1;31m" + "In your password don't used special symbols " + "\u001B[0m");
		}
		if (!length) {
			System.out.println("\033[1;31m" + "In your password length not corect, min 8 symbols " + "\u001B[0m");
		}
		return false;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + "]";
	}

}
