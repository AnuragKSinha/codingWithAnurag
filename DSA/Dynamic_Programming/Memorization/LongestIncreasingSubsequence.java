package DSA.Dynamic_Programming.Memorization;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0)
            return 0;
       int dp[]=new int[nums.length];
        dp[0]=1;
        int res=1;
        for(int i=1;i<nums.length;i++){
            int max=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    max=Math.max(max,dp[j]+1);
                }
            }
            dp[i]=max;
            res=Math.max(res,dp[i]);
        }
        return res;
    }
}