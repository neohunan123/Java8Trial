package com.neo.leetcode;

import java.util.Hashtable;

public class TwoNums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {2, 7, 11, 15};
		int target = 17;
		System.out.println(new TwoNums().twoSum(numbers, target));

	}
	
	public int[] twoSumFirst(int[] numbers, int target) {
		int first = 0 ;
		int second = 0;
		for(int i =0 ; i < numbers.length ; i++) {
			for(int j = i+1 ; j < numbers.length ; j++) {
				if(numbers[i] + numbers[j] == target) {
					first = i+1;
					second = j+1;
					break;
				}
			}
		}
		return new int[]{first, second};
	}
	
	public int[] twoSum(int[] numbers, int target) {
		int[] a = new int[2];
		Hashtable<Integer, Integer> nums = new Hashtable<Integer, Integer>();
		for(int i =0 ; i < numbers.length ; i++) {
			Integer n = nums.get(numbers[i]);
			if(n == null)
				nums.put(numbers[i], i);
			n = nums.get(target - numbers[i]);
			if(n != null && n < i) {
				a[0] = n+1;
				a[1] = i+1;
				return a;
			}
		}
		return a;
	}

}
