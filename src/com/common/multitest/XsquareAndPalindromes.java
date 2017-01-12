package com.design;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;

public class XsquareAndPalindromes {

	public static void main(String[] args) throws IOException {
		int c = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String thisLine;
        String line = br.readLine();
        int N = Integer.parseInt(line);
        
        
        int[] ar = new int[N];
        if (N >= 1 && N <= 100) { 
            while ((thisLine = br.readLine()) != null) {     
                ar[c] = countOfRequiredChar(thisLine);
                
                
                if(c==N-1) {
                	for(Integer i : ar) {
                		System.out.println(i);
                	}
    	        }
                c++;
            }
        }
        
        
	}
	
	private static int countOfRequiredChar(String str) {
		int count = 0;
		
		int len = str.length();
		
		if(len >=1 && len <=1000) {
		
			HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
			
			for (int i=0; i<len; i++) {
				char c = str.charAt(i);
				if(hmap.containsKey(c)) {
					hmap.put(c, hmap.get(c)+1);
				} else {
					hmap.put(c, 1);
				}
			}
			
			for(Entry<Character, Integer> e: hmap.entrySet()){
				if(e.getValue()%2 != 0 ) {
					count++;
				}
			}
			
			if(len%2 != 0 || len == 2) {
				count = count-1;
			}
		
		}
		return count;
	}

}

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        int c = 0;
        int[] ar = new int[N];
        if (N >= 1 && N <= 100) { 	
	        for (int i = 0; i < N; i++) {
	        	String str = br.readLine();
	        	int len =str.length();
	        	if( len >=1 &&  len <=1000) {
	        		ar[i] = countOfRequiredChar(str,len);
	        		c++;
	        	}
	        }
	        
	        for(Integer i : ar){
        		System.out.println(i);
        	}
        }       
        
	}
	
	private static int countOfRequiredChar(String str, int len) {
		int count = 0;
		
			HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
			
			for (int i=0; i<len; i++) {
				char c = str.charAt(i);
				if(hmap.containsKey(c)) {
					hmap.put(c, hmap.get(c)+1);
				} else {
					hmap.put(c, 1);
				}
			}
			
			for(Entry<Character, Integer> e: hmap.entrySet()){
				if(e.getValue()%2 != 0 ) {
					count++;
				}
			}
			
			if(len%2 != 0 || len == 2) {
				count = count-1;
			}
		return count;
	}
}

