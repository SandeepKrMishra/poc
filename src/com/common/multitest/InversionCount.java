package com.design;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class InversionCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		try {
			FileReader in = new FileReader("/home/sandeep/Desktop/IntegerArray.txt");
			BufferedReader br = new BufferedReader(in);

			ArrayList<Integer> data = new ArrayList<Integer>();
			ArrayList<Integer> temp_data = new ArrayList<Integer>();
			String value;
		   /* while ((value = br.readLine()) != null) {
		        data.add(Integer.parseInt(value));		       
		    }*/
		    
		    data.add(6);
		    data.add(5);
		    data.add(4);
		    data.add(3);
		    data.add(1);
		    data.add(2);
		    
		    System.out.println("HKHR: Stared : "+data.size());
		    //System.out.println("Simle Inversion Count is : "+simpleInverCount(data));		    
		    System.out.println("DivideAndConquer Inversion Count is : "+DivideAndConquerInverCount(data, temp_data));		    
		    System.out.println("HKHR: Finished");
		    
		    for(Integer i : data){
		    	System.out.print(" "+i);
		    }
		    
		    in.close();
		    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	
	private static double DivideAndConquerInverCount(ArrayList<Integer> data, ArrayList<Integer> temp_data) {
		
		return mergeSort(data, temp_data, 0, data.size()-1);
	}
	
	private static double mergeSort(ArrayList<Integer> data, ArrayList<Integer> temp_data, int left, int right) {
		double inverCount = 0;	
		int mid;
		
		if(right > left) {
			
			mid = (right+left)/2;
			 
			inverCount += mergeSort(data, temp_data, left, mid);
			inverCount += mergeSort(data, temp_data, mid+1, right);
			
			inverCount += mergInvCount(data, temp_data, left, mid, right);
		}
		
		return inverCount;
	}
	
	private static int mergInvCount(ArrayList<Integer> data, ArrayList<Integer> temp_data, int left, int mid, int right) {
		int i, j, k;
		int inv_count = 0;
	  
		i = left; /* i is index for left subarray*/
		j = mid;  /* i is index for right subarray*/
		k = right; /* i is index for resultant merged subarray*/
		while ((i <= mid - 1) && (j <= right)) {
			if (data.get(i) <= data.get(j)) {
				temp_data.set(k++, data.get(i++));
			}
			else {
				temp_data.set(k++, data.get(j++));
				inv_count = inv_count + (mid - i);
			}
		}
	  
	  	/* Copy the remaining elements of left subarray
	   	(if there are any) to temp*/
	  	while (i <= mid - 1)
		  temp_data.set(k++, data.get(i++));
	  
	  	/* Copy the remaining elements of right subarray
	   	(if there are any) to temp*/
	  	while (j <= right)
	  		temp_data.set(k++, data.get(j++));
	  
	  	/*Copy back the merged elements to original array*/
	  	for (i=left; i <= right; i++)
	  		data.set(i++, temp_data.get(i++));
	  
	  	return inv_count;
	}
	
	
	private static double simpleInverCount(ArrayList<Integer> data) {		
		double inverCount = 0;		
		
		for (int i=0; i < data.size()-1; i++) {
			for (int j=i+1; j < data.size(); j++) {
				if(data.get(i) > data.get(j)) {
					inverCount++;
				}
			}
		}		
		return inverCount;
	}

}
