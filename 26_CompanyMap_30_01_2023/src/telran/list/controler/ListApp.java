package telran.list.controler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class ListApp {

	private static final int N_NUMBER = 10;
	private static final int MIN = 10;
	private static final int MAX = 20;
	private static Random random = new Random();

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		fillist(list);
		printList(list);
		System.out.println("=======================");
		System.out.println(list.size());
//		list.clear();
//		System.out.println(list.size());
//		printList(list);
//		System.out.println(list.indexOf(15));
//		System.out.println(list.lastIndexOf(15));
//		list.set(0, 100500);
//		printList(list);
//      NB!! Wrong way!
//		for (Integer intenger: list) {
//			if(intenger ==15)list.remove((Integer)15);
//		}
//		
//		Iterator<Integer> iter = list.iterator();
//		while (iter.hasNext()) {
//			Integer num = iter.next();
//			if (num == 15)
//				iter.remove();
//		}
		list.removeIf(x -> x == 15);
		printList(list);

	}

	private static void printList(List<Integer> list) {
		System.out.println(list.toString());

	}

	private static void fillist(List<Integer> list) {
		for (int i = 0; i < N_NUMBER; i++) {
			list.add(MIN + random.nextInt(MAX - MIN));
		}

	}

}
