package LeetCode_Mid.DFS;

public class E_100 {
    public boolean isSameTree(TreeNode left,TreeNode right) {
        return helper(left,right);
    }
    private boolean helper(TreeNode left, TreeNode right) {
        if(left==null&&right == null) return true;
        else if(left==null||right ==null) {
            return false;
        }
        else return (left.val==right.val&&helper(left.left,right.left)&&helper(left.right,right.right));
    }
}
