package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		System.out.println("\nMain program: AroundDemoApp");
		System.out.println("Calling getFortune");
		
		String data = fortuneService.getFortune();
		System.out.println("\nMy Fortune is: " + data);
		System.out.println("Finished!!");
		
		context.close();
		
	}
}
