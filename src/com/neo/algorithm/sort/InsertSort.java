package com.neo.algorithm.sort;

public class InsertSort {

	public static int[] insertSortIntegerArray(int[] integerArray) {
		int tempValue = 0;
		for(int j = 1 ; j < integerArray.length ; j++) {
			for(int i = 0 ; i < j ; i++) {
				if(integerArray[i] > integerArray[j]) {
					tempValue = integerArray[i];
					integerArray[i] = integerArray[j];
					integerArray[j] = tempValue;
				}
				
			}
		}
		return integerArray;
	}
}
