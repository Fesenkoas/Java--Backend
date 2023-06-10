package telran.list.controler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListPerfomenceTest {

	private static final int N_NUMBER = 100000;
	private static final int MIN = 10;
	private static final int MAX = 100;
	private static Random random = new Random();

	public static void main(String[] args) {
		List<Integer> list = new LinkedList<>();
		fillist(list);
		// test 1
		System.out.println("ForEch");
		long t1 = System.currentTimeMillis();
		int sum = 0;
		for (Integer integer : list) {
			sum += integer;
		}
		long t2 = System.currentTimeMillis();
		System.out.println("sum=" + sum);
		System.out.println("time=" + (t2 - t1));
		// test 2
		System.out.println("Iterator");
		t1 = System.currentTimeMillis();
		sum = 0;
		Iterator<Integer> iter = list.iterator();
		while (iter.hasNext()) {
			sum += iter.next();
		}
		t2 = System.currentTimeMillis();
		System.out.println("sum=" + sum);
		System.out.println("time=" + (t2 - t1));
		// test 3
		System.out.println("For");
		t1 = System.currentTimeMillis();
		sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum+=list.get(i);
		}
		t2 = System.currentTimeMillis();
		System.out.println("sum=" + sum);
		System.out.println("time=" + (t2 - t1));
//		printList(list);
//		System.out.println("=======================");
//		System.out.println(list.size());

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
