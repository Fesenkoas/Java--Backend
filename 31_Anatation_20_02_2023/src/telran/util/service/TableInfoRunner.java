package telran.util.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import telran.util.annotation.Table;
import telran.util.annotation.id;
import telran.util.annotation.index;

public class TableInfoRunner {
	public static void runInfo(Object obj) {
		runInfo(obj.getClass());
	}

	public static void runInfo(Class<?> clazz) {

		Table tableAnn = clazz.getAnnotation(Table.class);
		if (tableAnn == null) {
			System.out.println(clazz.getSimpleName() + "not a table");
			return;
		}
		String tableName = tableAnn.name();
		tableName = "".equals(tableName) ? clazz.getSimpleName() : tableName;
		String idField = null;
		List<String> unIndex = new ArrayList<>();
		List<String> nonUnIndex = new ArrayList<>();

		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			// handle @id
			if (field.isAnnotationPresent(id.class)) {
				if (idField != null) {
					throw new RuntimeException("Id duplicated");
				}
				idField = field.getName();
			}
			// handle @index
			index indexAnn = field.getAnnotation(index.class);
			if (indexAnn != null) {
				if (indexAnn.unique()) {
					unIndex.add(field.getName());
				} else {
					nonUnIndex.add(field.getName());
				}
			}
		}
		if (idField == null) {
			throw new RuntimeException("ID is not defined");

		}
		displayInfo(tableName, idField, unIndex, nonUnIndex);
	}

	private static void displayInfo(String tableName, String idField, List<String> unIndex, List<String> nonUnIndex) {
		System.out.println("Table: " + tableName);
		System.out.println("ID: " + idField);
		System.out.println("\tUnique indexes");
		unIndex.forEach(System.out::println);
		System.out.println("\tNon Unique indexes");
		nonUnIndex.forEach(System.out::println);

	}

}
