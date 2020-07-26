package DSA.Matrix;
/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
/**
 * Space Complexity:O(1)
 * Time Complexity:O(n*n)
 */
class Snake_Pattern
{
    //Complete this function
    //a is matrix
    static void print(int a[][], int n)
    {
        for(int i=0;i<a.length;i++){
            if(i%2==0){
                for(int j=0;j<a[i].length;j++){
                    System.out.print(a[i][j]+" ");
                } 
                continue;
            }
            else{
                for(int j=a[i].length-1;j>=0;j--){
                    System.out.print(a[i][j]+" ");
                }  
            }
        }
    }
}