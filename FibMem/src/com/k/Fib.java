package com.k;

import java.math.BigInteger;
import java.util.ArrayList;

public class Fib {

	private ArrayList<BigInteger> list = new ArrayList<BigInteger>();

	private BigInteger last, secondLast, currFib;

	public BigInteger lastFib;

	public void populateArray(String filename, BigInteger num) {
		list = Utils.fillArrayFromTxt(filename);
		if (num.intValue() == 0)
			lastFib = BigInteger.ZERO;
		else {
			if (list.size() > num.intValue())
				if (list.get(num.subtract(BigInteger.ONE).intValue()) != null)
					lastFib = list.get(num.intValue());
			if (num.intValue() > 2) {
				last = new BigInteger(String.valueOf(list.size() - 1));
				BigInteger second = last.subtract(BigInteger.ONE);
				for (BigInteger i = second; i.compareTo(num
						.subtract(BigInteger.ONE)) == -1; i = i
						.add(BigInteger.ONE)) {
					last = new BigInteger(String.valueOf(list.size() - 1));
					secondLast = last.subtract(BigInteger.ONE);
					nextFib();
					lastFib = list.get((list.size() - 1));
					Utils.appendTxtFromArray(lastFib.toString(), filename);
				}
			} else {
				if (num.intValue() == 1)
					lastFib = BigInteger.ONE;
				else
					lastFib = new BigInteger("2");
			}
		}
	}

	public ArrayList<BigInteger> getList() {
		return list;
	}

	public BigInteger nextFib() {
		currFib = list.get(last.intValue())
				.add(list.get(secondLast.intValue()));
		list.add(currFib);
		return currFib;
	}

}
