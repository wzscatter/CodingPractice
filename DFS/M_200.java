package LeetCode_Mid.DFS;

import java.util.HashSet;
import java.util.Set;

public class M_200 {
    int [] parent ;
    public int numIslands(char[][] grid) {
        int size = grid.length*grid.length;
        boolean[] isIsland = new boolean[size];
        Set<Integer> set = new HashSet<>();
        parent = new int[size];
        for(int i =0;i<size;i++) {
            parent[i] = i;
        }
        for(int i =0;i<size;i++) {
            int row = i/grid[0].length;
            int col = i%grid[0].length;
            if(grid[row][col]=='1') {
                if(row-1>=0&&grid[row-1][col]=='1') union(i-grid[0].length,i);
                if(col+1<grid[0].length&&grid[row][col+1]=='1') union(i,i+1);
                isIsland[i]=true;
            }

        }
        for(int i =0;i<size;i++) {
            if(isIsland[i]) {
                int p = findParent(i,parent);
                if(!set.contains(p)) set.add(p);
            }
        }
        return set.size();

    }

    private void union(int a , int b ) {
        int aParent = findParent(a,parent);
        int bParent = findParent(b,parent);
        parent[bParent] = aParent;
    }
    private int findParent (int num,int[] parent) {

        if(parent[num]==num) return num;
        else {
            parent[num] = findParent(parent[num],parent);
            return parent[num];
        }


    }
}
