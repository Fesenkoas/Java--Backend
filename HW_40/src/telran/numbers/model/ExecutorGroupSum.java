package telran.numbers.model;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import telran.numbers.task.OneGroupSum;

public class ExecutorGroupSum extends NumberSum {

	public ExecutorGroupSum(int[][] numbersGroup) {
		super(numbersGroup);
	}

	@Override
	public int computeSum() {

		//ExecutorService exeService = Executors.newWorkStealingPool(); // меньше 250 сек небыло, заметил что не всегда заставить всех работать, есть хорошо
		//ExecutorService exeService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()); //одинаковое с первым примером
		
		ExecutorService exeService = Executors.newFixedThreadPool(4);// самое минимальное время.. до 100 сек
		OneGroupSum[] task = new OneGroupSum[numbersGroup.length];

		for (int i = 0; i < numbersGroup.length; i++) {
			task[i] = new OneGroupSum(numbersGroup[i]);
			exeService.execute(task[i]);
		}
		
		exeService.shutdown();
		try {
			exeService.awaitTermination(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			System.out.println("Error in ExecutorService");
		}
		
		return Arrays.stream(task).mapToInt(OneGroupSum::getSum).sum();
	}

}
