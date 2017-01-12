package com.design;

import java.util.HashMap;
import java.util.Map;

public class EmpPoint {

	public static void main(String[] args) {
		int[] arr = {6,3,5,17,19,15,13,15,6,3,5,18,19};
		//int[] arr = {15,3,15,3};
		
		System.out.print(empPoint(arr));
	}
	private static String empPoint(int[] input1) {
		String str = "";
		int[] tempArr = new int[input1.length+1];
		tempArr[0] = 0;
		
		if(input1[0] < 0 || input1[0] > 20) {
			return "invalid";
		}
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 1; i <= input1.length; i++) {
			
			if(input1[i-1] < 0 || input1[i-1] > 20) {
				return "invalid";
			}
			
			if(map.containsKey(input1[i-1]) && map.get(input1[i-1]) < 1) {
				tempArr[i] = tempArr[i-1]+1;
				map.put(input1[i-1], map.get(input1[i-1])+1);
			}else {
				map.put(input1[i-1], 0);
				tempArr[i] = tempArr[i-1];
			}
		}
		
		for(int j= 1; j< tempArr.length;j++) {			
			str = str + tempArr[j]+", ";
		}	
		str = str.substring(0, str.length()-2);
		
		return str.trim();
	}
}
