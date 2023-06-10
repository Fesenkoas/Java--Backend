package controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import emloeeyAppl.Address;
import emloeeyAppl.Emploeey;

public class SaveEmploeey {

	public static void main(String[] args) {
		Address address = new Address("Rehovot", "Plaut", 10, 4);
		Emploeey empl1 = new Emploeey(1000, "John", LocalDate.of(1990, 5, 12), 10000, address);
		Emploeey empl2 = new Emploeey(2000, "Peter", LocalDate.of(1990, 5, 12), 110000, address);
		List<Emploeey> emploeeys = new ArrayList<>();
		emploeeys.add(empl1);
		emploeeys.add(empl2);
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data"))) {
			out.writeObject(emploeeys);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
