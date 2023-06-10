package telran.chat.client.controller;

import java.io.IOException;
import java.net.Socket;

import telran.chat.client.task.Receiver;
import telran.chat.client.task.Sender;

public class ChatClientAppl {

	public static void main(String[] args) throws IOException {
		String serverHost = "127.0.0.1";
		int port = 9000;
//		String serverHost = "7.tcp.eu.ngrok.io";
//		int port = 14442;
		Socket socket = new Socket(serverHost, port);
		try {
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			Thread senderThread = new Thread(sender);
			Thread receiverThread = new Thread(receiver);
			receiverThread.setDaemon(true);
			receiverThread.start();
			senderThread.start();
			//senderThread.join();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
