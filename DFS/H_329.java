package LeetCode_Mid.DFS;

public class H_329 {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return 0;
        int res = 1;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0;i<m;i++) {
            for(int j = 0;j<n;j++) {
                dp[i][j] = 1;
            }
        }
        for(int i =0;i<m;i++) {
            for(int j =0;j<n;j++) {
                res = Math.max(res,dfs(i,j,dp,matrix));
            }
        }
//        System.out.println(dp[1][1]+" "+dp[1][2]+" "+dp[2][2]+" "+dp[3][2]+" "+dp[3][3]+" ");
        return res;
    }
    private int dfs(int x, int y, int[][] dp,int[][]matrix) {
        int res = 1;
        if(dp[x][y]!=1) return dp[x][y];
        else if((x-1>=0&&matrix[x-1][y]<=matrix[x][y])
                &&(x+1<matrix.length&&matrix[x+1][y]<=matrix[x][y])
                &&(y-1>=0&&matrix[x][y-1]<=matrix[x][y])
                &&(y+1<matrix[0].length&&matrix[x][y+1]<=matrix[x][y])) {
            return  dp[x][y];
        }

        else {
            if((x-1>=0&&matrix[x-1][y]>matrix[x][y])) res = Math.max(res,1+dfs(x-1,y,dp,matrix));
            if((x+1<matrix.length&&matrix[x+1][y]>matrix[x][y])) res = Math.max(res,1+dfs(x+1,y,dp,matrix));
            if((y-1>=0&&matrix[x][y-1]>matrix[x][y])) res = Math.max(res,1+dfs(x,y-1,dp,matrix));
            if((y+1<matrix[0].length&&matrix[x][y+1]>matrix[x][y])) res = Math.max(res,1+dfs(x,y+1,dp,matrix));
        }
        dp[x][y] = res;
        return res;
    }



    public static void main(String[] args) {
        H_329 test = new H_329();
        int[][] arr = {{3,4,5},{3,2,6},{2,2,1}};
        int[][] arr2 = {{1,2}};
        int[][] arr3 = {{7,6,1,1},{2,7,6,0},{1,3,5,1},{6,6,3,2}};
        System.out.println(test.longestIncreasingPath(arr));
    }
}
