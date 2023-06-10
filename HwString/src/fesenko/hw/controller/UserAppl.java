package fesenko.hw.controller;

import fesenko.hw.model.User;

public class UserAppl {

	public static void main(String[] args) {
		User user = new User("peter@gmail.com", "12fgfgS!");
		System.out.println(user);
		user.setEmail("peter@mail.ru");
		System.out.println(user);
		user.setPassword("GTEGUA@");
		System.out.println(user);

	}

}
