package telran.enums.controller;

import telran.enums.model.MathConst;
import telran.enums.model.Season;

public class EnumAppl {
	
	public static void main(String[] args) {
		Season season = Season.AUTUMN;
		
		MathConst matconst = MathConst.EXP;
		System.out.println(matconst);
		System.out.println(matconst.getValue());
	}

}
