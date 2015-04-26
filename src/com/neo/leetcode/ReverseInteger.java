package com.neo.leetcode;

public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(new ReverseInteger().reverse(1534236469));
		System.out.println(new ReverseInteger().reverse(123));
	}
	
	public int reverse(int x) {
        //flag marks if x is negative
    	boolean flag = false;
    	if (x < 0) {
    		x = 0 - x;
    		flag = true;
    	}
     
    	int res = 0;
    	int p = x;
     
    	while (p > 0) {
    		int mod = p % 10;
    		p = p / 10;
    		if((res - mod) >= (java.lang.Integer.MAX_VALUE)/10) {
    		    return 0;
    		}
    		res = res * 10 + mod;
    	}
     
    	if (flag) {
    		res = 0 - res;
    	}
     
    	return res;
    }

}
