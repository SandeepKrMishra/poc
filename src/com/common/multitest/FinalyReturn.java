package com.design;


class ABC implements Comparable {
	
	int age;
	String name;
	
	ABC (int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	
	
	
	@Override
	public int compareTo(Object o) {
		
		
		return 0;
	}
	
}

public class FinalyReturn {

	public static void main(String[] args) {
		String tableName = "hkhr";
		System.out.println("\""+tableName+"\"");
		//System.out.println(returnValue());
	}
	
	private static int returnValue() {
		
		try {
			int i = 5/0;
			return 6;
		} catch(Exception e) {			
			//return 5;
		} finally {
			System.out.println("HKHR");
		}
		
		return 0;
	}

}
