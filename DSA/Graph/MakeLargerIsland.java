package DSA.Graph;
/**
 * https://leetcode.com/problems/making-a-large-island
 * Time Complexity: O(N^2)
 * Space Complexity:  O(N^2)
 */
class MakingLargeIsland {
    public int largestIsland(int[][] grid) {
        int max=0;
        if(grid.length==0||grid[0].length==0)
            return max;
        boolean hasZero=false;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    grid[i][j]=1;
                    max = Math.max(max,dfs(grid,new int[grid.length][grid[0].length],i,j));
                    if(max==grid.length*grid[0].length)
                        return max;
                    grid[i][j]=0;
                    hasZero=true;
                }
            }
        }
        return hasZero?max:grid.length*grid[0].length;
    }
    private int dfs(int[][] grid,int[][] visited,int x,int y){
      if(!isValid(grid,x,y) || visited[x][y]==1)
          return 0;
        visited[x][y]=1;
        return 1+dfs(grid,visited,x+1,y)+dfs(grid,visited,x-1,y)+dfs(grid,visited,x,y+1)+dfs(grid,visited,x,y-1);
    }
    private boolean isValid(int[][] grid,int x,int y){
        if(x<0||x>=grid.length||y<0||y>=grid[0].length || grid[x][y]==0)
            return false;
        return true;
    }
  
}
