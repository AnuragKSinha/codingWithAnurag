package DSA.Tree.Binary_Tree;
/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * Time Complexity:O(n),n is the total number of node
 * Space Complexity:O(h), h is the height of the Binary Tree
 */
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
class FlattenBTToLL {
    TreeNode last=null;
    public void flatten(TreeNode root) {
        if(root==null)
            return;
        flatten(root.right);
        flatten(root.left);
        if(last!=null){
            root.right=last;
            root.left=null;
            last=root;
        }else{
            last=root;
        }
    }
}