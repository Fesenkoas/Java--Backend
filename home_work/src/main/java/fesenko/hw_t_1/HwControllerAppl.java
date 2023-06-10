package fesenko.hw_t_1;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fesenko.hw_t_1.model.Person;

public class HwControllerAppl {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
//		mapper.registerModule(new JavaTimeModule());
		mapper.findAndRegisterModules();
		Person person = mapper.readValue(new File("person.json"), Person.class);
		System.out.println(person);
		System.out.println("--------------------------------------------------------------");
		
//		Person[] person1 = mapper.readValue(new File("persons_for_advanced.json"), Person[].class);
//		for (Person person2 : person1) {
//			System.out.println(person2);
//		}
		
		HashSet<Person> person3= mapper.readValue(new File("persons_for_advanced.json"), new TypeReference<HashSet<Person>>(){});
		person3.forEach(System.out::println);
		

	}

}
