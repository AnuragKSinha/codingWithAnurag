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
 * https://leetcode.com/problems/closest-binary-search-tree-value/
 * Time Complexity: O(H) - H is the height of the Tree
 * Space Complexity: O(1) - As i have considered only One Object for calculating 
 * ClosestBST
 */
class Closest_BST_Value {
    Double diff;
    int value;
    Closest_BST_Value(){
        
    }
    Closest_BST_Value(Double diff,int value){
        this.diff=diff;
        this.value=value;
    }
    public int closestValue(TreeNode root, double target) {
        Closest_BST_Value diff=new Closest_BST_Value(null,root.val);
        closestVal(root,target,diff);
        return diff.value;
    }
    public void closestVal(TreeNode root,double target,Closest_BST_Value res){
        if(root==null)
            return;
        if(root.val==target){
            res.diff=0D;
            res.value=root.val;
            return;
        } 
        else if(res.diff==null || Math.abs(root.val-target)<res.diff){
            res.diff=Math.abs(root.val-target);
            res.value=root.val;
        }
        if(root.val>target)
            closestVal(root.left,target,res);
        else if(root.val<target)
            closestVal(root.right,target,res);
    }
}