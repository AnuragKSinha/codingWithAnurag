package DSA.Dynamic_Programming.Memorization;
/**
 * This is a memorization solution over 
 * simple recursion solution
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/
 * TimeComplexity: O(n*m*max(n,m))
 * SpaceComplexity:O(n*m*max(n,m))
 */
public class LongestCommonSubString {
        Integer[][][] memo;
        public int findLength(int[] A, int[] B) {
            int count=0;
            if(A.length>B.length)
                count=A.length;
            else
                count=B.length;
            memo=new Integer[A.length+1][B.length+1][count+1];
            return LCS(A,B,0,0,0);
        }
        int LCS(int[] A,int[] B,int n,int m,int count){
            if(n>=A.length || m>=B.length){
                return count;
            }
            if(memo[n][m][count]!=null)
                return memo[n][m][count];
            int s=count;
            if(A[n]==B[m]){
               s=LCS(A,B,n+1,m+1,count+1);
            }
            int l=LCS(A,B,n+1,m,0);
            int r=LCS(A,B,n,m+1,0);
            memo[n][m][count]=Math.max(s,Math.max(l,r));
            return memo[n][m][count];
        }
}