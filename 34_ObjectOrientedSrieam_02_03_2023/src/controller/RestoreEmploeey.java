package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import emloeeyAppl.Emploeey;

public class RestoreEmploeey {

	public static void main(String[] args) {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("data"))) {
			ArrayList<Emploeey> empl = (ArrayList<Emploeey>) in.readObject();
			empl.forEach(System.out::println);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
