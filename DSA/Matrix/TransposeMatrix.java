package DSA.Matrix;
/**
 * We cannot do a inplace Transpose of
 * a matrix if the matrix is n*m and
 * n != m
 * Space Complexity: O(n*m)
 * Time Complexity : O(n*m)
 */
class TransposeMatrix {
    public int[][] transpose(int[][] A) {
        int r=A.length;
        int c=A[0].length;
        int ans[][]=new int[c][r];
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[i].length;j++){
               ans[j][i]=A[i][j];
            }
        }
        return ans;
    }
}