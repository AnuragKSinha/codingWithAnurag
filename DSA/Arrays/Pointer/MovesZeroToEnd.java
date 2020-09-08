package DSA.Arrays.Pointer;
/**
 * https://practice.geeksforgeeks.org/problems/move-all-zeroes-to-end-of-array/0
 * Space Complexity:O(1)
 * Time Complexity:O(n)
 */
import java.util.*;
import java.lang.*;
import java.io.*;
class MovesZeroToEnd
 {
	public static void main (String[] args)
	 {
	    Scanner scan=new Scanner(System.in);
	    int t=scan.nextInt();
	    while(t-->0){
	        int n=scan.nextInt();
	        int[] arr=new int[n];
	        for(int i=0;i<n;i++)
	            arr[i]=scan.nextInt();
	        moveZeroToEnd(arr,n);
	    }
	 }
	 public static void moveZeroToEnd(int[] arr,int n){
	     int count=0;
	     for(int i=0;i<n;i++){
	         if(arr[i]!=0){
	           arr[count++]=arr[i];
	         }
	     }
	     while(count<n){
	         arr[count++]=0;
	     }
	     for(int i=0;i<n;i++)
	        System.out.print(arr[i]+" ");
	     System.out.println();
	 }
}