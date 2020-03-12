package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	
	private String serviceCode;
	
	public List<Account> findAccounts(boolean tripWire) {
		if(tripWire)
			throw new RuntimeException("No soup for you!!");
		
		List<Account> accounts = new ArrayList<Account>();
		
		Account temp1 = new Account("John", "Silver");
		Account temp2 = new Account("Sibo", "Gold");
		Account temp3 = new Account("Jane", "Platinum");
		
		accounts.add(temp1);
		accounts.add(temp2);
		accounts.add(temp3);
		
		return accounts;
	}
	
	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass() + ": doing DB work adding account");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": doing work method!!");
		return false;
	}

	public String getName() {
		System.out.println(getClass() + ": getName");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": setName");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": getServiceCode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": setServiceCode");
		this.serviceCode = serviceCode;
	}
	
}
