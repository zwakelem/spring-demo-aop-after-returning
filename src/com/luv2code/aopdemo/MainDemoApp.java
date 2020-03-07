package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		Account account = new Account();
		account.setName("Zwaks");
		account.setLevel("Platinum");
		accountDAO.addAccount(account, true);
		accountDAO.doWork();
		
		accountDAO.setName("foobar");
		accountDAO.setServiceCode("silver");
		
		accountDAO.getName();
		accountDAO.getServiceCode();
		
		membershipDAO.addSillyMember();
		membershipDAO.goToSleep();
		
		
		context.close();

	}

}
