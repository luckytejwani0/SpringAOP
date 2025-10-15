package com.seed.service;

import org.springframework.stereotype.Component;

@Component
public class UserService {
	
	public void checkUser() {
		System.out.println("In the checkUser()...");
		System.out.println("Valid user...");
	}
	
	public int add(int a, int b) {
		System.out.println("In the add()...");
		return a+b;
	}
	
	public void checkBalance(int balance) throws Exception{
		if(balance < 5000) {
			throw new Exception("Insufficient balance!");
		}
		else
			System.out.println("Thanks for using application...");
	}

}
