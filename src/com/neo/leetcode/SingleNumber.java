package com.neo.leetcode;

public class SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,4,5,4,3,2,1};
		System.out.println(new SingleNumber().singleNumber(a));

	}
	
	public int singleNumber(int[] A) {
        int res = 0;
        for (int i : A) {
            res ^= i;
        }
        return res;
    }

}
