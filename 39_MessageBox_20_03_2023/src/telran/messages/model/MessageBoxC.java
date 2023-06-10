package telran.messages.model;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MessageBoxC implements MessageBox {
	String message;
	Lock locker = new ReentrantLock();
	Condition senderWaitCondition = locker.newCondition();
	Condition receiverWaitCondition = locker.newCondition();

	@Override
	public void post(String message) {
		locker.lock();
		
		try {
			while (this.message != null) {
				try {
					senderWaitCondition.await();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
			this.message = message;
			receiverWaitCondition.signal();
		} finally {
			locker.unlock();
		}

	}

	@Override
	public String get() {

		locker.lock();
		try {
			while (message == null) {
				try {
					receiverWaitCondition.await();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
			String res = message;
			message = null;
			senderWaitCondition.signal();
			return res;
		} finally {
			locker.unlock();
		}
		
	}

}
