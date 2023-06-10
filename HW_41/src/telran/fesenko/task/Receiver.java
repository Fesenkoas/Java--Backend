package telran.fesenko.task;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Receiver extends Thread {
	Socket socket;

	public Receiver(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

		try {

			InputStream inputStream = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(inputStream);

			while (true) {
				String responce = ois.readObject().toString();
				System.out.println(responce);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
