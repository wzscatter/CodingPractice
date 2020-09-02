package LeetCode_Mid.DFS;

public class M_1302_deepestLeafSum {
    public int deepestLeavesSum(TreeNode root) {
        int depth = getDepth(root);
        return getSumAtLevel(root,depth);
    }
    private int getDepth(TreeNode root) {
        if(root==null) return 0;
        return 1+Math.max(getDepth(root.left),getDepth(root.right));
    }
    private int getSumAtLevel(TreeNode root, int level){
        if(root==null) return 0;
        if(level==1) return root.val;
        return getSumAtLevel(root.left,level-1)+getSumAtLevel(root.right,level-1);
    }
}
