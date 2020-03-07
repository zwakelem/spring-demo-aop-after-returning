package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(20)
public class MyDemoLoggingAspect {

	@AfterReturning(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);
		System.out.println("\n********>> result is: " + result);
		
		convertAccountNamesToUppercase(result);
		
		System.out.println("\n********>> result is: " + result);
	}
	
	private void convertAccountNamesToUppercase(List<Account> result) {
		for(Account account: result) {
			String upperName = account.getName().toUpperCase();
			account.setName(upperName);
		}
	}

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterNoSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("\n ===========> @Before advice on addAccount()");
		
		//display method signature
		MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
		System.out.println("Method: " + methodSignature);
		
		//display method arguments
		Object[] args = joinPoint.getArgs();
		for(Object arg: args) {
			System.out.println(arg);
			if(arg instanceof Account) {
				Account account = (Account) arg;
				System.out.println("account name: " + account.getName());
				System.out.println("account level: " + account.getLevel());
			}
		}
		
	}
	
}
