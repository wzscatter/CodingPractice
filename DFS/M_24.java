package LeetCode_Mid.DFS;

public class M_24 {
    public ListNode swapPairs(ListNode head) {
        return dfs(head);
    }
    private ListNode dfs(ListNode root) {
        if(root==null||root.next==null) return root;
        ListNode dummy = new ListNode(-1);
        ListNode follower = dfs(root.next.next);
        dummy.next = root.next;
        root.next.next = root;
        root.next = follower;
        return dummy.next;

    }
}
