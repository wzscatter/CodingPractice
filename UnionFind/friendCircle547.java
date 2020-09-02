package LeetCode_Mid.UnionFind;

import java.util.HashMap;
import java.util.Map;

public class friendCircle547 {
    int[] parent;
    public int findCircleNum(int[][] M) {
        this.parent = new int[M.length];
        for (int i = 0; i < M.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if(M[i][j]==1)  union(i,j);

            }
        }
        Map<Integer,Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < parent.length; i++) {
            if(!map.containsKey(find(i))) {
                map.put(find(i),i);
                result++;
            }
            continue;
        }
        return result;


    }
    private void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);
        parent[bParent] = aParent;
    }
    private int find(int a ){
        if(a!=parent[a]) {
            int lastP = parent[a];
            parent[a] = find(lastP);

        }
        return parent[a];
    }

    public static void main(String[] args) {
        friendCircle547 test = new friendCircle547();
        int[][] array = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(test.findCircleNum(array));
    }
}
