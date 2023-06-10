package telran.chat.server.task;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import telran.chat.model.Message;
import telran.mediation.IBlkQueue;

public class ChatServerReceiver implements Runnable {
	Socket socket;
	IBlkQueue<Message> messageBox;
	 
	
	public ChatServerReceiver(Socket socket, IBlkQueue<Message> messageBox2) {
		this.socket = socket;
		this.messageBox = messageBox2;
	}



	@Override
	public void run() {
		try (Socket socket = this.socket) {
			
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			while (true) {
				messageBox.push((Message) ois.readObject());
			}
		} catch (IOException e) {
			System.out.println("Connection host:" + socket.getInetAddress() + ":" + socket.getPort() + " closed");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}

	}

}
