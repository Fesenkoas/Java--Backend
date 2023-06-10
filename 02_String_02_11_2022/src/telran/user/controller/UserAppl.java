package telran.user.controller;

import telran.user.model.User;

public class UserAppl {

	public static void main(String[] args) {
		User user = new User("peter@gmail.com", "1234");
		System.out.println(user);
		user.setEmail("peter@mail.ru");
		System.out.println(user);
	}

}
