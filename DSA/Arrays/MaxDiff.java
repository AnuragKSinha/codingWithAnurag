package DSA.Arrays;
/**
 * https://practice.geeksforgeeks.org/problems/maximum-difference/0
 * Space Complexity:O(1)
 * Time Complexity:(n)
 */
import java.util.*;
import java.lang.*;
import java.io.*;
class MaxDiff
 {
	public static void main (String[] args)
	 {
	     Scanner scan=new Scanner(System.in);
	     int t=scan.nextInt();
	     while(t-->0){
	         int n=scan.nextInt();
	         int[] arr=new int[n];
	         for(int i=0;i<n;i++){
	             arr[i]=scan.nextInt();
	         }
	         maxDiff(arr);
	     }
	 }
	 public static void maxDiff(int[] arr){
	     int n=arr.length;
	     int min=arr[0];
	     Integer maxVal=null;
	     for(int i=1;i<arr.length;i++){
	       if(maxVal!=null)
	           maxVal=Math.max(maxVal,arr[i]-min);
	       else
	           maxVal= arr[i]-min;
	       min=Math.min(min,arr[i]);
	     }
	     System.out.println(maxVal);
	 }
}