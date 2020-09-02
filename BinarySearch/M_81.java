package LeetCode_Mid.BinarySearch;

import Greedy.M_870_maxPoint;

public class M_81 {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int size = nums.length;
        int right = size-1;
        while (left<=right) {
            int mid = (left+right)/2;
            if(nums[mid]==target) return true;
            if(nums[mid]<nums[left ]) {
                if(target>nums[mid]&&target<=nums[right]) {
                    left = mid+1;
                }
                else right = mid-1;
            }
            else if(nums[mid]>nums[left]) {
                if(target<nums[mid]&&target>=nums[left]) {
                    right = mid-1;
                }
                else left = mid + 1;
            }
            else if(nums[mid]==nums[left]){
                left++;
            }


        }
        return false;

    }

    public static void main(String[] args) {
        M_81 test = new M_81();
        int[] arr = {66,1,2,3,4,55};
        System.out.println(test.search(arr,3));
    }
}
