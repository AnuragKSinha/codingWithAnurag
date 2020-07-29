package DSA.Matrix;
import java.io.*;
/**
 * Space Complexity:O(n*m)
 * Time Complexity:O(n*m)
 * https://www.geeksforgeeks.org/print-matrix-reverse-wave-form/
 */
class WavePrint {
	 public static void main (String[] args)  
    { 
        int arr[][] = { { 1, 2, 3, 4 }, 
                    { 5, 6, 7, 8 }, 
                    { 9, 10, 11, 12 }, 
                    { 13, 14, 15, 16 } };              
        WavePrint(arr);    
      
    } 
    public static void WavePrint(int[][] arr){
        int l=0;
        int r=arr.length-1;
        int dir=0;
        for(int i=arr.length-1;i>=l;i--){
            if(dir==0){
                for(int j=0;j<arr[0].length;j++)
                    System.out.print(arr[j][i]+" ");
            }else if(dir==1){
                for(int j=arr[0].length-1;j>=0;j--)
                    System.out.print(arr[j][i]+" ");
            }
            dir=(dir+1)%2;
        }
    }
}