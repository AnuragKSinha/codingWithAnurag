/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**
 * https://leetcode.com/problems/path-sum/
 * Time Complexity: O(n), n is the number of node 
 * Space Complexity: O(H) H is the height of the tree
 */
class PathSum {
    boolean result;
    public boolean hasPathSum(TreeNode root, int sum) {
       return hasPath(root,0,sum);
    }
    public boolean hasPath(TreeNode root,int res,int sum){
        if(root==null)
            return false;
        res=res+root.val;
        if(root.left==null && root.right==null && res==sum) 
            return true;
        return hasPath(root.left,res,sum)||hasPath(root.right,res,sum);
    }
}