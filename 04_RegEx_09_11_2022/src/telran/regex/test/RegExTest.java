package telran.regex.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RegExTest {

	@Test
	void test() {
		String str = "java";
		String pattern = " *(J|j)ava[1-9]?\\d?";
		boolean check = str.matches(pattern);
		System.out.println(check);
		String domain = "peter_17.il";
		pattern = "\\w+\\.(com|us|il)";
		check = domain.matches(pattern);
		System.out.println(check);
		String email = "peter_parker-2.@gmail.co.il";
		pattern = "((\\w(\\w|\\.|-)*\\w)|\\w)@\\w(\\w|\\.|-)*\\.[a-zA-Z]{2,6}";
		check = email.matches(pattern);
		System.out.println(check);
		String text = "Two beer, or not  two beer!";
		String[] words = text.split("[,.!?;]? +");
		for (int i = 0; i < words.length; i++) {
			System.out.println(words[i]);
		}
	}

}
