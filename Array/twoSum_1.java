package LeetCode_Mid.Array;

import java.util.HashMap;
import java.util.Map;

public class twoSum_1 {
    public int[] twoSum(int[] nums,int target) {
        int result[] = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])) {
                result[0] = map.get(target-nums[i]);
                result[1] = i;
                return result;
            }
            map.put(nums[i],i);

        }
        return result;
    }

    public static void main(String[] args) {
        twoSum_1 a = new twoSum_1();
        int [] array = {1,2,3,4,5,6};
        System.out.println(a.twoSum(array,6)[0]);
        System.out.println(a.twoSum(array,6)[1]);
    }
}
