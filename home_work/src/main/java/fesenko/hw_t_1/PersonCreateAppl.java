package fesenko.hw_t_1;

import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fesenko.hw_t_1.model.Address;
import fesenko.hw_t_1.model.Person;

public class PersonCreateAppl {

	public static void main(String[] args) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.findAndRegisterModules();
		Person person = new Person(3000,"Alex",LocalDate.of(1990, 10, 22),new Address("rehoivot","plaut",10,4));
		
		String personJsonString = mapper.writeValueAsString(person);
		System.out.println(personJsonString);

	}

}
