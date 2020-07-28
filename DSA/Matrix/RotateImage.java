package DSA.Matrix;
/**
 * https://leetcode.com/problems/rotate-image/
 * Space Complexity : O(1)
 * Time Complexity : O(n*n)
 */
class RotateImage {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        replaceColumn(matrix);
    }
    public void transpose(int[][] matrix){
        int temp=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix[0].length;j++){
                temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }
    public void replaceColumn(int[][] matrix){
        int column=0;
        int columnEnd=matrix[0].length-1;
        int row=0;
        int rowEnd=matrix.length-1;
        int temp=0;
        while(column<columnEnd){
            for(int i=row;i<=rowEnd;i++){
                temp=matrix[i][column];
                matrix[i][column]=matrix[i][columnEnd];
                matrix[i][columnEnd]=temp;
            }
            column++;
            columnEnd--;
        }
    }
}