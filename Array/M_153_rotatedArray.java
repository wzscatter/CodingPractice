package LeetCode_Mid.Array;

public class M_153_rotatedArray {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while (start!=end-1) {
            int mid = (start+end)/2;
            if(nums[mid]>nums[end]) start = mid;
            else if(nums[mid]<nums[end]) end = mid;
        }
        return nums[end];
    }

    public static void main(String[] args) {
        int[] array = {7,8,2,4,5,6};
        M_153_rotatedArray test = new M_153_rotatedArray();
        System.out.println(test.findMin(array));
    }
}
