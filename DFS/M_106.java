package LeetCode_Mid.DFS;

import java.util.HashMap;
import java.util.Map;

public class M_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> postMap = new HashMap<>();
        Map<Integer,Integer> inorderMap = new HashMap<>();
        for(int i=0;i<postorder.length;i++) {
            postMap.put(postorder[i],i);
        }
        for(int i=0;i<inorder.length;i++) {
            inorderMap.put(inorder[i],i);
        }

        return dfs(inorder,postorder,0,inorder.length-1,inorderMap.get(postorder[postorder.length-1]),postMap,inorderMap);

    }
    private TreeNode dfs(int[] inorder, int[] postorder,int left, int right,
                         int mid,Map<Integer,Integer> postorderMap,Map<Integer,Integer> inorderMap) {
        TreeNode root = new TreeNode(inorder[mid]);
        if(left==right) return new TreeNode(inorder[mid]);
        int leftMid = left;
        int rightMid = right;
        for(int i=left;i<=mid-1;i++) {
            leftMid = Math.max(leftMid,postorderMap.get(inorder[i]));
        }

        root.left = dfs(inorder,postorder,left,mid-1,
                inorderMap.get(postorder[(postorderMap.get(inorder[mid-1])+1)]),postorderMap,inorderMap);
        root.right = dfs(inorder,postorder,mid+1,right,
               inorderMap.get(postorder[postorderMap.get(inorder[mid])-1]),postorderMap,inorderMap);
        return root;
    }
}
