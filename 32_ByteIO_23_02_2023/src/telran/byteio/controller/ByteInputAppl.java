package telran.byteio.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ByteInputAppl {

	public static void main(String[] args) {
		try (FileInputStream fin = new FileInputStream("./out/test.dat");) {
			
			System.out.println("Avalabel= " + fin.available());
			int a = fin.read();
			System.out.println(a);
			System.out.println("Avalabel= " + fin.available());
			a = fin.read();
			System.out.println(a);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
