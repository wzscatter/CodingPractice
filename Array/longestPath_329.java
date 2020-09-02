package LeetCode_Mid.Array;

public class longestPath_329 {
    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int find(int [][] matrix,int row,int col) {
        int result = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
               result = Math.max(result, dfs_helper(matrix,i,j,1));
            }
        }
        return result;
    }
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m][n];
        int max = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, m, n, cache);
                max = Math.max(max, len);
            }
        }
        return max;
    }

    public int dfs(int[][] matrix, int i, int j, int m, int n, int[][] cache) {
        if(cache[i][j] != 0) return cache[i][j];
        int max = 1;
        for(int[] dir: dirs) {
            int x = i + dir[0], y = j + dir[1];
            if(x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
            int len = 1 + dfs(matrix, x, y, m, n, cache);
            max = Math.max(max, len);
        }
        cache[i][j] = max;
        return max;
    }
    public int dfs_helper(int[][] matrix,int row,int col,int pathLength) {
        if((matrix[row][col+1]<=matrix[row][col])||
                (matrix[row+1][col]<=matrix[row][col])||
                (matrix[row][col-1]<=matrix[row][col])||
                (matrix[row-1][col]<=matrix[row][col])) {
            return pathLength;
        }
        int d=pathLength;
        int a=pathLength;
        int c=pathLength;
        int b = pathLength;
        if(matrix[row][col+1]>matrix[row][col]) {
            a=dfs_helper(matrix,row,col+1,pathLength+1);
        }
        if(matrix[row+1][col]>matrix[row][col]) {
            b=dfs_helper(matrix,row+1,col,pathLength+1);
        }
        if(matrix[row-1][col]>matrix[row][col]) {
            c=dfs_helper(matrix,row-1,col,pathLength+1);
        }
        if(matrix[row][col-1]>matrix[row][col]) {
            d=dfs_helper(matrix,row,col-1,pathLength+1);
        }
        return Math.max(a,b);
    }
}
