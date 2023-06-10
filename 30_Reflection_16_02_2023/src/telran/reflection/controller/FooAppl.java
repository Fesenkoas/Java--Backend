package telran.reflection.controller;

import java.lang.reflect.Method;
import java.net.ProtocolException;
import java.util.Arrays;

import telran.reflection.model.Foo;

public class FooAppl {

	public static void main(String[] args) {
		if(args.length!=2) {
			System.out.println("Wrong number");
			return;
		}
		//Foo foo = new Foo();
//		foo.caller(args[0], args[1]);
	//	Class <Foo> clazz = Foo.class;
		//caller(args[0], args[1], Foo.class);
        displayInfo(new Foo());
	}

	public static void displayInfo(Object obj) {
		Class<?> clazz = obj.getClass();
		System.out.println("Protocol: ");
		Method[] protocol = clazz.getMethods();
		Arrays.stream(protocol).forEach(p -> System.out.println(p.getName()));

		System.out.println("=====================================================");
		System.out.println("Contract: ");
		Method[] contract = clazz.getDeclaredMethods();
		Arrays.stream(contract).forEach(p -> System.out.println(p.getName()));

	}

	public static void caller(String functionName, String arg, Class<?> clazz) {
		// Class <Foo> clazz = Foo.class;
		try {
			Method method = clazz.getDeclaredMethod(functionName, String.class);
			method.setAccessible(true);
			method.invoke(clazz.getDeclaredConstructor().newInstance(), arg);// constructor default
		} catch (Exception e) {
			System.out.println(functionName + " doest't exsist");
		}
	}
}
