package com.design;

public class UsedElementsForSumMain {

	static int elementsArray[] = { 1, 2, 3 };
	// {2,5,8,10,15,24,10,20,30,40,7};
	static int elementsArray_length = elementsArray.length - 1;
	static int[] tempArray = new int[elementsArray.length];
	static int targetValue = 24;

	static void init() {
		// for(int noOfUsedElements= elementsArray.length; noOfUsedElements >=1; noOfUsedElements--)
		for (int noOfUsedElements = 1; noOfUsedElements <= elementsArray.length; noOfUsedElements++)
			getMaxNumberOfElementsFromArrayForGivenSum(0, 0, noOfUsedElements);
	}

	static void getMaxNumberOfElementsFromArrayForGivenSum(int initialIndex, int tempIndex, int noOfUsedElements) {

		if (tempIndex == noOfUsedElements) {
			int sum = 0;
			for (int j = 0; j < noOfUsedElements; j++) {
				sum = sum + tempArray[j];
				System.out.print(" " + tempArray[j]);
			}
			System.out.println();

			if (sum == targetValue) {
				System.out.print("The no. of elements used to get the target sum is : " + noOfUsedElements
						+ " ~~ And the no. are : ");
				for (int j = 0; j < noOfUsedElements; j++) {
					System.out.print(" " + tempArray[j]);
				}
				System.out.println();
			}
			return;
		}

		for (int i = initialIndex; i <= elementsArray_length; i++) {
			tempArray[tempIndex] = elementsArray[i];
			getMaxNumberOfElementsFromArrayForGivenSum(i + 1, tempIndex + 1, noOfUsedElements);
		}
	}

	public static void main(String[] args) {
		init();
	}

}
