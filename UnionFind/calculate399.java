package LeetCode_Mid.UnionFind;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class calculate399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        // map string to integer
        Map<String, Integer> mIdTable = new HashMap<>();
        int len = 0;
        for (List<String> words : equations)
            for (String word : words)
                if (!mIdTable.containsKey(word)) mIdTable.put(word, len++);

        // init parent index and value
        Node[] nodes = new Node[len];
        for (int i = 0; i < len; ++i) nodes[i] = new Node(i);

        // union, you can take an example as follows
        // (a/b=3)->(c/d=6)->(b/d=12)
        for (int i = 0; i < equations.size(); ++i) {
            List<String> keys = equations.get(i);
            int k1 = mIdTable.get(keys.get(0));
            int k2 = mIdTable.get(keys.get(1));
            int groupHead1 = find(nodes, k1);
            int groupHead2 = find(nodes, k2);
            nodes[groupHead2].parent = groupHead1;
            nodes[groupHead2].value = nodes[k1].value * values[i] / nodes[k2].value;
        }

        // queries now
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); ++i) {
            Integer k1 = mIdTable.get(queries.get(i).get(0));
            Integer k2 = mIdTable.get(queries.get(i).get(1));
            if (k1 == null || k2 == null) result[i] = -1d;
            else {
                int groupHead1 = find(nodes, k1);
                int groupHead2 = find(nodes, k2);
                if (groupHead1 != groupHead2) result[i] = -1d;
                else result[i] = nodes[k2].value / nodes[k1].value;
            }
        }
        return result;
    }

    public int find(Node[] nodes, int k) {
        int p = k;
        while (nodes[p].parent != p) {
            p = nodes[p].parent;
            // compress
            nodes[k].value *= nodes[p].value;
        }
        // compress
        nodes[k].parent = p;
        return p;
    }

    private static class Node {
        int    parent;
        double value;

        public Node(int index) {
            this.parent = index;
            this.value = 1d;
        }
    }
}
