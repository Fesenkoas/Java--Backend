package telran.programmer.model;

import java.util.Arrays;

public class Programmer {
	String name;
	String[] tech;

	public Programmer(String name, String... tech) {
		this.name = name;
		this.tech = tech;
	}

	public String getName() {
		return name;
	}

	public String[] getTech() {
		return tech;
	}

	@Override
	public String toString() {
		return "Programmer [name=" + name + ", tech=" + Arrays.toString(tech) + "]";
	}

}
