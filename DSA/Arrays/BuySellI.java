package DSA.Arrays;
/**
 * https://practice.geeksforgeeks.org/problems/stock-buy-and-sell/0
 * Space Complexity:O(1)
 * Time Complexity:(n)
 */
import java.util.*;
import java.lang.*;
import java.io.*;
class BuySellI
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
	        buySell(arr,n);
	    }
	 }
	 
	 public static void buySell(int[] arr,int n){
	     int min=0;
	     int max=0;
	     int profit=0;
	     for(int i=1;i<n;i++){
	         if(arr[max]<arr[i])
	                max=i;
	         else{
	             int sum=arr[max]-arr[min];
	             if(sum>0){
	                 profit+=sum;
	                 System.out.print("("+min+" "+max+") ");
	             }
	             max=i;
	             min=i;
	         }
	     }
	     int sum=arr[max]-arr[min];
	     if(sum>0){
	                 profit+=sum;
	                 System.out.print("("+min+" "+max+") ");
	     }
	     if(profit==0)
	        System.out.print("No Profit");
	     System.out.println();
	 }
}