package com.neo.leetcode;

public class String2Int {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(new String2Int().myAtoi("   +-12311111111111111111111133434111111111111111111111"));
	}
	
	public int myAtoi(String str) {
        double result = 0;
        char flag = '.';
        if(str == null || str.equals("")) {
        	return 0;
        }
        
        char[] charArray = str.trim().toCharArray();
        
        for(char c : charArray) {
        	if(c == '-' && flag =='.') 
        		flag = '-';
        	else if(c == '+' && flag == '.') 
        		flag = '+';
        	else if(c < '0' || c > '9')
        		break;
        	if(c >= '0' && c <= '9')
        		result = result * 10 + (c-'0');
        }
        
        if(flag == '-')
        	result = -result;
        
        if(result >= Integer.MAX_VALUE)
        	result = Integer.MAX_VALUE;
        if(result <= Integer.MIN_VALUE)
        	result = Integer.MIN_VALUE;
        return (int) result;
    }
}
