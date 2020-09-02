package LeetCode_Mid.DFS;

public class E_101_symmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        else return (left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left));
    }

    public boolean isMirror(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if (left == null || right == null) return false;
        else
            return (left.val == right.val) && helper(left.left, right.right) && helper(left.right, right.left);


    }
}
