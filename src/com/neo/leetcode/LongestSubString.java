package com.neo.leetcode;

import java.util.LinkedList;

public class LongestSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(new LongestSubString().lengthOfLongestSubstring("cdd"));
	}

	public int lengthOfLongestSubstring(String s) {
		LinkedList<Character> hs = new LinkedList<Character>();
		int length = 0;
		int maxLength = 0;
        for(char c : s.toCharArray()) {
        	if(!hs.contains(c)) {
        		hs.add(c);
        		length++;
        	} else {
        		if(maxLength <= length) {
        			maxLength = length;
        		}
        		while(!hs.removeFirst().equals(c)){
        			length--;
        		}
        		hs.add(c);
        	}
        }
        if(maxLength <= length) {
			maxLength = length;
		}
        return maxLength;
    }
}
