package telran.datesort.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DateSortTest {
	Comparator<String> comparator;

	@BeforeEach
	void setUp() throws Exception {
		//TODO Homeowrk
		comparator = (s1,s2) -> {
	        String[] str1 = s1.split("-");
	        String[] str2 = s2.split("-");
	        
	        int day = str1[0].compareTo(str2[0]);
	        int mount = str1[1].compareTo(str2[1]);
	        int year = str1[2].compareTo(str2[2]);
	       
	        if(mount == 0 && year == 0)return day;
	        if(year == 0 )return mount-day;
	        return year-mount-day;
			
			};
	}

	@Test
	void dateSortTest() {
		
		String[] dates = {
			"07-05-1990",
			"28-01-2010",
			"11-08-1990",
			"15-01-2010",
			"16-06-1970"
		};
		String[] expected = {
			"16-06-1970",
			"07-05-1990",
			"11-08-1990",
			"15-01-2010",
			"28-01-2010"
		};
	
		Arrays.sort(dates, comparator);
		System.out.println(Arrays.toString(dates));
		assertArrayEquals(expected, dates);
	}




}
