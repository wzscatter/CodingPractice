package LeetCode_Mid.DFS;

import java.util.HashSet;
import java.util.Set;

public class E_112 {
    Set<Integer> set = new HashSet<>();
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        dfs(root,0);
        return set.contains(sum);
    }
    private void dfs(TreeNode root, int sum) {
          if(root.left==null&&root.right==null) {
              set.add(sum+root.val);
          }
          if(root.left!=null) {
              dfs(root.left,sum+root.val);
          }
          if(root.right!=null) {
              dfs(root.right,sum+root.val);
          }
    }
}
