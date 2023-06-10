package telran.messages.controller;

import telran.messages.model.MessageBox;
import telran.messages.model.MessageBoxA;
import telran.messages.model.MessageBoxB;
import telran.messages.model.MessageBoxC;
import telran.messages.task.Receiver;
import telran.messages.task.Sender;

public class MessageBoxAppl {
	private static final int N_MESSAGES = 20;
	private static final int N_RECIEVER = 5;
	private static MessageBox messageBox = new MessageBoxC();

	public static void main(String[] args) throws InterruptedException {
		Sender sender = new Sender(messageBox, N_MESSAGES);
		for (int i = 0; i < N_RECIEVER; i++) {

			new Receiver(messageBox).start();
		}
		Thread.sleep(100);
		sender.start();
	}

}
