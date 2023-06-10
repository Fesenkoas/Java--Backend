package telran.fesenko.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Sender extends Thread  {
	private final Socket socket;

    public Sender(Socket socket) {
        this.socket = socket;
        setDaemon(true); // помечаем поток как демон
    }

    @Override
    public void run() {
    	System.out.println("Start");
        try (ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {
        	System.out.println("Start1");
            while (true) {
                String message = ois.readObject().toString();
                System.out.println("Server received: " + socket.getPort() + "-" + message);
            }
        } catch (IOException e) {
            System.out.println("Connection host:" + socket.getInetAddress() + ":" + socket.getPort() + " closed");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
