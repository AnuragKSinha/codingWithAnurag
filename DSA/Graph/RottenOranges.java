package DSA.Graph;
/**
 * https://leetcode.com/problems/rotting-oranges/
 * Space Complexity: O(R*C)
 * Time Complexity: O(R*C) 
 */
class RottenOranges {
    RottenOranges(){
        
    }
    int x;
    int y;
    int dis;
    int[] xCo={0,1,0,-1};
    int[] yCo={1,0,-1,0};
    RottenOranges(int x,int y,int dis){
        this.x=x;
        this.y=y;
        this.dis=dis;
    }
    public int orangesRotting(int[][] grid) {
        if(grid.length==0|| grid[0].length==0)
             return 0;
        int res=-1;
        Queue<RottenOranges> queue=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.add(new RottenOranges(i,j,0));
                }
            }
        }
        res=bfs(queue,grid);
         for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return res;
    }
    public int bfs(Queue<RottenOranges> queue,int[][] grid){
        int result=0;
        while(!queue.isEmpty()){
            RottenOranges sol=queue.poll();
            result=Math.max(result,sol.dis);
            for(int i=0;i<xCo.length;i++){
                int xdir=sol.x+xCo[i];
                int ydir=sol.y+yCo[i];
                if(isValid(xdir,ydir,grid) && grid[xdir][ydir]==1){
                    grid[xdir][ydir]=2;
                    queue.add(new RottenOranges(xdir,ydir,sol.dis+1));
                }                          
            }
        }
        return result;
    }
    public boolean isValid(int x,int y,int[][] grid){
        if(x<0||x>=grid.length||y<0||y>=grid[0].length||grid[x][y]==0)
            return false;
        return true;
    }
}