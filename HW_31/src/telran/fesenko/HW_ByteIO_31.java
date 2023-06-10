package telran.fesenko;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class HW_ByteIO_31 {

	public static void main(String[] args) {

		try{
			FileInputStream fileOne = new FileInputStream("./file/test.dat");
			FileInputStream fileTwo = new FileInputStream("./file/test2.dat");
			System.out.println("view files the same and same size");
			view(fileOne,fileTwo);
			System.out.println("====================================");
			
			fileOne = new FileInputStream("./file/test2.dat");
			fileTwo = new FileInputStream("./file/test3.dat");
			System.out.println("view files not the same and not the same size");
			view(fileOne,fileTwo);
			System.out.println("====================================");
			
			fileOne = new FileInputStream("./file/test4.dat");
			fileTwo = new FileInputStream("./file/test2.dat");
			System.out.println("view files not the same and the same size");
			view(fileOne,fileTwo);
			System.out.println("====================================");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void view(FileInputStream fileOne, FileInputStream fileTwo) {
		try {
		int a = fileOne.read();
		int b = fileTwo.read();

		if (fileOne.available() == fileTwo.available()) {
			System.out.println("the same size");
		} else
			System.out.println("not the same size");
		
		while (a != -1 || b != -1) {
			
			if (a != b) {
				System.out.println("files are not the same");
				return;
			}
			a = fileOne.read();
			b = fileTwo.read();
		}
		System.out.println("files are the same");

		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
