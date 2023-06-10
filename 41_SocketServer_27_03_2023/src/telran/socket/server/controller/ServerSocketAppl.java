package telran.socket.server.controller;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import telran.socket.server.task.ClientTask;

public class ServerSocketAppl {

	public static void main(String[] args) throws IOException {
		int port = 9000;
		//ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		try (ServerSocket serverSocket = new ServerSocket(port);) {
			try {
				while (true) {
					System.out.println("Server wait....");
					Socket socket = serverSocket.accept();
					System.out.println("Connection +");
					System.out.println("Client host:" + socket.getInetAddress() + ":" + socket.getPort());
					ClientTask task = new ClientTask(socket);
					executorService.execute(task);
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
