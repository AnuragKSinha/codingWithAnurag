package DSA.Recursion;
/**
 * This Solution is a naive Solution 
 * and Time Complexity is 0(3^(n+m))
 * n and m are the size of the Arrays
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray
 * Will coming up with memorization on this Solution and also Bottom Up Solution 
 * for this Question
 */

public class LongestCommonSubString {
    int max=0;
    public int findLength(int[] A, int[] B) {
        lcsCount(A,B,0,0,0);
        return max;
    }
    void lcsCount(int[] A,int[] B,int n,int m,int c){
        if(n>A.length-1 || m>B.length-1)
            return;
        if(A[n]==B[m]){
            c=c+1;
           max=Math.max(max,c);
           lcsCount(A,B,n+1,m+1,c);
        }
            lcsCount(A,B,n+1,m,0);
            lcsCount(A,B,n,m+1,0);
    }
}