package DSA.Arrays;
/**
 * https://practice.geeksforgeeks.org/problems/leaders-in-an-array/0
 * Space Complexity:O(1); we are excluding out array and it is not required if we ditrectly 
 * print results.
 * Time Complexity:(n)
 */
import java.util.*;
import java.lang.*;
import java.io.*;
class LeaderElement
 {
	public static void main (String[] args)
	 {
	    Scanner scan=new Scanner(System.in);
	    int t=scan.nextInt();
	    while(t-->0){
	        int size=scan.nextInt();
	        int arr[]=new int[size];
	        for(int i=0;i<size;i++){
	            arr[i]=scan.nextInt();
	        }
	        leader(arr,size);
	    }
	 }
	 public static void leader(int[] arr,int n){
	     int l=arr[n-1];
	     System.out.print(l+" ");
	     for(int i=n-2;i>=0;i--){
	         if(l<arr[i]){
	             l=arr[i];
	             System.out.print(l+" ");
	         }
	     }
	     System.out.println();
	 }
}