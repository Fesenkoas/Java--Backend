package telran.time.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

/*
 * 1)Current and other date and time
 * 2)plus and minus date time units
 * 3)Compare of date
 * 4)Date Format ISO-8601
 * 5)Zoned date time
 * 6)Period and Duration
 * 7)Customization
 * 
 * Joda time
 */
public class TimeAppl {

	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);
		LocalTime localTime = LocalTime.now();
		System.out.println(localTime);
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);
		LocalDate gagarin = LocalDate.of(1961, 4, 12);
		System.out.println(gagarin);
		System.out.println(gagarin.getDayOfMonth());
		System.out.println(gagarin.getMonthValue());
		System.out.println(gagarin.getMonth());
		System.out.println(gagarin.getDayOfWeek());
		System.out.println(gagarin.getDayOfYear());
		System.out.println(gagarin.isLeapYear());
		System.out.println(localDate.isBefore(gagarin));
		System.out.println(gagarin.isBefore(localDate));
		System.out.println(gagarin.compareTo(localDate));
		LocalDate newDate = localDate.plusDays(100);
		System.out.println(newDate);
		System.out.println(localDate);
		newDate = localDate.plusMonths(9);
		System.out.println(newDate);
		newDate = localDate.plusWeeks(5);
		System.out.println(newDate);
		LocalDateTime newDateTime = localDateTime.plus(9, ChronoUnit.HALF_DAYS);
		System.out.println(newDateTime);
		//System.out.println(ChronoUnit.YEARS.between(gagarin, localDate));
		newDate = LocalDate.of(2022, 4, 11);
		LocalDate newDate1 = LocalDate.now();
		System.out.println(ChronoUnit.YEARS.between(newDate1,gagarin ));
//		System.out.println(ChronoUnit.HOURS.between(gagarin, localDate));
		System.out.println("===== Date Formatter =====");
		DateTimeFormatter df = DateTimeFormatter.BASIC_ISO_DATE;
		String dateStr = gagarin.format(df);
		System.out.println(dateStr);
		df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		dateStr = gagarin.format(df);
		System.out.println(dateStr);
		dateStr = "14/12/2022";
		newDate1 = LocalDate.parse(dateStr, df);
		System.out.println(newDate1);
		System.out.println("===== Adjuster =====");
		newDate1 = localDate.withYear(2024);
		System.out.println(newDate1);
		newDate1 = localDate.withMonth(10);
		System.out.println(newDate1);
		newDate1 = localDate.withDayOfMonth(18);
		System.out.println(newDate1);
		newDate1 = localDate.withDayOfYear(150);
		System.out.println(newDate1);
		newDate1 = localDate.with(ChronoField.DAY_OF_WEEK, 2);
		System.out.println(newDate1);
		newDate1 = localDate.with(TemporalAdjusters.firstDayOfMonth());
		System.out.println(newDate1);
		newDate1 = localDate.with(TemporalAdjusters.firstDayOfNextMonth());
		System.out.println(newDate1);
		newDate1 = localDate.with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.FRIDAY));
		System.out.println(newDate1);
		System.out.println("===== Shalom Israel =====");
		df = DateTimeFormatter.ofPattern("dd/MMMM/yyyy", new Locale("he"));
		dateStr = gagarin.format(df);
		System.out.println(dateStr);
	}

}
