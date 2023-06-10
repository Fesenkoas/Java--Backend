package telran.chat.client.task;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Receiver implements Runnable {
	Socket socket;

	public Receiver(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try (Socket socket = this.socket) {

			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			while (true) {
				System.out.println(ois.readObject());
			}
		} catch (IOException e) {

		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}

	}

}
