package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

		List<Account> accounts = null;
		
		try {
			boolean tripWire = false;
			accounts = accountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("\n\nMain program caught exception: " + e);
		}
		
		
//		System.out.println("\n\nMain program: AfterReturningDemoApp");
		System.out.println("\n\nMain program: AfterThrowing");
		System.out.println("----------------");
		System.out.println(accounts);
		System.out.println("\n");
		
		context.close();

	}

}
