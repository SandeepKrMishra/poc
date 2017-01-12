package com.design;

public class TestPalindrom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String el[]= {"Bharti", "Akash","Bhavya","Chnad", "Brijesh","Arvind","Bhavna"};
		Pal.init(el);
		
		System.out.println(Pal.targetValue);
	}

}

class Pal {	
	
	static String elementsArray[];
	static int targetValue = 1;
	
	static int elementsArray_length;
	static String[] tempArray;
	
	static void init(String[] input1) {
		elementsArray_length =input1.length-1;
		tempArray = new String[input1.length];
		elementsArray = new String[input1.length];
		
		for(int i = 0; i <  input1.length; i++){
			elementsArray[i] = input1[i].charAt(0)+"";
		}
		
		for(int noOfUsedElements= elementsArray.length; noOfUsedElements >=1; noOfUsedElements--)
			getMaxNumberOfElementsFromArrayForGivenSum(0, 0, noOfUsedElements);
	}
	
	static void getMaxNumberOfElementsFromArrayForGivenSum(int initialIndex, int tempIndex, int noOfUsedElements) {

	    if (tempIndex == noOfUsedElements) {
	    	String pal="";
	        for (int j=0; j < noOfUsedElements; j++) {
	        	pal = pal + tempArray[j];
	        }
	        
	        if (checkPal(pal) && targetValue < noOfUsedElements) {
	        	targetValue = noOfUsedElements;
	        }
	        return;
	    }
	 

	    for (int i=initialIndex; i<=elementsArray_length ; i++) {
	    	tempArray[tempIndex] = elementsArray[i];
	    	getMaxNumberOfElementsFromArrayForGivenSum(i+1, tempIndex+1, noOfUsedElements);
	    }
	}
	
	static boolean checkPal(String arr) {
		
		for(int i = 0; i < (arr.length()/2) ; i++) {
			if(arr.charAt(i)!=arr.charAt(arr.length()-i-1)) {	
				return false;
			}			
		}		
		return true;
	}
}	