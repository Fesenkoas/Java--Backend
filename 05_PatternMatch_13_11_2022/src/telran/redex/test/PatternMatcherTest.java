package telran.redex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

class PatternMatcherTest {

	@Test
	void test() {
		String str = "Don't Trouble trouble, until trouble troubles you";
		String regex = "(T|t)rouble\\w*";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		System.out.println(matcher.matches());
		boolean res = matcher.find();
		System.out.println(res);
		System.out.println(matcher.start());
		System.out.println(matcher.group());
		System.out.println(matcher.end());
		res = matcher.find();
		System.out.println(res);
		System.out.println(matcher.start());
		System.out.println(matcher.group());
		System.out.println(matcher.end());
		System.out.println("=======================");
		matcher.reset();

		while (matcher.find()) {
			System.out.println(matcher.start());
			System.out.println(matcher.group());
			System.out.println(matcher.end());
		}
		System.out.println("=======================");
		str = "All my troubles seemed so far away";
		matcher = pattern.matcher(str);
		matcher.reset(str);
		while (matcher.find()) {
			System.out.println(matcher.start());
			System.out.println(matcher.group());
			System.out.println(matcher.end());
		}
	}
	

}
