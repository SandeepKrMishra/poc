package com.design;

import java.util.ArrayList;
import java.util.TreeSet;

class Name {
	String name ;
	
	Name(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.name.equals(((Name)obj).name);
	}
	
}

class A {
	private A() {
		
	}
	A(int a){
		
	}
}
public class AAA extends A{

	AAA() {
		super(5);
	}
		
	public static void main(String[] args) {
		/*double i = 1.0/0;
		//System.out.println(i);
		
		int a=9,b=-5;
		
		//System.out.println(a>b?a:b);
		UsedElementsForSum.init();
		//SapCode.init();
		
		ArrayList ar = new ArrayList();
		ar.add("");
		ar.add(1);
		
		TreeSet ts = new TreeSet();
		ts.add("");
		ts.add(1);
		ts.add("name");
		ts.add(null);*/
		
		Name n1 = new Name("Sandeep");
		Name n2 = new Name("Sandeep");
		
		System.out.println(" == "+(n1==n2));
		System.out.println(" equals : "+n1.equals(n2));
	}
}


/*
 * Get the max number of elements from array for a given sum.
 * 
*/
class UsedElementsForSum {	
	
	static int elementsArray[] = {1,2,3};
									//{2,5,8,10,15,24,10,20,30,40,7};
	static int elementsArray_length =elementsArray.length-1;
	static int[] tempArray = new int[elementsArray.length];
	static int targetValue = 24;
	
	static void init() {
		//for(int noOfUsedElements= elementsArray.length; noOfUsedElements >=1; noOfUsedElements--)
		for(int noOfUsedElements= 1; noOfUsedElements <= elementsArray.length; noOfUsedElements++)
			getMaxNumberOfElementsFromArrayForGivenSum(0, 0, noOfUsedElements);
	}
	
	static void getMaxNumberOfElementsFromArrayForGivenSum(int initialIndex, int tempIndex, int noOfUsedElements) {

	    if (tempIndex == noOfUsedElements) {
	    	int sum = 0;
	        for (int j=0; j < noOfUsedElements; j++) {
	        	sum = sum + tempArray[j];
	        	System.out.print(" "+ tempArray[j]);
	        }
	        System.out.println();
	        
	        if ( sum == targetValue) {
	        	System.out.print("The no. of elements used to get the target sum is : "
	        			+noOfUsedElements+" ~~ And the no. are : ");
	        	for (int j=0; j < noOfUsedElements; j++) {
	        		System.out.print(" "+ tempArray[j]);
	        	}
	        	System.out.println();
	        }
	        return;
	    }
	 

	    for (int i=initialIndex; i<=elementsArray_length ; i++) {
	    	tempArray[tempIndex] = elementsArray[i];
	    	getMaxNumberOfElementsFromArrayForGivenSum(i+1, tempIndex+1, noOfUsedElements);
	    }
	}
}	

class SapCode{
	
	//Assume following return types while writing the code for this question. 
	public static String output1;
	public static int output2;
    
	static void init() {
		StreetHousePlanning(5);
		getStringPattern("Hello World");
		apORgp(1,2,3);
	}
	
//=================================================================================

		/*
	 	Question : 1
		Planning the street 
		King Kohima has reserved a new exclusive street for his executive class employees
		where they can build their homes. He has assigned you to plan that street. You have
		to decide on which plots along the street are new building allowed to be built. In 
		order to this, you first want to calculate the number of possible ways of assigning 
		free plots to buildings while keeping in mind this restriction - No two consecutive 
		plots can have buildings on them. This is done to ensure a sense of free space in the 
		arena. The street is divided in M sections. Each section corresponds to 2 plots, one 
		on each side of the street. Find the number of possible assignments. Input In the first 
		line you're given M ( M ≤ 1000 ).Output In the first and only line output the result/ 
		
		Example Input: 3 Output: 25 Example explanation: 
		If we just look at the one street side and mark X as a plot where 
		building is allowed and Y as a free plot, we have: XYX, YXY, YYX, XYY, YYY. 
		Since the same number exists on the other side, we have 5*5 = 25 combinations.
		*/
//=================================================================================
	
    public static void StreetHousePlanning(int input1)
    {
        int first = 2;
		int second = 3;
		
		if(input1==1) {
			output2 = first*first;
		}
		else if (input1==2){
			output2 = second*second;
		} else {
			for (int i=1; i<= input1-2; i++){
				int temp = second;
				second = first+second;
				first = temp;
			}
			output2 = second*second;
		}
		System.out.println("Total possible combination are : "+output2);
    }	
    
//=================================================================================

    	/*
 		Question : 2
 		Get the sentence into following pattern as mentioned in example.
 		
 		Example Input: Hello World
 		Output: Olleh Dlrow
 		*/

//=================================================================================
    
    public static void getStringPattern(String input1) {
    	String[] array = input1.split(" ");
        String finalStr = ""; 
        for(int i=0; i<array.length; i++) {
        	
        	String str = array[i]; 
        	String s1 = "";
        	String s = "";
        	boolean flag = true;
        	for(int j=str.length()-1; j >=0 ; j--) {
        		if(flag) {
        			s = (s + str.charAt(j)).toUpperCase();
        			flag = false;
        		} else {
        			s1 = (s1 + str.charAt(j)).toLowerCase();
        		}
        	}
        	
        	finalStr = finalStr +s+ s1+ " ";
        }
        
        System.out.println(finalStr);
    }
    
//=================================================================================

    	/*
    	Question : 3
    	Complete the code to solve the following problem statement 
    	An arithmetic progression (AP) is a sequence of numbers such that the 
    	difference of any two successive members of the sequence is a constant. 
    	A geometric progression (GP) is a sequence of numbers where each term after 
    	the first is found by multiplying the previous one by a fixed non-zero number 
    	called the common ratio. Given three successive members of a sequence, you need 
    	to determine the type of the progression and the next successive member. You need
    	to fill in a function which takes as input three integers, which are successive 
    	members of a sequence, and set the output variable to a string containing XX_v, where 
    	XX is either AP or GP depending on whether the given sequence is an AP or a GP and v is 
    	the next member of the given sequence. 
    	
    	Example: 
    	Input: 4 7 10 
    	Output: AP_13
    	*/

//=================================================================================
    
    public static void apORgp (int a, int b, int c) {
		int ret = isAP(a, b, c);
		
		if (ret != 0)
			output1 = String.format("AP_%d", ret);
		else {
			ret = isGP(a, b, c);
			output1 = String.format("GP_%d", ret);
		}
		
		System.out.println("AP_or_GP :"+output1);
	}

	private static int isAP (int a, int b, int c) {
		if((c-b)==(b-a))
			return c+(b-a);
		return 0;
	}

	private static int isGP (int a, int b, int c) {
		if((c/b)==(b/a)) {
			int r = (c/b);
			return a*r*r*r;
		}
		return 0;
	}	
}

