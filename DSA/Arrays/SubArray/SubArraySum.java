package DSA.Arrays.SubArray;
/**
 * https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/ 
 * this array has only positive numbers
 * Space Complexity:O(1)
 * Time Complexity:(n)
 */
import java.util.*;
import java.lang.*;
import java.io.*;
class SubArraySum
 {
	public static void main (String[] args)
	 {
	    Scanner scan=new Scanner(System.in);
	    int t=scan.nextInt();
	    while(t-->0){
	        int n=scan.nextInt();
	        int S=scan.nextInt();
	        int[] arr=new int[n];
	        for(int i=0;i<n;i++){
	            arr[i]=scan.nextInt();
	        }
	        subArraySum(arr,S);
	    }
	 }
	 public static void subArraySum(int[] arr,int s){
	     int sum=0;
	     int start=0;
	    for(int i=0;i<arr.length;i++){
	        if(sum<s)
	            sum=sum+arr[i];
	        if(sum==s){
	               System.out.println((start+1)+" "+(i+1));
	               return;
	           }
	       while(sum>s){
	           sum=sum-arr[start];
	           start++;
	           if(sum==s){
	               System.out.println((start+1)+" "+(i+1));
	               return;
	           }
	       }
	    } 
	    System.out.println(-1);
	 }
}