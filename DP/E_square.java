package LeetCode_Mid.DP;

public class E_square {
    public int numSquares(int n) {
        int [] dp = new int [n+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;

        }
        for (int i = 0; i <=n; i++) {
            int sqrt = (int) Math.sqrt(n);
            if(sqrt*sqrt==i) {
                dp[i] = 1;
                continue;
            }
            for(int j = 1;j<=sqrt;j++){
                int dif = i- j*j;
                dp[i] = Math.min(dp[i],dp[dif]+1);
            }

        }
        return dp[n];

    }
}
