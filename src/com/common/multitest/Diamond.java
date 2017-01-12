package com.design;

public class Diamond {

	public static void main(String[] args) {
		halfDiamond();
		numberDiamond();
		diamond();
	}
	
	static void halfDiamond() {
		/*
		 
		Shape :  
		    *
		   ***
		  *****
		 *******
		*********
		
		*/
		for(int i=4; i>=0; i--) {
			int count=0;
			for(int j=0; j<=4; j++) {
				if(j<i) {
					System.out.print(" ");
					
				}
				else {				
					System.out.print("*");
					count++;
				}
				
			}
			for(int k=0; k<count-1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	static void numberDiamond() {
		/*
		 
		 Shape :  
		    1
		   121
		  12321
		 1234321
		123454321
				 
		*/
		
		for(int i=4; i>=0; i--) {
			int count=0, c=1;
			for(int j=0; j<=4; j++) {
				if(j<i) {
					System.out.print(" ");
					
				}
				else {				
					System.out.print(c);
					count++;
					c++;
				}
				
			}
			for(int k=count-1; k>0; k--) {
				System.out.print(k);
			}
			System.out.println();
		}
	}
	
	static void diamond() {
		
		/*
		 
		 Shape :
		 
		    *
		   ***
		  *****
		 *******
		*********
		 *******
		  *****
		   ***
		    *
		 
		*/
		
		for(int i=4; i>=0; i--) {
			int count=0;
			for(int j=0; j<=4; j++) {
				if(j<i) {
					System.out.print(" ");
					
				}
				else {				
					System.out.print("*");
					count++;
				}
				
			}
			for(int k=0; k<count-1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i=0; i<=3; i++) {
			int count=0;
			for(int j=0; j<=4; j++) {
				if(j<=i) {
					System.out.print(" ");
					
				}
				else {				
					System.out.print("*");
					count++;
				}
				
			}
			for(int k=0; k<count-1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
