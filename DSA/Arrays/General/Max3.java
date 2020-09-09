package DSA.Arrays.General;
/**
 * https://practice.geeksforgeeks.org/problems/three-great-candidates/0/
 * Space Complexity:O(1)
 * Time Complexity:(n)
 */
import java.util.*;
import java.lang.*;
import java.io.*;
class Max3
 {
	public static void main (String[] args)
	 {
	    Scanner scan=new Scanner(System.in);
	    int t=scan.nextInt();
	    while(t-->0){
	        int n= scan.nextInt();
	        long arr[]=new long[n];
	        for(int i=0;i<n;i++){
	            arr[i]=scan.nextInt();
	        }
	        maxProduct(arr,n);
	    }
	 }
	 public static void maxProduct(long[] arr,int n){
	     if(n<3)
	       System.out.println(-1);
	     long maxA=Integer.MIN_VALUE;
	     long maxB=Integer.MIN_VALUE;
	     long maxC=Integer.MIN_VALUE;
	     long minA=Integer.MAX_VALUE;
	     long minB=Integer.MAX_VALUE;
	     for(int i=0;i<n;i++){
	         if(maxA<arr[i]){
	             maxC=maxB;
	             maxB=maxA;
	             maxA=arr[i];
	         }else if(maxB<arr[i]){
	             maxC=maxB;
	             maxB=arr[i];
	         }else if(maxC<arr[i])
	            maxC=arr[i];
	            
	         if(minA>arr[i]){
	             minB=minA;
	             minA=arr[i];
	         }else if(minB>arr[i])
	            minB=arr[i];
	     }
	     System.out.println(Math.max(maxA*maxB*maxC,maxA*minA*minB));
	 }
}