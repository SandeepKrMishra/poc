package com.design;

public class BreakOuterLoop {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			outerloop: 	for (int j = 0; j < 5; j++) {
				if (i * j > 6) {
					System.out.println("Breaking");
					break outerloop;
				}
				System.out.println(i + " " + j);
			}
		}
		System.out.println("Done");
		
	}
}

abstract interface I {
	
}