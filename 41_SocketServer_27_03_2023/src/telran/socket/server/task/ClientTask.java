package telran.socket.server.task;


import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.time.LocalTime;

public class ClientTask implements Runnable {
	Socket socket;

	public ClientTask(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try (Socket socket = this.socket) {
			InputStream inputStream = socket.getInputStream();
			OutputStream outputStream = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(outputStream);
			ObjectInputStream ois = new ObjectInputStream(inputStream);
			while (true) {
				String message = ois.readObject().toString();
				System.out.println("Server received: " + socket.getPort() + "-" + message);
				oos.writeObject(message + " " + LocalTime.now());
			}
		} catch (IOException e) {
			System.out.println("Connection host:" + socket.getInetAddress() + ":" + socket.getPort() + " closed");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
