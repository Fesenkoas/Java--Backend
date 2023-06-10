package telran.string.controller;

public class StringAppl {

	public static void main(String[] args) {
		String str = "Hello";
		char[] chars = { ' ', 'w', 'o', 'r', 'l', 'd' };
		String str1 = new String(chars);
		System.out.println(str);
		System.out.println(str1);
		str = str + str1;// str.concat(str1);
		System.out.println(str);
		System.out.println(str.length());
		char c = str.charAt(2);
		System.out.println(c);
		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
		}
		String str2 = "Hello";
		String str3 = new String("HELLO");
		System.out.println(str2.equals(str3));
		System.out.println(str2.equalsIgnoreCase(str3));
		String str4 = str.toUpperCase();
		System.out.println(str4);
		System.out.println(str);
		int index = str.indexOf("lo", 5);
		System.out.println(index);
		index = str.lastIndexOf('l');
		System.out.println(index);
		str4 = str.substring(2, 4);
		System.out.println(str4);
		str4 = str.replace('l', 'L');
		System.out.println(str4);
		str4 = str.replace(Character.toString('l'), "000");
		System.out.println(str4);
	}

}
