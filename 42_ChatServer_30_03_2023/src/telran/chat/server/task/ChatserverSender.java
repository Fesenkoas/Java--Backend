package telran.chat.server.task;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import telran.chat.model.Message;
import telran.mediation.IBlkQueue;

public class ChatserverSender implements Runnable {
	List<OutputStream> clients;
	IBlkQueue<Message> messageBox;

	public ChatserverSender(IBlkQueue<Message> messageBox2) {
		this.messageBox = messageBox2;
		clients = new LinkedList<>();
	}
	public synchronized boolean addClient(Socket socket) throws IOException {
		return clients.add(new ObjectOutputStream(socket.getOutputStream()));
	} 

	@Override
	public void run() {
		while(true) {
			Message message = messageBox.pop();
			Iterator<OutputStream> iterator = clients.iterator();
			synchronized (this) {
				while (iterator.hasNext()) {
					ObjectOutputStream client = (ObjectOutputStream) iterator.next();
					try {
						client.writeObject(message);
					} catch (IOException e) {
						iterator.remove();
					}
				}
			}
		}
	}

}
