package telran.wrapper.controller;

public class WrapperClassesAppl {

	public static void main(String[] args) {
		int x = 10;
		Integer y = 20;
		System.out.println(x);
		System.out.println(y);
		y = y + x;
		System.out.println(y);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.MIN_VALUE);
		String str1 = y.toString();
		System.out.println(str1);
		String str2 = Integer.toString(100500);
		System.out.println(str2);
		str1 = "42";
		x = Integer.parseInt(str1);
		x = x * 10;
		System.out.println(x);
		str2 = "3.1415926"; 
		double pi = Double.parseDouble(str2);
		double len = 2 * pi * 10;
		System.out.println(len);
		Boolean check = true;
		str1 = "TrUe";
		check = Boolean.parseBoolean(str1);
		System.out.println(check);
		double a = 0. / 0;
		if (Double.isFinite(a)) {
			System.out.println(a);
		} else {
			System.out.println("Wrong result");
		}
	}

}
