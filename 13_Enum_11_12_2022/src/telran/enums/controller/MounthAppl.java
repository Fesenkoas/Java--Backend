package telran.enums.controller;

import telran.enums.model.Mouth;

public class MounthAppl {

	public static void main(String[] args) {
		Mouth mouth = Mouth.APR;
		System.out.println(mouth.plusMounth(4));
		System.out.println(Mouth.getName(5));
//		mouth = Mouth.valueOf("SEP");
//		System.out.println(mouth);

	}

}
