package fesenko.control;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import fesenko.model.Calculator;

public class CalculatorAppl {

	public static void main(String[] args) {
		//String[] args= {"11","*","12"};
		// только что бы работал знак умножение почему то надо ставить галочку в аргументах (use @agrFile when launching)
		System.out.println(args[1]);
		Map<String, String> simbol = new HashMap<>();
		simbol.put("-", "subtract");
		simbol.put("+", "add");
		simbol.put("*", "multiplication");
		
		Class<Calculator> clazzCalculator = Calculator.class;
		caller(simbol.get(args[1]),args[0],args[2],clazzCalculator);
	}

	public static void caller(String functionName,String num, String num1, Class<?> clazz) {
		try {
			Method method = clazz.getDeclaredMethod(functionName, num.getClass(), num1.getClass());
			method.setAccessible(true);
			method.invoke(clazz.getDeclaredConstructor().newInstance(), num, num1);
		} catch (Exception e) {
			System.out.println(functionName + " doest't exsist");
		}
	}
}
