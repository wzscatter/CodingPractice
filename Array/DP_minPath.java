package LeetCode_Mid.Array;

public class DP_minPath {
    public static int minPath(int [][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        return helper(grid,height-1,width-1);
    }
    public static int helper(int [][] grid,int col,int row) {
        if(col==0&&row==0) return grid[row][col];
        if(col==0) return helper(grid,col,row-1);
        if(row ==0)return helper(grid,col-1,row);
        return Math.min(helper(grid,col-1,row),helper(grid,col,row-1));
    }
}
