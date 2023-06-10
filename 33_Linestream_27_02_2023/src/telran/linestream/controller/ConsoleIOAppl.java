package telran.linestream.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ConsoleIOAppl {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter name file");
		String res = br.readLine();
		PrintWriter pw = new PrintWriter(res);
		
		System.out.println("Please write your text here");
		res = br.readLine();
		
	}

}
