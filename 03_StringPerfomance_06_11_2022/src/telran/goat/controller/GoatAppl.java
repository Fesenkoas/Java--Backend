package telran.goat.controller;

import telran.goat.model.Goat;

public class GoatAppl {

	public static void main(String[] args) {
		Goat goatling1 = new Goat();
		Goat goatling2 = new Goat();
		
		for(int i=0; i<10;i++) {
			goatling1.count++;
		}
		System.out.println(goatling1.count);
		for(int i=0; i<10;i++) {
			goatling2.count++;
		}
		System.out.println(goatling2.count);
	}

}
