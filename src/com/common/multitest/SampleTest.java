package com.design;

public class SampleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fn();
	}
	
	static void fn(){
		int[] a = new int[7];
		for (int i=1; i<=9 ; i++) {
			int count = i;
			for(int j=0; j<=6; j++) {
				if(count > 9 ) count = count%9;
				a[j] = count;
				count++;
			}
			
			int x = a[0]*a[1]*a[2];
			int y = a[2]*a[3]*a[4];
			int z = a[4]*a[5]*a[6];
			
			if(x==y && y==z){
				for(int  l= 0; l<=6; l++)
					System.out.print(""+a[l]+"\n");
			}
			for(int  l= 0; l<=6; l++)
				System.out.print(""+a[l]+"");
			
			int temp = a[6];
			a[6] = temp+1>9 ? (temp+1)%9 : temp+1;
			z = a[4]*a[5]*a[6];
			
			if(x==y && y==z){
				for(int  l= 0; l<=6; l++)
					System.out.print(""+a[l]+"\n");
			}
			for(int  l= 0; l<=6; l++)
				System.out.print(""+a[l]+"");
			
			a[6] = temp+2>9 ? (temp+2)%9 : temp+2;
			z = a[4]*a[5]*a[6];
			
			if(x==y && y==z){
				for(int  l= 0; l<=6; l++)
					System.out.print(""+a[l]+"");
			}
			for(int  l= 0; l<=6; l++)
				System.out.print(""+a[l]+"");
			
			System.out.println(" \n");
		}
	}
}
