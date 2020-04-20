package com.test;

import org.testng.annotations.Test;

public class ExceptionTimeoutTest {

	//With in the time out test case has to be completed
	@Test(timeOut = 1000)
	public void infiniteLoopTest() {
		int i = 1;
		while (i==1) {
			System.out.println(i);
			
		}
	}
	
	
	//test2 will be passed even tough the test case is failed since the exception is handled
	@Test(expectedExceptions = NumberFormatException.class)
	public void Test2() {
		
		String s = "100A";
		Integer.parseInt(s);
			
		
	}
}
