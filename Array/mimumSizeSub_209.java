package LeetCode_Mid.Array;

public class mimumSizeSub_209 {
    public int minSubArrayLen(int s, int[] nums) {
        int start = 0;
        int end = 0;
        int sum = nums[0];
        int result = Integer.MAX_VALUE;
        while (end<nums.length) {
            sum+=nums[end++];
            while (sum>=s) {
                result = Math.min(result,end-start);
                sum-=nums[start++];


            }

        }
        return result==Integer.MAX_VALUE?0:result;

    }
    public static void main(String[] args) {
        mimumSizeSub_209 a = new mimumSizeSub_209();
        int[] temp1 ={1,1,3,5,1,1};
        System.out.println(a.minSubArrayLen(7,temp1));
    }
}
