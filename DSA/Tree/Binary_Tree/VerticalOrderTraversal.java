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
 * Time Complexity: O(Nlog(N/k)),where k is width of the tree
 * Space Complexity:O(N)
 */
class VerticalOrderTraversal {
    VerticalOrderTraversal(){
        
    }
    int col;
    TreeNode node;
    int row;
    VerticalOrderTraversal(TreeNode node,int row,int col){
        this.node=node;
        this.row=row;
        this.col=col;
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        Map<Integer,ArrayList<VerticalOrderTraversal>> level=new HashMap<Integer,ArrayList<VerticalOrderTraversal>>();
        int start=0;
        int end=0;
        Queue<VerticalOrderTraversal> q=new LinkedList<VerticalOrderTraversal>();
        q.add(new VerticalOrderTraversal(root,0,0));
        while(!q.isEmpty()){
            VerticalOrderTraversal sol=q.poll();
            start=Math.min(start,sol.col);
            end=Math.max(end,sol.col);
            if(sol.node.left!=null)
                q.add(new VerticalOrderTraversal(sol.node.left,sol.row+1,sol.col-1));
            if(sol.node.right!=null)
                q.add(new VerticalOrderTraversal(sol.node.right,sol.row+1,sol.col+1));

            if(level.containsKey(sol.col)){
                List<VerticalOrderTraversal> list=level.get(sol.col);
                list.add(sol);
            }else{
                ArrayList<VerticalOrderTraversal> list=new ArrayList<VerticalOrderTraversal>();
                list.add(sol);
                level.put(sol.col,list);
            }
        }
        List<List<Integer>> output=new ArrayList<>();
        for(int i=start;i<=end;i++){
            ArrayList<VerticalOrderTraversal> res=level.get(i);
            Collections.sort(res,new Comparator<VerticalOrderTraversal>(){
                @Override
                public int compare(VerticalOrderTraversal p1,VerticalOrderTraversal p2){
                    if(p1.row==p2.row)
                        return p1.node.val-p2.node.val;
                    else
                        return p1.row-p2.row;
                }
            });
            List<Integer> sortedCol=new ArrayList<Integer>();
            for(VerticalOrderTraversal s:res){
                sortedCol.add(s.node.val);
            }
            output.add(sortedCol);
        }
        return output;
    }
}