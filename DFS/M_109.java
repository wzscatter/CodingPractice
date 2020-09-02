package LeetCode_Mid.DFS;


import java.util.ArrayList;

public class M_109 {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        TreeNode res = new TreeNode(0);
        constructTree(res,head);
        return res;

    }
    private void constructTree(TreeNode root,ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = slow;
        while (fast!=null&&fast.next!=null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        root.val = slow.val;
        pre.next = null;
        if(head.next!=null) {
            constructTree(root.left,head);
        }
        if(slow.next!=null) {
            constructTree(root.right,slow.next);
        }
       
       
    }
}
