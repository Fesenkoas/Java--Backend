package telran.reflection.controller;

public class ReflectionAppl {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		Class<String> clazzStr1 = String.class;
		Class<StringBuilder> clazzBuilder1 = StringBuilder.class;
		String str = "";
		Class<? extends String> clazzStr2 = str.getClass();
		Class<?> clazzStr3 = Class.forName("java.lang.String");
		System.out.println(clazzStr1 ==  clazzStr2);
		System.out.println(clazzStr3 ==  clazzStr2);
		String str1 = clazzStr1.newInstance();
		String str2 = (String) clazzStr3.newInstance();
		Class<?> clazzInt = int.class;
		Class<?> clazz = void.class;
		
		
	}

}
