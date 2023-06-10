package telran.car.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import telran.car.dto.Car;

public class CarCreateJsonAppl {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
//		Set<String> models = new HashSet<>();
//		models.add("Laguna");
//		models.add("Megane");
//		models.add("Clio");
//		Car car = new Car("renault", 2018, models);
		
		Car car = Car.builder()
				.manufacturer("Renault")
				.year(2018)
				.model("Loguna")
				.model("Megane")
				.model("Clio")
				.build();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("renaul.json"), car);

	}

}
