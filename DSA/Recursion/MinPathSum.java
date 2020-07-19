import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-path-sum/ This Solution is Recursive
 * Solution With Memorization;
 * Please refer to DP folder to get a bottom up Approach to solve this Question 
 * 
 */
class MinPathSum {
    public int minPathSum(int[][] grid) {
        if(grid.length==0)
            return 0;
        return minSumPath(grid,0,0);
    }
    Map<String,Integer> map=new HashMap<String,Integer>();
    public int minSumPath(int[][] grid,int x,int y){
        if(x>=grid.length||y>=grid[0].length)
            return Integer.MAX_VALUE;
        if(map.containsKey(x+" "+y))
            return map.get(x+" "+y);
        int a=minSumPath(grid,x+1,y);
        int b=minSumPath(grid,x,y+1);
        int val=grid[x][y]+ (Math.min(a,b)==Integer.MAX_VALUE?0:Math.min(a,b));
        map.put(x+" "+y,val);
        return val;
    }
}
