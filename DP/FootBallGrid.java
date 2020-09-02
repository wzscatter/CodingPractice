package LeetCode_Mid.DP;

public class FootBallGrid {
    public int findPaths(int m, int n, int N, int i, int j) {
       final int MOD = 1000000007;
       if(N<= 0) return 0;
       int[][] count = new int[n][m];
       int[][] direction = {{1,0},{0,1},{-1,0},{0,-1}};
       count[i][j] = 1;
       int result = 0;
        for (int k = 0; k < N; k++) {
            int[][] temp = new int[m][n];
            for (int r = 0; r < m  ; r++) {
                for (int c = 0; c < n; c++) {
                    for(int[] dir:direction) {
                        int nc = c+dir[1];
                        int nr = r+dir[0];
                        if(nc<0||nc>=n||nr<0||nr>=m) {
                            result = (result+count[r][c])%MOD;
                        }
                        else {
                            temp[nr][nc] = (temp[nr][nc]+count[r][c])%MOD;
                        }

                    }
                }
            }
            count = temp;
        }return result;
    }

}
