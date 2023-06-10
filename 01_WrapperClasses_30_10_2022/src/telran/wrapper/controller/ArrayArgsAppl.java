package telran.wrapper.controller;

public class ArrayArgsAppl {

	public static void main(String[] args) {
//		System.out.println(args.length);
//		for (int i = 0; i < args.length; i++) {
//			System.out.println(args[i]);
//		}
		if (args.length != 3) {
			System.out.println("Wrong number of arguments");
			return;
		}
		double a = Double.parseDouble(args[0]);
		double b = Double.parseDouble(args[1]);
		double res = calculator(a , b, args[2]);
		System.out.println("Result = " + res);
	}

	public static double calculator(double a, double b, String oper) {
		switch (oper) {
		case "add":
			return a + b;
		case "sub":
			return a - b;
		case "mul":
			return a * b;
		case "div":
			return a / b;
		default:
			return Double.NaN;
		}
	}

}
