package com.design;

public class PowerOfNumber {

	public static void main(String[] args) {
		//System.out.println(getPoweredValue(2,3));
		test();
	}
	
	private static int getPoweredValue(int baseValue, int powerValue) {
		
		if(powerValue == 1)
			return baseValue;
		
		int result =  0;
		int pow = baseValue;
		
		for(int i = 1; i < powerValue; i++ ) {
			result=0;
			for(int j = 1; j <= pow; j++ ) {
				result = result + baseValue;
			}
			baseValue = result;
		}			
		return result;
	}
	
	private static void test() {
		int[] ar = {1, 2, 3};
		rec(ar, 0);
	}
	
	private static void rec(int[] ar, int c) {
		
		for (int v =0; v <= c ;v++) {
			System.out.print(" "+ar[v]);
		}
		
		System.out.println();
		
		for( int i = 0; i < ar.length; i++) {
			rec(ar, i+1);
		}
	}
}
