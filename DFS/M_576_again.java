package LeetCode_Mid.DFS;

public class M_576_again {
    public int findPaths(int m, int n, int N, int i, int j) {
        int[][][] dp = new int[m][n][N];
        for (int a = 0; a < m; a++) {
            for (int b = 0; b < n; b++) {
                for (int c = 0; c < N; c++) {
                    dp[a][b][c] = -1;
                }
            }
        }
        return run(dp, m, n, N, i, j);
    }

    private int run(int[][][] dp, int m, int n, int N, int i, int j) {
        if (dp[i][j][N] != -1) return dp[i][j][N];
        if (N == 0) return 0;
        if (i < 0 || i >= m || j < 0 || j >= n) {
            int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            for (int[] dir : directions) {
                int x = i + dir[0];
                int y = j + dir[1];
                dp[i][j][N] += run(dp, m, n, N - 1, x, y);
            }


        }
        return dp[i][j][N];

    }
}
