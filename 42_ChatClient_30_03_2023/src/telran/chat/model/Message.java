package telran.chat.model;

import java.io.Serializable;
import java.time.LocalTime;

public class Message implements Serializable {
	private static final long serialVersionUID = 1L;
	String nickName;
	LocalTime time;
	String message;

	public Message(String nickName, String message) {

		this.nickName = nickName;
		this.message = message;
		this.time = LocalTime.now();

	}

	public String getMessage() {
		return message;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getNickName() {
		return nickName;
	}

	public LocalTime getTime() {
		return time;
	}

	@Override
	public String toString() {

		return "Name: " + nickName + "\n" + "time: " + time + "\n" + "message: " + message;
	}

}
