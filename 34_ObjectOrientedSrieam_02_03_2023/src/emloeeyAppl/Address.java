package emloeeyAppl;

import java.io.Serializable;

public class Address implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5178810520703038435L;
	String city;
	String street;
	int building;
	int aprt;

	public Address(String city, String street, int building, int aprt) {
		this.city = city;
		this.street = street;
		this.building = building;
		this.aprt = aprt;
	}

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public int getBuilding() {
		return building;
	}

	public int getAprt() {
		return aprt;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", street=" + street + ", building=" + building + ", aprt=" + aprt + "]";
	}

}
