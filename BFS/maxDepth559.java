package LeetCode_Mid.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class maxDepth559 {
    public int maxDepth(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!(queue.size()==0)) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
              Node curr = queue.poll();
              for(Node child:curr.children) queue.offer(child);
            }
            res++;
        }
        return res;

    }
}
