package telran.user.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.user.model.User;

class UserEqulsTest {

	@Test
	void test() {
		String password = "123456Ab!";
		User user1 = new User("peter@gmail.com",password);
		User user2 = new User("peter@gmail.com",password);
		boolean check = user1 ==user2;
		System.out.println(check);
		check = user1.equals(user2);
		System.out.println(check);
	}

}
