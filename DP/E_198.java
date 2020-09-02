package LeetCode_Mid.DP;

public class E_198 {
    public int rob(int[] nums) {
        int[] include = new int[nums.length];
        int[] exclude = new int[nums.length];
        include[0] = nums[0];
        exclude[0] = 0;
        for(int i = 1;i<nums.length;i++) {
            include[i] = exclude[i-1]+nums[i];
            exclude[i] = Math.max(exclude[i=1],include[i-1]);
        }
        return Math.max(include[nums.length-1],exclude[nums.length-1]);
    }
}
