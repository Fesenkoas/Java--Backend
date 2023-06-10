package telran.collections.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsAppl {

  public static void main(String ... args) {
//    List<String > list = new ArrayList<>();
//    list.add("HTML");
//    list.add("CSS");
//    list.add("JavaScript");
//    list.add("React");
//    list.add("Redux");
//    list.add("RTK");
//    list.add("TypeScript");
//    list.add("Java");
    String[] arr  = {"HTML","CSS","JavaScript","React","Redux","RTK","TypeScript","Java"};
  List<String>list = Arrays.asList("HTML","CSS","JavaScript","React","Redux","RTK","TypeScript","Java");
//    List<String> list = new ArrayList<>(Arrays.asList(arr));
//  List<String> list = List.of(arr);
//    list.add("Bootsrtap");
//    list.set(l, "Bootstrap");
    list.forEach(t ->System.out.println(t));
    int res = sum(2, 3, 5, 7, 11);
    System.out.println("res = " + res);
    System.out.println("=====  Collections ==============");
    Collections.sort(list);
    list.forEach(t ->System.out.println(t));
    int index = Collections.binarySearch(list, "React");
    System.out.println("index = " + index);
    System.out.println("====== Collections sort by Comparator ==========");
    Collections.sort(list, (s1 , s2) -> s1.length() - s2.length());
    list.forEach(t ->System.out.println(t));
  }
    public static int sum(int a, int b, int... arr) {
      int res = a + b;
      for (int i = 0; i < arr.length; i++) {
        res += arr[i];
      }
      return res;
    }
  }