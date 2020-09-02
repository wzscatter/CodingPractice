package LeetCode_Mid.DP;

public class Coins322 {
    public int coinChange(int[] coins, int amount) {
        int [] dp = new int[amount+1];
        dp[0] = 0;

        for (int i = 1; i <=amount  ; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j <coins.length ; j++) {
                if(i-coins[j]>=0&&dp[i-coins[j]]!=Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        if(dp[amount]==Integer.MAX_VALUE) return -1;
        else return dp[amount];
    }
    public int coinC(int[] coins, int amount) {
        int [] dp = new int[amount+1];
        for (int i = 1; i <amount+1 ; i++) {
            dp[i] = Integer.MAX_VALUE;
            for(int j = 0;j<coins.length;j++) {
                if(i-coins[j]>=0&&dp[i-coins[j]]!=Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }


        }
        if(dp[amount]==Integer.MAX_VALUE) return -1;
        return dp[amount];
    }
    public static void main(String[] args) {
        int[] coins = {2};
        Coins322 test = new Coins322();
        System.out.println(test.coinChange(coins,3));

    }
}
