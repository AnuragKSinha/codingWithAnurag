package DSA.Tree.Binary_Tree;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Recursive Solution:
 * Time Complexity:O(n) , n is the total no of nodes
 * Space Complexity:O(h) h is the height of the tree
 */

class LCAforBST {
    public TreeNode lowestCommonAncestorRec(TreeNode root, TreeNode p, TreeNode q) {
         if(root==null)
             return root;
        int parent=root.val;
        if(parent>p.val && parent>q.val)
           return lowestCommonAncestorRec(root.left,p,q);
        else if(parent<p.val && parent<q.val)
           return lowestCommonAncestorRec(root.right,p,q);
        else 
            return root;
    }
    public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca=root;
            while(lca!=null){
                int parent=lca.val;
                if(parent>p.val && parent>q.val)
                    lca=lca.left;
                else if(parent<p.val && parent<q.val)
                    lca=lca.right;
                else
                    break;
            }
            return lca;
   }

}