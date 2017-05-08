package com.laps.customer.thread;

public class Account {

	public static Account account;
	private static int balance = 1000;
	private static Person person;

	private Account() {
	}

	public static Account getAccount(Person p) {
		if (account == null) {
			account = new Account();
		}
		Account.person = p;
		return account;
	}

	public static int getBalance() {
		return balance;
	}

	public synchronized void withdraw(int bal) {
		try {

			if (balance >= bal) {
				System.out.println(person.getName() + " withdraw initiated");
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
				balance = balance - bal;
				System.out.println(person.getName() + " withdraw completed");
			} else {
				System.out.println(person.getName() + " insufficient balanace");
			}
			System.out.println(person.getName() + " withdrawn Rs." + balance);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public synchronized void deposit(int bal) {
		try {
			if (bal > 0) {
				System.out.println(person.getName() + " deposit initiated");
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
				balance = balance + bal;
				System.out.println(person.getName()  + " deposit completed");
			} else {
				System.out.println(person.getName()  + " insufficient balanace");
			}
			System.out.println(person.getName() + " deposited Rs." + balance);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
