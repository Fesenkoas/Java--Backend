package telran.user.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.user.model.User;

class UserTest {
	User user;
	String email = "aleks@gmail.com";
	String password = "123456Ab!";

	@BeforeEach
	void setUp() throws Exception {
		user = new User(email, password);
	}

	@Test
	void testValidPassword() {
		String validPassword = "qwertY1@";
		user.setPassword(validPassword);
		assertEquals(validPassword, user.getPassword());
	}
	
	@Test
	void testPasswordLength() {
		String inValidPassword = "werdY1@";
		user.setPassword(inValidPassword);
		assertEquals(password, user.getPassword());
	}
	
	@Test
	void testPasswordUpperCase() {
		String inValidPassword = "qwerty1@";
		user.setPassword(inValidPassword);
		assertEquals(password, user.getPassword());
	}
	
	@Test
	void testPasswordLowerCase() {
		String inValidPassword = "QWERTY1@";
		user.setPassword(inValidPassword);
		assertEquals(password, user.getPassword());
	}
	
	@Test
	void testPasswordDigits() {
		String inValidPassword = "qwertYz@";
		user.setPassword(inValidPassword);
		assertEquals(password, user.getPassword());
	}

	@Test
	void testPasswordSpecialSymbols() {
		String inValidPassword = "qwertY12";
		user.setPassword(inValidPassword);
		assertEquals(password, user.getPassword());
	}
	//Email
	@Test
	void testValidEmail() {
		String validEmail = "alek@gmail.com";
		user.setEmail(validEmail);
		assertEquals(validEmail, user.getEmail());
	}
	@Test
	void testEmailDot() {
		String inValidEmail = "alek@gmailco.m";
		user.setEmail(inValidEmail);
		assertEquals(email, user.getEmail());
	}
	@Test
	void testEmailAt() {
		String inValidEmail = "alekgmail.com";
		user.setEmail(inValidEmail);
		assertEquals(email, user.getEmail());
	}
	@Test
	void testEmailTwoAt() {
		String inValidEmail = "alek@@gmail.com";
		user.setEmail(inValidEmail);
		assertEquals(email, user.getEmail());
	}
	@Test
	void testEmailCorectSymbols() {
		String inValidEmail = "ale!k@gmail.com";
		user.setEmail(inValidEmail);
		assertEquals(email, user.getEmail());
	}

}
