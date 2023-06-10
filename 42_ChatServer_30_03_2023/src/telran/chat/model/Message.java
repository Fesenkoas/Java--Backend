package telran.chat.model;

import java.io.Serializable;
import java.time.LocalTime;

public class Message implements Serializable {
	private static final long serialVersionUID = 1L;
	String nickName;
	LocalTime time;
	String message;

	public Message(String nickName) {
		if (nickName == null)
			this.nickName = "anonymus";
		this.nickName = nickName;

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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

		return "Message [nickName=" + nickName + ", time=" + time + ", message=" + message + "]";
	}

}
