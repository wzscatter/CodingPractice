package LeetCode_Mid.UnionFind;

import java.util.HashMap;
import java.util.Map;

public class my200 {
    private int[] unionSet;
    private boolean[] isIsland;
    int result =0;

    public int numIslands(char[][] grid) {
        int size = grid.length*grid[0].length;
        Map<Integer,Integer> map = new HashMap<>();
        unionSet = new int[size];
        isIsland = new boolean[size];
        for (int i = 0; i < size; i++) {
            unionSet[i] = i;
        }
        for (int i = 0; i < size; i++) {
            int row = i/grid[0].length;
            for (int j = 0; j < grid[0].length; j++) {
                int col = i%grid[0].length;
                if(grid[row][col]==1) {
                    if(row-1>=0&&grid[row-1][col]==1) union(i-grid[0].length,i);
                    if(col+1<grid[0].length&&grid[row][col+1]==1) union(i,i+1);
                    isIsland[i]=true;

                }
            }
        }
        for (int i = 0; i < size; i++) {
            if(isIsland[i]) {
//                System.out.printf("i=%d,parent = %d%n",i,unionSet[i]);
                map.put(findParent(i,unionSet),map.getOrDefault(i,0)+1);
            }
        }
        for(Integer i:map.keySet()) {
//            System.out.println(i);
            result++;
        }
        return result;



    }
    private void union(int a, int b) {
        int tempA = findParent(a,unionSet);
        int tempB = findParent(b,unionSet);
        unionSet[tempB] = tempA;
    }
    private int findParent(int i, int[] unionSet) {
        if(i== unionSet[i]) return i;
        else {
            unionSet[i] = findParent(unionSet[i],unionSet);
        }
        return unionSet[i];
    }
    private void myUnion(int a, int b) {
        int tempA = myFindParent(a,unionSet);
        int tempB = myFindParent(b,unionSet);
        unionSet[tempB] = tempA;

    }

    private int myFindParent(int a ,int[] parents) {
        if(a==parents[a]) return a;
        else {
            parents[a] = myFindParent(parents[a],parents);

        }
        return parents[a];

    }

    public int numOfIsland(char[][] grid) {
        int size = grid.length*grid[0].length;
        unionSet = new int[size];
        boolean[] isIsland = new boolean[size];
        for(int i=0;i<size;i++) {
            unionSet[i] = i;
        }
        for(int i =0;i<size;i++) {
            int row = i/grid[0].length;
            for(int j = 0;j<grid[0].length;j++ ){
                int col = i%grid[0].length;
                if(grid[row][col]=='1') {
                    if(row-1>=0&&grid[row-1][col]=='1') myUnion(i-grid[0].length,i);
                    if(col+1<grid[0].length&&grid[row][col+1]=='1') myUnion(i,i+1);
                    isIsland[i]=true;
                }
            }
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<size;i++) {
            if(isIsland[i]) map.put(unionSet[i],map.getOrDefault(unionSet[i],0)+1);
        }
        int res =0;
        for(int key:map.keySet()) {
            res++;
        }
        return res;
    }
}
