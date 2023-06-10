package fesenko.controler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import fesenko.model.Box;
import fesenko.model.Pomegranate;
import fesenko.model.Seed;

public class PomegranateAppl {

	public static void main(String[] args) {
		Random random = new Random();
		int countBox = random.nextInt(100) + 100;
		List<Box> boxes = new ArrayList<>();
		for (int i = 0; i < countBox; i++) {
			Box box = new Box("Box" + i);
			int countPomeg = random.nextInt(10) + 10;
			
			for (int j = 0; j < countPomeg; j++) {
				Pomegranate pomeg = new Pomegranate();
				int countSeed = random.nextInt(300) + 400;
				
				for (int k = 0; k < countSeed; k++) {
					pomeg.addSeed(new Seed());
				}
				box.addPomegranate(pomeg);
			}
			boxes.add(box);
		}
		
		
		int totalSeed = boxes.stream()
				.mapToInt(b -> (int) b.granates.stream().flatMap(p -> p.seeds.stream()).count())
				.sum();
		
		int maxSeed = boxes.stream()
		        .mapToInt(b -> (int) b.granates.stream().flatMap(p -> p.seeds.stream()).count())
		        .max()
		        .getAsInt();
		
		List<String> boxName = boxes.stream()
		        .filter(b -> b.granates.stream().flatMap(p -> p.seeds.stream()).count() == maxSeed)
		        .map(b -> b.name)
		        .collect(Collectors.toList());

		    System.out.println("Total seeds: " + totalSeed);
		    System.out.println("Max seeds in one box: " + maxSeed);
		    System.out.println("Box names with maximum seeds: " + boxName);

	}

}
