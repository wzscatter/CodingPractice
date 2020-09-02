package LeetCode_Mid.DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VIPM_133 {
    private HashMap<Integer, Node> map = new HashMap<>();
    public Node copy(Node node) {
        if(node==null) return null;
        return helper(node);
    }
    private Node helper(Node node) {
        if(node==null) return null;
        if(map.containsKey(node.val)) {
            return map.get(node.val);
        }
        Node newNode = new Node(node.val,new ArrayList<Node>());
        map.put(node.val,newNode);
        for(Node temp:node.neighbors) {
            newNode.neighbors.add(helper(temp));
        }

        return newNode;
    }

}
