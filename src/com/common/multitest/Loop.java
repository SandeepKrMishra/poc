package com.design;

import java.io.IOException;

public class Loop {
	public static void main(String args[]) throws IOException {
		// this is our outer loop
		for (int i = 0; i < 5; i++) {
			// this is the inner loop
			for (int j = 0; j < 5; j++) {
				// condition to break from nested loop
				if (j > 0) {
					break;
				}
				// System.out.println(" j :" + j);
			}
			System.out.println("i : " + i);
		}
		System.out.println("exited");
		// better way is to encapsulate nested loop in a method
		// and use return to break from outer loop breakFromNestedLoop();
	}

	/**
	 * * You can use return statement to return at any point from a method. *
	 * This will help you to break from nested loop as well
	 */
	public static void breakFromNestedLoop() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				int product = i * j;
				if (product > 4) {
					System.out.println("breaking from nested loop using return");
					return;
				}
			}
		}
		System.out.println("Done");
	}
}