package com.design;

public class TallySol {

	public static void main(String[] args) {
		
	}
	
	static boolean flag = false;
	static int elementsArray[];
	static int elementsArray_length;
	static int[] tempArray;
	static int targetValue;
	
	static boolean init(int[] input1,int input2,int input3) {
		elementsArray = input1;
		targetValue = input3;
		elementsArray_length = elementsArray.length-1;;
		tempArray = new int[elementsArray.length];
		
		for(int noOfUsedElements= 1; noOfUsedElements <= elementsArray.length; noOfUsedElements++)
			getMaxNumberOfElementsFromArrayForGivenSum(0, 0, 3);
		
		return flag;
	}
	
	static void getMaxNumberOfElementsFromArrayForGivenSum(int initialIndex, int tempIndex, int noOfUsedElements) {

	    if (tempIndex == noOfUsedElements) {
	    	int sum = 0;
	        for (int j=0; j < noOfUsedElements; j++) {
	        	sum = sum + tempArray[j];
	        }
	        
	        if ( sum == targetValue) {
	        	flag = true;
	        }
	        return;
	    }
	 

	    for (int i=initialIndex; i<=elementsArray_length ; i++) {
	    	tempArray[tempIndex] = elementsArray[i];
	    	getMaxNumberOfElementsFromArrayForGivenSum(i+1, tempIndex+1, noOfUsedElements);
	    }
	}
}	
