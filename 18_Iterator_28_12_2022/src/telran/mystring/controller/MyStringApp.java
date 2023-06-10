
package telran.mystring.controller;

import java.util.Iterator;

import telran.mystring.model.MyString;

public class MyStringApp {

	public static void main(String[] args) {
		MyString myStr = new MyString("Two beer, or not two beer");
		System.out.println(myStr);
		
		Iterator<Character> iterator = myStr.iterator();
		while(iterator.hasNext()) {
			char c = iterator.next();
			if(c == 'r') {
				iterator.remove();
			}
		}
		
//		Wrong way!!!		
//		for (char c : myStr) {
//			if(c == 'e') {
//				myStr.removeChar(c);
//			}
//		}
		System.out.println(myStr);
		
//		for(Character c: myStr) {
//			System.out.println(Character.toUpperCase(c));
//		}

//		Iterator<Character> iterator = myStr.iterator();
//		while(iterator.hasNext()) {
//			char c = iterator.next();
//			System.out.println(Character.toUpperCase(c));
//		}
		
		
//		myStr.addChar('!');
//		System.out.println(myStr);
//		myStr.removeChar('e');
//		System.out.println(myStr);
//		StringBuilder builder = myStr.getStr();
//		for(int i = 0; i < builder.length(); i++) {
//			System.out.println(Character.toUpperCase(builder.charAt(i)));
//		}
//		builder.setLength(3);
//		System.out.println(builder);
//		System.out.println(myStr);
	}

}
