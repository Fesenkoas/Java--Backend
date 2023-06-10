package telran.builder.controler;

public class StringBuilderAppl {

	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder("Java");
		builder.append("_").append("11");
		String str = builder.toString();
		System.out.println(builder);
		System.out.println(builder.reverse());
		str=stringManipulation("mama ");
		System.out.println(str);
		
	}
private static String stringManipulation(String str) {
	StringBuilder builder = new StringBuilder(str);
	builder.append("myla ").append("ramu");
	return builder.toString();
}
}
