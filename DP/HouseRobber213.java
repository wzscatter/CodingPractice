package LeetCode_Mid.DP;

public class HouseRobber213 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
    private int rob(int[]nums,int low ,int hi){
        int include = 0, exclude = 0;
        for (int i = low; i <=hi  ; i++) {
            int in = include,e = exclude;
            include = e+nums[i];
            exclude = Math.max(in,e);
        }
        return Math.max(include,exclude);
    }
    public int myrob(int[] nums) {
        return Math.max(helper(nums,0,nums.length-1),helper(nums,1, nums.length));
    };
    private int helper(int[] nums,int begin, int end) {
        int include =0;
        int exclude = 0;
        for (int i = begin; i < end ; i++) {
            int in = include;
            int ex = exclude;
            include = ex+nums[i];
            exclude = Math.max(ex,in);
        }
        return Math.max(include,exclude);
    }

}
