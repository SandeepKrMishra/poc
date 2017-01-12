package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*interface SingleImpl {
	Singletone getInstance();
}

class Singletone implements SingleImpl{
	private static Singletone singleInstance;// = new Singletone();

	private Singletone() {
		
	}
	
	public static Singletone getInstance() {
		if(singleInstance==null) 
			singleInstance = new Singletone();
		return singleInstance;
	}
}*/


class JobMachine {
	
	int maxProfite(String[] jobTimes) {
		System.out.println("hkhr v : "+"3PM".compareTo("3AM"));
		
		
		
		return 0;
	}
	
}


public class ATest {
	
	public static int[] getMaximumToysWithMaxSaving(int input1,int[] input2)
    {	int left_amount = input1;
    	int bought_toy = 0;
    	int min_saveing = 0;
    	
		List<Integer> ls = new ArrayList<Integer>();
		for(Integer i : input2)
			ls.add(i);
		
		Collections.sort(ls);
		
		for(int i = 0; i < ls.size(); i++) {
			int toy_price = ls.get(i);
			if(left_amount >= toy_price) {
				left_amount = left_amount - toy_price;
				bought_toy++;
			}
		}
		
		for(int i = ls.size()-1; i > bought_toy; i--) {
			for(int j = bought_toy; j >=0 ; j--) {
				if(left_amount+ls.get(j) >= ls.get(i))
					min_saveing = left_amount+ls.get(j) - ls.get(i);
			}
		}
			
		return new int[]{bought_toy, min_saveing};
    }

	static public void main(String[] args) {
		
		int[] aT = getMaximumToysWithMaxSaving(50, new int[]{1,18,5,111,200,1000,10,9,6,7,4});
		System.out.println(aT[0]+" "+aT[1]);
		
		
		int[] ary = {2,9,5,6,11,30,35,55,60,45};
		int[] bry = new int[10];
		
		for(int i =0; i <ary.length; i++)
			bry[i] = 1;
		
		for(int k =1; k < ary.length; k++) {
			for(int i =k; i >0; i--) {
				if(ary[i-1] < ary[k] && bry[k] <= bry[i-1])
					bry[k] = bry[i-1]+1; 
			}
		}
		
		for(int i =0; i <ary.length; i++)
			System.out.println("hkhr : "+bry[i]);
		
		
		String str = "anamika";
				
		System.out.println("its string :"+str);
				
		String splitArray[] = str.split("a");
			
			//System.out.println(splitArray[i]);
		int a[][] = {{1,2,3},{4,5,6},{7,8,9}};
		
	  for(int i=0;i<=2;i++){
		for(int j=0;j<=2;j++){
			if(i==j)			
				System.out.print(" * ");
			else{
				System.out.print(" "+a[i][j]+" ");
			}
		}
		System.out.println();
		
	}	
}
}		
		































// ===================================  Program Methods ======================

class Method {
	
	static void readerMethod() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner scanner = new Scanner(System.in);
		int len = Integer.parseInt(br.readLine());

	}
	
	static String reverse(String sentence) {
		String revSent = "";
	
		String[] tokens = sentence.split(" ");
	
		for (int i = tokens.length - 1; i >= 0; i--) {
			revSent = revSent + tokens[i] + " ";
		}
	
		return revSent;
	}
	
	static String ele(int a[], int value) {
	
		for (int i = 0; i < a.length; i++) {
			int temp = 0;
			String str = "";
			for (int j = i; j < a.length; j++) {
				if (value == a[j]) {
					return String.valueOf(a[j]);
				}
	
				if (temp == value) {
					return str;
				} else if (value > a[j]) {
					temp = temp + a[j];
					str = str + a[j] + "\n";
				}
			}
		}
	
		return "O";
	
	}
	
	static int[] merge(int[] M, int[] N) {
		int[] z = new int[M.length + N.length];
	
		return z;
	}

	static void mapWork() {
		
		 HashMap<Col, String> hm = new LinkedHashMap<Col, String>();
		 
		 hm.put(new Col("A", 1, "A"), "A"); 
		 hm.put(new Col("A", 5, "A"), "A"); 
		 hm.put(new Col("S", 2, "SS"), "S");
		 hm.put(new Col("A", 1, "C"), "C"); 
		 hm.put(new Col("K", 1, "R"), "R");		 
		 
		 for(Entry<Col, String> e : hm.entrySet()) {
		 System.out.println("HKHR : key "+e
				 .getKey().str+"-----"+e.getKey().ag+"<<<<>>>>"+e.getValue()); }
	}
	
	static void threadMethod() {
		
		 ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
		 for(int i = 0; i < 100; i++) { 
			 service.scheduleWithFixedDelay(new
					 TestThreadPool(i), 1000l, 1000l, TimeUnit.MILLISECONDS);
			 //execute(new TestThreadPool(i)); 
		}		 
	}
}

class Col implements Iterable<String>{

	String str;
	String val;
	int ag;
	List ls;

	Col(String str, int ag, String val) {
		this.str = str;
		this.ag = ag;
		this.val = val;
	}

	@Override
	public int hashCode() {
		return 5;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("hkhr : " + str + " === " + val);
		return str.equals(val);
		// return false;
	}

	@Override
	public Iterator<String> iterator() {
		return ls.iterator();
	}
}



 class TestThreadPool implements Callable, Runnable { 
	 int i; 
	 public TestThreadPool(int i) { 
		 this.i = i; 
	 }

	 @Override 
	 public void run() {
		 System.out.println("===> Its thread pool. ID : "
				 +i+" , Name : "+Thread.currentThread().getName());
	 }

	 @Override
	 public Object call() throws Exception {
		 System.out.println("Its thread pool. ID : "
				 +i+" , Name : "+Thread.currentThread().getName()); 
		 return "!!!!! done !!!!!";
	 } 	 
 }
 