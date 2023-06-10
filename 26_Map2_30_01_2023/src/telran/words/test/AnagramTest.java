package telran.words.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static telran.words.utils.Anagram.*;

import java.util.function.BooleanSupplier;
class AnagramTest {
	final String word = "electricity";

	@Test
	void testIsAnagram() {
		assertTrue(isAnagram(word,"city"));
		assertTrue(isAnagram(word,"tic"));
		assertTrue(isAnagram(word,"City"));
		assertTrue(isAnagram(word,"rele"));
		assertTrue(isAnagram(word,"tele"));
		
	}
	

	@Test
	void testIsNotAnagram() {
		assertFalse(isAnagram(word,"tell"));
		assertFalse(isAnagram(word,"select"));
		assertFalse(isAnagram(word,"collect"));
		assertFalse(isAnagram(word,""));
		assertFalse(isAnagram(word,null));
		assertFalse(isAnagram(word,"reter"));
	}

}
