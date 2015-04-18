package com.neo.leetcode;

public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1,5,8,2,5,3,9};
		int[] nums2 = {4,2,5,7,5,4,2,5,9};
		ListNode pFirst = new ListNode(nums1[0]);
		ListNode p1 = pFirst;
		ListNode pSecond = new ListNode(nums2[0]);
		ListNode p2 = pSecond;
		for(int i = 1;i < nums1.length;i++) {
			
			p1.next = new ListNode(nums1[i]);
			p1 = p1.next;
			System.out.println(p1.val);
		}
		for(int i = 1;i < nums2.length;i++) {
			p2.next = new ListNode(nums2[i]);
			p2 = p2.next;
			System.out.println(p2.val);
		}
		
		ListNode p3 = new AddTwoNumbers().addTwoNumbers(pFirst, pSecond);

	}
	
	public ListNode addTwoNumbersFirst(ListNode l1, ListNode l2) {
		 
        ListNode p1 = l1;
        ListNode p2 = l2;
 
        ListNode newHead = new ListNode(0);
        ListNode p3 = newHead;
 
        int val;//store sum
 
        boolean flag = false;//flag if greater than 10
 
        while(p1 != null || p2 != null){
            //both p1 and p2 have value
            if(p1 != null && p2 != null){
 
                if(flag) {
                    val = p1.val + p2.val + 1;
                } else {
                    val = p1.val + p2.val;
                }
                
                if(val >= 10) {
                    flag = true;
                } else {
                    flag = false;
                }
 
                p3.next = new ListNode(val%10);
                p1 = p1.next;
                p2 = p2.next;
            //p1 is null, because p2 is longer                
            } else if(p2 != null) {
 
                if(flag) {
                    val = p2.val + 1;
                    if(val >= 10) {
                        flag = true;
                    } else {
                        flag = false;
                    }
                } else {
                    val = p2.val;
                    flag = false;
                }
 
                p3.next = new ListNode(val%10); 
                p2 = p2.next;
 
            ////p2 is null, because p1 is longer  
            } else if(p1 != null) {
 
                if(flag) {
                    val = p1.val + 1;
                    if(val >= 10) {
                        flag = true;
                    } else {
                        flag = false;
                    }
                } else {
                    val = p1.val;
                    flag = false;
                }
 
                p3.next = new ListNode(val%10); 
                p1 = p1.next;
            }
 
            p3 = p3.next;
        }
 
        //handle situation that same length final sum >=10
        if(p1 == null && p2 == null && flag){
            p3.next = new ListNode(1);
        }
 
        return newHead.next;
    }
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry =0;
 
        ListNode newHead = new ListNode(0);
        ListNode p1 = l1, p2 = l2, p3 = newHead;
 
        while(p1 != null || p2 != null){
            if(p1 != null){
                carry += p1.val;
                p1 = p1.next;
            }
 
            if(p2 != null){
                carry += p2.val;
                p2 = p2.next;
            }
 
            p3.next = new ListNode(carry%10);
            p3 = p3.next;
            carry /= 10;
        }
 
        if(carry==1) 
            p3.next=new ListNode(1);
 
        return newHead.next;
        }

}
