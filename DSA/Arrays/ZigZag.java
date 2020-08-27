package DSA.Arrays;
/**
 * https://practice.geeksforgeeks.org/problems/convert-array-into-zig-zag-fashion/
 * Space Complexity:O(1); 
 * Time Complexity:(n)
 */
import java.util.*;
import java.lang.*;
import java.io.*;

class ZigZag {
	public static void main (String[] args) {
		Scanner scan=new Scanner(System.in);
		int t=scan.nextInt();
		while(t-->0){
		    int len=scan.nextInt();
		    int arr[]=new int[len];
		    for(int i=0;i<len;i++){
		        arr[i]=scan.nextInt();
		    }
		   arr=zigzag(arr);
		   for(int i:arr)
		    System.out.print(i+" ");
		   System.out.println();
		}
	}
	public static int[] zigzag(int arr[]){
	    boolean flag=true;
	    for(int i=1;i<arr.length;i++){
	        if(flag){
	            if(arr[i-1]>arr[i]){
	                int temp=arr[i-1];
	                arr[i-1]=arr[i];
	                arr[i]=temp;
	            }
	        }else{
	            if(arr[i-1]<arr[i]){
	                int temp=arr[i-1];
	                arr[i-1]=arr[i];
	                arr[i]=temp;
	            }
	        }
	        flag=!flag;
	    }
	    return arr;
	}
}