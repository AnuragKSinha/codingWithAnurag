package DSA.Tree.Binary_Tree;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This Approch is Iterative Using Queue which is Implemented by LinkedList
 * https://leetcode.com/problems/same-tree/
 */
class SameTreeIterative {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode( int val) { this.val = val; }
        TreeNode( int val,  TreeNode left,  TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)
            return true;
        if(p==null || q==null)
            return false;
         Queue<TreeNode> q1=new LinkedList<TreeNode>();
         Queue<TreeNode> q2=new LinkedList<TreeNode>();
        q1.add(p);
        q2.add(q);
        while(!q1.isEmpty() && !q2.isEmpty()){
            final TreeNode n1=q1.poll();
            final TreeNode n2=q2.poll();
            if(n1==null && n2==null)
                continue;
            if(n1==null || n2==null)
                return false;
            if(n1.val!=n2.val)
                return false;
            q1.add(n1.left);
            q1.add(n1.right);
            q2.add(n2.left);
            q2.add(n2.right);
        }
        return true;
    }
}