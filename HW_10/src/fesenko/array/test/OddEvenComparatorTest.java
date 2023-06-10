package fesenko.array.test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Comparator;
import org.junit.jupiter.api.Test;

import fesenko.array.model.OddEvenComparator;

class OddEvenComparatorTest {
  
  Integer[] origin = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 3 };

  
  @Test
  void testOddEvenSort() {
    
    Integer[] expected = { 2, 4, 6, 8, 9, 7, 5, 3, 3, 1 };
    
    Comparator<Integer> comp = new OddEvenComparator();
    Arrays.sort(origin, comp);
    System.out.println(Arrays.toString(origin));
    assertArrayEquals(expected, origin);
  }
}