package LeetCode_Mid.DFS;

import java.util.ArrayList;
import java.util.List;

public class M_113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<>();
        helper(root,sum,path,res);
        return res;
    }
    private void helper(TreeNode root,int target,List<Integer> path,List<List<Integer>> res) {
        if(root==null) return;

        path.add(root.val);
        if(root.left==null&&root.right==null&&target == root.val) res.add(new ArrayList<Integer>(path));

        else {
            helper(root.left,target-root.val,path,res);
            helper(root.right,target-root.val,path,res);

        }
        path.remove(path.size()-1);
    }
}
