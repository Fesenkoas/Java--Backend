package telran.chat.client.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;

import telran.chat.model.Message;

public class Sender implements Runnable {
	Socket socket;

	public Sender(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try (Socket socket = this.socket) {
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter your name");
			String name = br.readLine();
			if(name.equals("")) name = "anonymus";
			System.out.println("Enter your message or type exit for quit");
			String message = br.readLine();
			while (!"exit".equalsIgnoreCase(message)) {
				Message user = new Message(name, message);
				oos.writeObject(user);
				System.out.println("Enter your message or type exit for quit");
				message = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
