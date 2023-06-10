package telran.eception.controler;

import java.util.Random;

import telran.eception.utils.AnySolutionExceprtion;
import telran.eception.utils.NoSolutionEception;

public class Eception_APP {

	public static void main(String[] args) {
		int a = 3;
		int b = 12;
		try {
			int x = solution(a, b);
			System.out.println(x);

		} catch (NoSolutionEception e) {
			System.out.println(e.getMessage());
			System.out.println(Integer.MAX_VALUE);
			return;
		} catch (AnySolutionExceprtion e) {
			System.out.println(e.getMessage());
			System.out.println(new Random().nextInt());
			return;
		} finally {
			System.out.println("bye-bye");
		}

	}

	public static int solution(int a, int b) throws AnySolutionExceprtion,NoSolutionEception {

		if (a != 0)
			return b / a;
		if (b != 0)
			throw new NoSolutionEception();

		throw new AnySolutionExceprtion();

	}
}
