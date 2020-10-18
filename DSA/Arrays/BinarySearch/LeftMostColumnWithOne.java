package DSA.Arrays.BinarySearch;
/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */
/**
 * https://leetcode.com/problems/leftmost-column-with-at-least-a-one/
 * Time Complexity:O(rows*log(column))
 * Space Complexity: O(1)
 */

class LeftMostColumnWithOne {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimension=binaryMatrix.dimensions();
        int row=dimension.get(0);
        int column=dimension.get(1);
        int res=column;
        for(int i=0;i<row;i++){
           int in=binarySearch(i,0,column-1,binaryMatrix);
            if(in!=-1)
                res=Math.min(res,in);
        }
        return res==column?-1:res;
    }
    public Integer binarySearch(int rownum,int l,int r,BinaryMatrix binaryMatrix){
       int res=-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(binaryMatrix.get(rownum,mid)==0)
                l=mid+1;
            else{
                res=mid;
                r=mid-1;
            }    
        }
        return res;
    }
}