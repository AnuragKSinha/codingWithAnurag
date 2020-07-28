package DSA.Matrix;
/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 * Space Complexity : O(1)
 * Time Complexity : O(n+log(m))
 */
class RowWiseAndColumnWiseSorted {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0)
            return false;
        int row=0;
        int rowEnd=matrix.length-1;
        int column=0;
        int columnEnd=matrix[0].length-1;
        int loc=-1;
        for(int i=0;i<=rowEnd;i++){
            if(target>=matrix[i][column] && target<=matrix[i][columnEnd]){
                loc=i;
                break;
            }  
        }
        if(loc==-1)
            return false;
        return binarySearch(matrix[loc],column,columnEnd,target);
    }
    public boolean binarySearch(int[] arr,int l,int r,int target){
        while(l<=r){
            int mid=l+((r-l)/2);
            if(arr[mid]==target)
                return true;
            if(arr[mid]>target)
                r=mid-1;
            else if(arr[mid]<target)
                l=mid+1;
        }
        return false;
    }
}