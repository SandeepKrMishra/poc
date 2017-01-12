package com.design;

public class SecondLargestElement {
	static int totalStairsValue = 4, i=0;
	public static void main(String[] args) {		
		System.out.println("HKHR : "+getTotalStepPossibilities(0));
	}
	
	private static int getTotalStepPossibilities(int stairs) {
		
		if(stairs < totalStairsValue) {
			getTotalStepPossibilities(stairs+1);
			getTotalStepPossibilities(stairs+2);
		}
		
		if(stairs == totalStairsValue)
			i = i+1;
		
		return i;
	}

}
