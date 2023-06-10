package telran.enums.model;

public enum MathConst {
PI(3.14), EXP(2.718281828), G(6.67E-11);
	private double value;

	private MathConst(double value) {
		this.value = value;
	}

	public double getValue() {
		return value;
	}
	
	
}
