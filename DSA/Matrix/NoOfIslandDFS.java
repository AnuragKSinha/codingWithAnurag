package DSA.Matrix;
/**
 * https://leetcode.com/problems/number-of-islands/
 * Space Complexity : O(n*m): as we are using internal stack which is used in recursion
 * Time Complexity : O(n*m)
 * we are entering each cell 2 times
 */
class NoOfIslandDFS {
    public int numIslands(char[][] grid) {
        if(grid.length==0||grid[0].length==0)
            return 0;
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid,int x,int y){
        if(x>=grid.length||x<0||y>=grid[0].length||y<0||grid[x][y]=='0')
            return;
        grid[x][y]='0';
        dfs(grid,x-1,y);
        dfs(grid,x+1,y);
        dfs(grid,x,y-1);
        dfs(grid,x,y+1);
    }
}