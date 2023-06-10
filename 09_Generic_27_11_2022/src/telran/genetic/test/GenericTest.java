package telran.genetic.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.genetic.model.JsonWraooer2;
import telran.genetic.model.JsonWrapper1;

class GenericTest {

	@Test
	void testJsonWrapper1() {
		System.out.println("======= Test 1 ========");
		JsonWrapper1 wrapper = new JsonWrapper1(10);
		System.out.println(wrapper);
		String value = (String) wrapper.getValue();
		System.out.println(value);
		System.out.println("=======================");
		
	}
	
	@Test
	void testJsonWrapper2() {
		System.out.println("======= Test 2 ========");
		JsonWraooer2<Integer> wrapper = new JsonWraooer2<>(10);
		System.out.println(wrapper);
		Integer value = (Integer) wrapper.getValue();
		System.out.println(value);
		System.out.println("=======================");
		
	}

}
