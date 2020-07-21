package DSA.Dynamic_Programming.Memorization;
/**
 * Time Complexity : O(s1.length()*s2.length())
 * As we are using a 2D matrix to store all the computed
 * values and using memorization we are cutting down 
 * the recursion, so the time complexity will also be reduced.
 * In Order to fill 2D matrix we require n*m time 
 * So in short , we are only taking time to fill up 2D matrix 
 * and that is the time required to solve LCS
 * https://leetcode.com/problems/longest-common-subsequence/
 */
public class LongestCommonSubsequence {
        private int[][] memo;
        public int longestCommonSubsequence(String text1, String text2) {
            memo = new int[text1.length()+1][text2.length()+1];
            for(int i=0;i<text1.length();i++){
                for(int j=0;j<text2.length();j++){
                    memo[i][j]=-1;
                }
            }
            return LCS(text1,text2,0,0);
        }
        public int LCS(String s1,String s2,int n,int m){
            if(memo[n][m]!=-1)
                return memo[n][m];
            if(n==s1.length() || m==s2.length()){
                memo[n][m]=0;
            }else{
                if(s1.charAt(n)==s2.charAt(m))
                    memo[n][m]=1+LCS(s1,s2,n+1,m+1);
                else
                    memo[n][m]=Math.max(LCS(s1,s2,n+1,m),LCS(s1,s2,n,m+1));
            }
             return memo[n][m];   
        }
}