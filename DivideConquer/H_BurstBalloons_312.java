package LeetCode_Mid.DivideConquer;

public class H_BurstBalloons_312 {
    public int maxCoins(int[] nums) {
         int []array  = new int[nums.length+2];
         array[0]=1;
         array[array.length-1]=1;
        for (int i = 0; i < nums.length; i++) {
            array[i+1] = nums[i];
        }
        int[][] dp = new int [array.length][array.length];
        return helper(array,dp,1,nums.length);

    }
    private int helper(int[] array,int [][] dp,int left,int right) {
        if(left+1==right) return 0;
        if(dp[left][right]!=0) return dp[left][right];
        int ans= 0;
        for (int i = left+1; i < right; i++) {
            ans = Math.max(ans,helper(array,dp,left,i)+helper(array
            ,dp,i,right)+array[i]*array[left]*array[right]);
        }
        dp[left][right] = ans;
        return ans;
    }

}
