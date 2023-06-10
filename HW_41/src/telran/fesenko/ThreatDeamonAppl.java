package telran.fesenko;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import telran.fesenko.task.Receiver;
import telran.fesenko.task.Sender;

public class ThreatDeamonAppl {

	public static void main(String[] args) throws UnknownHostException, IOException {
		String serverHost = "127.0.0.1";
		int port = 9000;
		Socket socket = new Socket(serverHost, port);
		Sender obj = new Sender(socket);
		obj.start();
		
		

	}


}
