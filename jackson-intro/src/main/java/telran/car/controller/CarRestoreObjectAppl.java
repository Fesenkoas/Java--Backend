package telran.car.controller;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import telran.car.dto.Car;

public class CarRestoreObjectAppl {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Car car = mapper.readValue(new File("renaul.json"), Car.class);
		System.out.println(car);

	}

}
