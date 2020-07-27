package DSA.Matrix;

import java.util.ArrayList;
import java.util.List;
/**
 * https://leetcode.com/problems/spiral-matrix/
 * Time Complexity: O(n*m)
 * Space Complexity: O(1) 
 * Note: Not considering the output array in space complexity
 * as we can remove it and directly print result in the console
 */
class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0)
            return new ArrayList<Integer>();
        List<Integer> output=new ArrayList<Integer>();
        int t=0;
        int b=matrix.length-1;
        int l=0;
        int r=matrix[0].length-1;
        int dir=0;
        while(l<=r && t<=b){
           if(dir==0){
              for(int i=l;i<=r;i++)
                output.add(matrix[t][i]);
              t++; 
           } 
           else if(dir==1){
                for(int i=t;i<=b;i++)
                    output.add(matrix[i][r]);
                r--;
            }
            else if(dir==2){
                 for(int i=r;i>=l;i--)
                    output.add(matrix[b][i]);
                b--;
            }
            else if(dir==3){
                for(int i=b;i>=t;i--)
                    output.add(matrix[i][l]);
                l++;
            }
           dir=(dir+1)%4;
        }
        return output;
    }
}