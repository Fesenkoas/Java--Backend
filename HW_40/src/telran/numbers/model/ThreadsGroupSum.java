package telran.numbers.model;

import java.util.Arrays;

import telran.numbers.task.OneGroupSum;

public class ThreadsGroupSum extends NumberSum {

	public ThreadsGroupSum(int[][] numbersGroup) {
		super(numbersGroup);
	}

	@Override
	public int computeSum() {
		OneGroupSum[] task = new OneGroupSum[numbersGroup.length];

		for (int i = 0; i < numbersGroup.length; i++) {
			task[i] = new OneGroupSum(numbersGroup[i]);
		}
		
		Thread[] thread = new Thread[task.length];
		
		for (int j = 0; j < thread.length; j++) {
			thread[j] = new Thread(task[j]);
			thread[j].start();
		}
		for (int i = 0;  i< thread.length; i++) {
			try {
				thread[i].join();
			} catch (InterruptedException e) {
				System.out.println("Error in Thread");
			}
		}
		return Arrays.stream(task).mapToInt(OneGroupSum::getSum).sum();
	}

}


//public class MessagePassingExample {
//    private String message;
//    private boolean messageAvailable;
//
//    public synchronized void putMessage(String message) {
//        while (messageAvailable) {
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        this.message = message;
//        messageAvailable = true;
//        notifyAll();
//    }
//
//    public synchronized String getMessage() {
//        while (!messageAvailable) {
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        String message = this.message;
//        messageAvailable = false;
//        notifyAll();
//        return message;
//    }
//
//    public static void main(String[] args) {
//        MessagePassingExample example = new MessagePassingExample();
//
//        Thread senderThread = new Thread(() -> {
//            example.putMessage("Hello");
//            example.putMessage("World");
//            example.putMessage("!");
//        });
//
//        Thread receiverThread = new Thread(() -> {
//            while (true) {
//                String message = example.getMessage();
//                System.out.println(message);
//            }
//        });
//
//        senderThread.start();
//        receiverThread.start();
//    }
//}