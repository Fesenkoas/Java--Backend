package telran.chat.server.controller;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import telran.chat.model.Message;
import telran.chat.server.task.ChatServerReceiver;
import telran.chat.server.task.ChatserverSender;
import telran.mediation.BlkQueue;
import telran.mediation.IBlkQueue;

public class ChatServerAppl {

	public static void main(String[] args) throws IOException {
		int port = 9000;
		//ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		//Message user = new Message(nickName);
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		IBlkQueue<Message> messageBox = new BlkQueue<>(10);
		ChatserverSender sender = new ChatserverSender(messageBox);
		Thread sendTread = new Thread(sender);
		sendTread.setDaemon(true);
		sendTread.start();
		
		try (ServerSocket serverSocket = new ServerSocket(port);) {
			try {
				while (true) {
					System.out.println("Server wait....");
					Socket socket = serverSocket.accept();
					System.out.println("Connection estabished");
					System.out.println("Client host:" + socket.getInetAddress() + ":" + socket.getPort());
					sender.addClient(socket);
					ChatServerReceiver receiver = new ChatServerReceiver(socket, messageBox);
					executorService.execute(receiver);
				}
			} finally {
				executorService.shutdown();
				executorService.awaitTermination(1, TimeUnit.MINUTES);
			}

		} catch (Exception e) {
			System.out.println("Connection closed");
		}

	}

}
