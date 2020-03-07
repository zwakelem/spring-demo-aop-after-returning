package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public String addSillyMember() {
		System.out.println(getClass() + ": doing DB work adding account");
		return "";
	}
	
	public void goToSleep() {
		System.out.println(getClass() + ": I am going to sleep");
	}

}
