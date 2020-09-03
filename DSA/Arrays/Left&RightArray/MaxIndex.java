package DSA.Arrays.Left&RightArray;
/**
 * https://practice.geeksforgeeks.org/problems/maximum-index/0
 * Space Complexity:O(n)
 * Time Complexity:(n)
 */
import java.util.*;
import java.lang.*;
import java.io.*;
class MaxIndex
 {
	public static void main (String[] args)
	 {
	    Scanner scan=new Scanner(System.in);
	    int t= scan.nextInt();
	    while(t-->0){
	        int n= scan.nextInt();
	        int[] arr=new int[n];
	        for(int i=0;i<n;i++){
	            arr[i]=scan.nextInt();
	        }
	        maxDiff(arr);
	    }
	 }
/**	 
*     34 8  10 3  2  80 30 33  1
*left 34 8  8  3  2  2  2  2   1
*rt   80 80 80 80 80 80 33 33  1
**/
public static void maxDiff(int[] arr){
	     int[] left=new int[arr.length];
	     int[] right=new int[arr.length];
	     int n=arr.length;
	     left[0]=arr[0];
	     for(int i=1;i<arr.length;i++)
	        left[i]=Math.min(left[i-1],arr[i]);
	     right[n-1]=arr[n-1];
	     for(int i=n-2;i>=0;i--)
	        right[i]=Math.max(right[i+1],arr[i]);
	        int i=0;
	        int j=0;
	     int maxDiff=Integer.MIN_VALUE;
	     while(i<n && j<n){
	         if(left[i]<=right[j]){
	             maxDiff=Math.max(maxDiff,(j-i));
	             j++;
	         }else
	            i++;
	     }
	     System.out.println(maxDiff==Integer.MIN_VALUE?0:maxDiff);
	 }
}