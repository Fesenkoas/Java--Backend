package telran.car.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Car {

	String manufacturer;
	int year;
	@Singular
	Set<String> models;

//	public Car(String manufacturer, int year, Set<String> models) {
//		this.manufacturer = manufacturer;
//		this.year = year;
//		this.models = models;
//	}

//	public String getManufacturer() {
//		return manufacturer;
//	}
//
//	public int getYear() {
//		return year;
//	}
//
//	public Set<String> getModels() {
//		return models;
//	}

}
