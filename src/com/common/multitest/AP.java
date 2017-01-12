package com.design;

import java.util.Scanner;

public class AP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fn());
	}
	
	private static int fn() {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		if (N>=3 && N<=2500) {
			String num = sc.nextLine();
			
			int d = 0;
			String[] values = num.split(" ");
			
			int d1 = Integer.parseInt(values[1]) - Integer.parseInt(values[0]);
			int d2 = Integer.parseInt(values[2]) - Integer.parseInt(values[1]);
			
			if(d1==d2) {
				d = d1;
			} else {
				int d3 = Integer.parseInt(values[3]) - Integer.parseInt(values[2]);
				if(d1==d3) d = d3;
				else if(d2 == d3) d = d3;
			}
			
			for(int i = 1; i < N; i++) {			
				if(d+ Integer.parseInt(values[i-1]) != Integer.parseInt(values[i]))
					System.out.println(d+Integer.parseInt(values[i-1]));
			}
		}
		
		return 0;
	}

}
