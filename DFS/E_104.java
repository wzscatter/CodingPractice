package LeetCode_Mid.DFS;

public class E_104 {
    public int maxDepth(TreeNode root) {
        return dive(root,0);
    }
    private int dive(TreeNode root, int curNum) {
        if(root==null) return curNum;
        if(root.left!=null&&root.right!=null) {
            return Math.max(dive(root.left,curNum+1),dive(root.right,curNum+1));
        }
        if(root.left!=null) return dive(root.left,curNum+1);
        return dive(root.right,curNum+1);

    }
}
