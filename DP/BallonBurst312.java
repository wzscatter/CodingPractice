package LeetCode_Mid.DP;

public class BallonBurst312 {
    public int maxCoins(int[] nums) {
        int [][] dp = new int [nums.length][nums.length];
        return maxCoins(nums,0,nums.length-1,dp);
    }


    private int maxCoins(int[] array,int start,int end,int [][]dp) {
        if(start>end) return 0;
        int max = array[start];
        if(dp[start][end]!=0) return dp[start][end];
        for (int i = start; i <=end  ; i++) {
            max= Math.max(max,maxCoins(array,   start,i-1,dp)
                    +maxCoins(array,i+1,end,dp)+array[i]*getBallon(array,start-1)*getBallon(array,end+1));
        }

        dp[start][end] = max;
        return max;
    }


    private int getBallon(int[] array,int index) {

        if(index==-1||index==array.length) return 1;
        else  return  array[index];

    }
}
