package LeetCode_Mid.Array;

public class canJump_55 {
    public boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i<reachable) return false;
            reachable = Math.max(reachable,i+nums[i]);
        }
        return true;
    }

    public boolean myCanJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0]=true;
        for(int i =0;i<nums.length;i++) {
            if(dp[i]) {
                for(int j=1;j<=nums[i];j++) {
                    if(i+j<nums.length) {
                        dp[i+j] = true;
                    }

                }
            }
        }

        return dp[nums.length-1];
    }
}
