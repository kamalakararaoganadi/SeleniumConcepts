package com.test;

import org.testng.annotations.Test;

public class InvocationTestCountConcept {
	@Test(invocationCount = 3)
	public void add() {
		
		int a = 10;
		int b= 20;
		int c = a+b;
		System.out.println("Result: "+c);
	}
}
