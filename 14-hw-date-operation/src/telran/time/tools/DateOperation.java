package telran.time.tools;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;

public class DateOperation {

	public static int getAge(String birthDate) {
		LocalDate newDate = LocalDate.now();
		return (int) ChronoUnit.YEARS.between(getParsDate(birthDate), newDate);
	}

	public static String[] sortStringDate(String[] dates) {
		Comparator<String> comp = (d1, d2) -> {
			LocalDate data1 = getParsDate(d1);
			LocalDate data2 = getParsDate(d2);
			return data1.compareTo(data2);
		};
		Arrays.sort(dates, comp);
		return dates;
	}
public static LocalDate getParsDate(String date) {
	DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	return date.contains("/") ? LocalDate.parse(date, df) : LocalDate.parse(date);
}
}
