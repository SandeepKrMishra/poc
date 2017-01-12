package com.design;

public class MaxElementForSum {
	int sum = 30;
	
	public static void main(String[] args) {
		//int[] a = {2, 3, 20, 4, 15, 7, 30, 10, 5, 50};
		int[] a = {1, 2, 3};
		for(int i = 0; i < a.length; i++) {
			findElement(a, i);
		}
	}
	
	private static void findElement(int[] elementArray, int index) {
		
		
		for(int i = 0; i <= index; i++) {
			if(index < elementArray.length) {				
				index = index +1;
				findElement(elementArray, index);
				System.out.print(elementArray[i]+", ");
				System.out.println();
			}
			
		}
		
		return;
	}
}
