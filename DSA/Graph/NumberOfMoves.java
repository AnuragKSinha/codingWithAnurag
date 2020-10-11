package DSA.Graph;
import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * Time Complexity:O(n^2)  ---> as we are moving in all the cells one time in worst case :
 *  (9x9)--> all cells are visited one time
 * Space Complexity:O(n^2) --> we are using a visited Set to keep the record of all the cell visted 
 * and We are also using Queue which can take less than n^2 space at max so total space complexity is n^2
 */
 
/* Name of the class has to be "Main" only if the class is public. */
class NumberOfMoves
{
    NumberOfMoves(){}
 
    static int xCo[]={-2,-2,-1,-1,1,1,2,2};
    static int yCo[]={-1,1,2,-2,2,-2,-1,1};
    int x;int y;int dis;
    NumberOfMoves(int x,int y,int dis){
      this.x=x;
      this.y=y;
      this.dis=dis;
    }
	static int noOfMoves(int[][] grid, int sr, int sc, int tr, int tc) {
			if(grid.length==0)
        		return -1;
           if(sr==tr && sc==tc)
               return 0;
    	Queue<NumberOfMoves> q=new LinkedList<NumberOfMoves>();
    	Set<String> visited=new HashSet<String>();
   		 q.add(new NumberOfMoves(sr,sc,0));
    	while(!q.isEmpty()){
            NumberOfMoves sol=q.poll();
     		 if(sol.x==tr && sol.y==tc)
        		return sol.dis;
             for(int i=0;i<xCo.length;i++){
        		int x=sol.x+xCo[i];
       		    int y=sol.y+yCo[i];
        	if(check(grid,x,y) && !visited.contains(x+" "+y)){
         		 visited.add(x+" "+y);
         		 q.add(new NumberOfMoves(x,y,sol.dis+1));
       	 		}
     	 	}
    	}
    	return -1;
	}
  	public static boolean check(int[][] grid,int i,int j){
  		  if(i<0||j<0||i>=grid.length||j>=grid[0].length)
   			   return false;
  		  return true;
  	}
 
	public static void main(String[] args) {
	   			 int grid[][]=new int[9][9];
      				System.out.println("Minimun Number of moves:"+noOfMoves(grid,4,4,4,8));
		}
}