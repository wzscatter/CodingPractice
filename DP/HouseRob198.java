package LeetCode_Mid.DP;

public class HouseRob198 {
    public int rob(int[] nums) {
        int[] include = new int[nums.length];
        int[] exclude = new int [nums.length];
        include[0] = nums[0];
        exclude[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            include[i] = exclude[i-1]+nums[i];
            exclude[i] = Math.max(exclude[i-1],include[i-1]);
//            System.out.println(include[i]);
//            System.out.println(exclude[i]);
        }
        return Math.max(include[nums.length-1],exclude[nums.length-1]);
    }

    public static void main(String[] args) {
        HouseRob198 test = new HouseRob198();
        int [] nums = {1,2,3,4};
        System.out.println(test.rob(nums));
    }
}
