package DSA.Recursion;
/**
 * https://leetcode.com/problems/validate-binary-search-tree
 * Note: Integer Object is used instead of Integer.MAX_VALUE and 
 * Integer.MIN_VALUE for a purpose
 * Please Mark that reason and use it in future as it is one 
 * of the ways and helps in passing the use case where input can be
 * Integer.MAX_VALUE or Integer.MIN_VALUE
 */
public class ValidBinaryTree {
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(TreeNode left,TreeNode right,int val){
            this.left=left;
            this.right=right;
            this.val=val;
        }
        TreeNode(int val){
            this.val;
        }
    }
    public boolean isValidBST(TreeNode root) {
            return isValid(root,null,null);
        }
        public boolean isValid(TreeNode root,Integer min,Integer max){
            if(root==null)
                return true;
            if((min!=null && root.val<=min) || (max!=null && root.val>=max))
                return false;
            return isValid(root.left,min,root.val) && isValid(root.right,root.val,max);
        }
}