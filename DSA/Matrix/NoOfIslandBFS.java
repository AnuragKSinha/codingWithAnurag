package DSA.Matrix;
/**
 * https://leetcode.com/problems/number-of-islands/
 * Space Complexity : O(n*m): as we are using queue to store cordinates
 * of matrix
 * Time Complexity : O(n*m)
 * we are entering each cell 2 times
 */
class NoOfIslandBFS {
    NoOfIslandBFS(){
        
    }
    int x;
    int y;
    int xCo[]={1,0,-1,0};
    int yCo[]={0,1,0,-1};
    NoOfIslandBFS(int x,int y){
        this.x=x;
        this.y=y;
    }
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0)
            return 0;
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    grid[i][j]='0';
                    bfs(grid,i,j);
                }
            }
        }
        return count;
    }
    public void bfs(char[][] grid,int i,int j){
        Queue<NoOfIslandBFS> q=new LinkedList<NoOfIslandBFS>();
        q.add(new NoOfIslandBFS(i,j));
        while(!q.isEmpty()){
            NoOfIslandBFS sol=q.poll();
            for(int l=0;l<xCo.length;l++){
                int xo=sol.x+xCo[l];
                int yo=sol.y+yCo[l];
                if(check(grid,xo,yo)){
                    grid[xo][yo]='0';
                    q.add(new NoOfIslandBFS(xo,yo));
                }
            }
        }
    }
    public boolean check(char[][] grid,int x,int y){
        if(x<0||y<0||x>=grid.length||y>=grid[0].length||grid[x][y]=='0')
            return false;
        return true;
    }
}