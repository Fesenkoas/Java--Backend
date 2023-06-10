package telran.byteio.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteOutputAppl {
	public static void main(String[] args) {
		try (FileOutputStream fout = new FileOutputStream("./out/test.dat");) {

			fout.write(65);
			fout.write(67);
			fout.write(1);
			fout.write(256);
			fout.close();
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
