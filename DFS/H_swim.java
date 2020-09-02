package LeetCode_Mid.DFS;

import java.util.HashSet;
import java.util.Set;

public class H_swim {
    public int swimInWater(int[][] grid) {
        Set<Integer> map = new HashSet<>();
        int n = grid.length;
        int m = grid[0].length;
        int time = -1;
        while (!map.contains(n*m-1)){
            time++;
            map.clear();
            dfs(grid,0,0,map,time);

        }
        return time;

    }
    private void dfs(int[][] grid,int i,int j, Set<Integer> map,int time){
        if(i<0||j<0||i>grid.length-1||j>grid[0].length-1||grid[i][j]>time ||map.contains(i*grid.length+j)) return;
        int len = grid[0].length;
        map.add(i*len+j);
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        for(int[] oneDir:dir) {
            dfs(grid,i+oneDir[0],j+oneDir[1],map,time);
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1,2,3},
                {2,1,5},
                {3,2,3}};
        H_swim test = new H_swim();
        System.out.println(test.swimInWater(grid));
    }
}