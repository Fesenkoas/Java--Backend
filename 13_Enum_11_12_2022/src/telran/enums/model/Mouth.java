package telran.enums.model;

public enum Mouth {
	JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SET, OCT, NOV, DEC;

	public Mouth plusMounth(int mountes) {
		Mouth[] values = values();
		int currentPos = this.ordinal();
		int pos = currentPos + mountes;
		return values[pos % values.length];
	}
	
	public static String getName( int pos) {
		Mouth[] values = values();
		return values[pos-1% values.length].name();
		
	}
}
