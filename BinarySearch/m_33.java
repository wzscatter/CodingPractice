package LeetCode_Mid.BinarySearch;

import java.util.*;

public class m_33 {
    public int search(int[] nums, int target) {
         int size = nums.length;
         int pivot = 0;
         int left = 0;
         int right = size-1;
         int mid=0;
         Deque<Integer> d = new LinkedList<>();
         Stack<Integer> m = new Stack<>();
         for(int i = 1;i<=size;i++) {
             if(nums[i]<nums[i-1]) {
                 pivot = i;
                 break;
             }
         }
         if(nums[0]>=target) {
             left = pivot;
         }
         else {
             right = pivot;
         }
         while (left<=right) {
             mid = (left+right)/2;
             if(nums[mid]>target) {
                 right = mid-1;
             }
             else if(nums[mid]<target) {
                 left = mid+1;
             }
             else return mid;
         }
         if(nums[mid]==target) return mid;
         else return -1;
    }

    public static void main(String[] args) {
        m_33 test = new m_33();
        int[] arr = {3,4,5,6,7,8,9,1,2};
        System.out.println(test.search(arr,7));
    }

}
