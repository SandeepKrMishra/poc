package com.design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCrow {
	public static int ThirstyCrowProblem(int[] input1, int input2, int input3) {
		int result = 0;
		List<Integer> list = new ArrayList<Integer>();
		for (int e : input1) {
			list.add(e);
		}
		Collections.sort(list);

		if (list.size() != input2) {
			return -1;
		}


		for (int i = 0; i < input3; i++) {
			int value = list.get(i);
			int count = 1;
			for (int j = i + 1; j < list.size(); j++) {
				int vls = list.get(j);
				if (vls > value) {
					count = count + 1;
				}
			}
			result = result + value * count;

		}
		return result;
	}

	public static void main(String[] args) {
		// {5,58},2,2
		int r = ThirstyCrowProblem(new int[] { 5, 58 }, 2, 1);
		System.out.println("HKHR : " + r);
	}

}
