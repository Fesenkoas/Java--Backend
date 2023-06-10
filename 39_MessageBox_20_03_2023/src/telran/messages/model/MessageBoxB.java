package telran.messages.model;

public class MessageBoxB implements MessageBox {

	String message;
	@Override
	public synchronized void post(String message) {
		while(this.message!=null) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.message = message;
		this.notify();

	}

	@Override
	public synchronized String get() {
		while(message == null) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String res = message;
		message = null;
		this.notifyAll();
		return res;
	}

}
