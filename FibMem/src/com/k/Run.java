package com.k;

import java.math.BigInteger;
import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger num;
		String awnser;
		System.out.println("What's the fibonacci number you want?");
		num = sc.nextBigInteger();
		System.out
				.println("Iterative mode?(Show every number till desired one?(Y\\N)");
		awnser = sc.next();
		if (num.intValue() == 1)
			System.out.println("Calculating fibonacci numbers till the " + num
					+ "st fibonacci number");
		else if (num.intValue() == 2)
			System.out.println("Calculating fibonacci numbers till the " + num
					+ "nd fibonacci number");
		else if (num.intValue() == 3)
			System.out.println("Calculating fibonacci numbers till the " + num
					+ "rd fibonacci number");
		else
			System.out.println("Calculating fibonacci numbers till the " + num
					+ "th fibonacci number");
		long prevSysTime = System.currentTimeMillis();
		Fib fib = new Fib();
		fib.populateArray("array.txt", num);
		int index = 0;
		if (awnser.equals("Y"))
			for (BigInteger e : fib.getList()) {
				System.out.println("Fibonacci[" + index + "] = " + e);
				index++;
			}
		System.out.println("Result: " + fib.lastFib);
		sc.close();
		long currSysTime = System.currentTimeMillis() - prevSysTime;
		System.out.println("Fibonacci number found in " + currSysTime
				+ " milliseconds");
	}
}
