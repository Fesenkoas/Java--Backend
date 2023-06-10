package telran.validator.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static telran.validator.utils.Validator.*;

class ValidatorTest {

	@Test
	void testCheckCreditCardNumber() {
		assertTrue(checkCreditCardNumber("12345678"));
		assertTrue(checkCreditCardNumber("123456789"));
		assertTrue(checkCreditCardNumber("1234567890123456"));
		assertFalse(checkCreditCardNumber("1234567"));
		assertFalse(checkCreditCardNumber("12345678901234567"));
		assertFalse(checkCreditCardNumber("1234567A"));
	}

	@Test
	void testCheckDateFormatEU() {
		assertTrue(checkDateFormatEU("22.10.2022"));
		assertTrue(checkDateFormatEU("22.11.0002"));
		assertTrue(checkDateFormatEU("01.01.0002"));
		assertFalse(checkDateFormatEU("456.166,2022"));
		assertFalse(checkDateFormatEU("12.16,20226"));
		assertFalse(checkDateFormatEU("11.10.12"));
		assertFalse(checkDateFormatEU("01.1.12"));
	}


	@Test
	void testCheckDateFormatUS() {
		assertTrue(checkDateFormatUS("2022-11-10"));
		assertFalse(checkDateFormatUS("12-10-01"));
	}

	@Test
	void testCheckPhoneNumber() {
		assertTrue(checkPhoneNumber("+22(22)2222-2222"));
		assertFalse(checkPhoneNumber("-22 22 2222 2222"));
		assertFalse(checkPhoneNumber("22 22 2222 2222"));
		assertFalse(checkPhoneNumber("223 223 22223 22223"));
	}

	@Test
	void testCheckLessEquals255() {
		assertTrue(checkLessEquals255("255"));
		assertTrue(checkLessEquals255("155"));
		assertTrue(checkLessEquals255("55"));
		assertTrue(checkLessEquals255("1"));
		assertFalse(checkLessEquals255("256"));
		assertFalse(checkLessEquals255("999"));
		assertFalse(checkLessEquals255("0"));
		
	}

}
