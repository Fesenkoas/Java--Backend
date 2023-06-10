
public class Home_Work {

	public static void main(String[] args) {
//		args = new String[7];
//		args[0] = "long";
//		args[1] = "int";
//		args[2] = "byte";
//		args[3] = "float";
//		args[4] = "double";
//		args[5] = "short";
//		args[6] = "char";

		if (args.length > 0) {
			for (int i = 0; i < args.length; i++) {
				Wrapper(args[i]);
			}
		} else
			EmptyArray();

	}

	public static void Wrapper(String req) {
		switch (req) {
		case "byte":
			System.out.println("Byte");
			System.out.println(Byte.MAX_VALUE);
			System.out.println(Byte.MIN_VALUE);
			break;
		case "short":
			System.out.println("Short");
			System.out.println(Short.MAX_VALUE);
			System.out.println(Short.MIN_VALUE);
			break;
		case "char":
			System.out.println("Char");
			System.out.println((int) Character.MIN_VALUE);
			System.out.println((int) Character.MAX_VALUE);

			break;
		case "int":
			System.out.println("Integer");
			System.out.println(Integer.MAX_VALUE);
			System.out.println(Integer.MIN_VALUE);
			break;
		case "long":
			System.out.println("Long");
			System.out.println(Long.MIN_VALUE);
			System.out.println(Long.MIN_VALUE);
			break;
		case "double":
			System.out.println("Double");
			System.out.println(Double.MAX_VALUE);
			System.out.println(Double.MIN_VALUE);
			break;
		case "float":
			System.out.println("Float");
			System.out.println(Float.MAX_VALUE);
			System.out.println(Float.MIN_VALUE);
			break;
		default:
			System.out.println("Type " + req + " Wrong");
		}
	}

	public static void EmptyArray() {

		System.out.println("Byte");
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.MIN_VALUE);

		System.out.println("Short");
		System.out.println(Short.MAX_VALUE);
		System.out.println(Short.MIN_VALUE);

		System.out.println("Char");
		System.out.println((int) Character.MIN_VALUE);
		System.out.println((int) Character.MAX_VALUE);

		System.out.println("Integer");
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);

		System.out.println("Long");
		System.out.println(Long.MIN_VALUE);
		System.out.println(Long.MIN_VALUE);

		System.out.println("Double");
		System.out.println(Double.MAX_VALUE);
		System.out.println(Double.MIN_VALUE);

		System.out.println("Float");
		System.out.println(Float.MAX_VALUE);
		System.out.println(Float.MIN_VALUE);

	}
}
