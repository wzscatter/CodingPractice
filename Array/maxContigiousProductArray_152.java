package LeetCode_Mid.Array;

public class maxContigiousProductArray_152 {
    public int maxProduct(int[] nums) {
        int origin = nums[0];
        for (int i = 0,imax= origin,imin= origin; i <nums.length ; i++) {
            if(nums[i]<0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(nums[i],imax*nums[i]);
            imin = Math.min(nums[i],imin*nums[i]);
            origin = Math.max(origin,imax);

        }
        return origin;

    }
}
