package telran.solder.model;

public class Solder implements Comparable<Solder>{
	String name;
	int height;
	double weight;
	int profile;
	
	public Solder(String name, int height, double weight, int profile) {
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.profile = profile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public int getProfile() {
		return profile;
	}
	public void setProfile(int profile) {
		this.profile = profile;
	}
	@Override
	public String toString() {
		return "Solder [name=" + name + ", height=" + height + ", weight=" + weight + ", profile=" + profile + "]";
	}
	
	@Override
	public int compareTo(Solder o) {
		
		return height - o.height;
	}
	
}
