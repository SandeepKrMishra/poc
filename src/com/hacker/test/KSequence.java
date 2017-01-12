package com.hacker.test;

public class KSequence {
	public static void main(String[] args) {
		int result = comb();
		System.out.println(" HKHR result: " + result);
	}

	private static int comb() {
		int s = 3;
		int[] a = { 1, 2, 3, 4, 1 };
		int result = 0;

		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
				int k = i;
				int sum = 0;
				while (k <= j && k < a.length) {
					sum = sum + a[k];
					// System.out.print(a[k]);
					k++;
				}
				if (sum % s == 0) {
					result = result + 1;
				}
				// System.out.println(" HKHR : " + sum);
			}
		}
		return result;
	}
}
