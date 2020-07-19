package DSA.Tree.BST;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * This is a BFS way of validating Binary Search Tree
 * Note: here Integer Object is used instead of Integer.MAX_VALUE and Integer.MIN_VALUE
 * because we can expect Integer.MAX_VALUE as an input and if we use it then TestCase 
 * will fail " So Integer Object is used to check that Condition " 
 * https://leetcode.com/problems/validate-binary-search-tree
 */
class ValidBinaryTree {
    public class TreeNode { 
        int val; 
        TreeNode left;
        TreeNode right;
        TreeNode() {

        }
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
              this.left= left; 
              this.right = right; } 
    }
    Solution(){
        
    }
    Integer min;
    Integer max;
    TreeNode node;
    Solution(TreeNode node,Integer min,Integer max){
        this.node=node;
        this.min=min;
        this.max=max;
    }
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        Queue<Solution> q=new LinkedList<>();
        Solution sol=new Solution(root,null,null);
        q.add(sol);
        while(!q.isEmpty()){
            Solution temp=q.poll();
            if((temp.min!=null && temp.node.val<=temp.min) || (temp.max!=null &&temp.node.val>=temp.max))
                return false;
            if(temp.node.left!=null){
                q.add(new Solution(temp.node.left,temp.min,temp.node.val));
            }
            if(temp.node.right!=null){
                q.add(new Solution(temp.node.right,temp.node.val,temp.max));
            }     
        }
        return true;
    }
}