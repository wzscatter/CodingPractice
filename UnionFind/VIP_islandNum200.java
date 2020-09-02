package LeetCode_Mid.UnionFind;

import java.util.HashMap;
import java.util.Map;

public class VIP_islandNum200 {
    int [] unionSet;
    boolean [] isIsland;
    public int numIslands(char[][] grid) {
        int width = grid[0].length;
        int height = grid.length;
        this.unionSet = new int[width*height];
        this.isIsland = new boolean[width*height];
        for(int i =0;i<height;i++) {
            for(int j =0;j<width;j++) {
                unionSet[i*width+j] = i*width+j;

            }
        }
        for(int i = 0;i<width*height;i++) {
            int x = i/width;
            int y = i%width;
            if(grid[x][y]=='1') {

                if(x-1>=0&&grid[x-1][y]=='1') union(i,i-width);
                if(y+1<width&&grid[x][y+1]=='1') union(i,i+1);
                System.out.printf("i=%d,parent = %d%n",i,unionSet[i]);
                isIsland[i] = true;
            }
        }
        int result = 0;
       Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < width*height; i++) {
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
    private void union(int a,int b ){
        int tempA = findParent(a,unionSet);
        int tempB = findParent(b,unionSet);
        unionSet[tempB] = tempA;

    }
    private int findParent(int a, int[] unionSet) {
       if(unionSet[a]==a) return a;
       else {
            unionSet[a] = findParent(unionSet[a],unionSet);
            return unionSet[a];
        }
    }

    public static void main(String[] args) {
        VIP_islandNum200 test= new VIP_islandNum200();
        char[][] map = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'}};
        System.out.println(test.numIslands(map));
    }
}
