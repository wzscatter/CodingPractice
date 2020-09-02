package LeetCode_Mid.Array;

public class Non_decreaseingAarray_665 {
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;                                                                    //the number of changes
        for(int i = 1; i < nums.length && cnt<=1 ; i++){
            if(nums[i-1] > nums[i]){
                cnt++;
                if(i-2<0 || nums[i-2] <= nums[i])nums[i-1] = nums[i];                    //modify nums[i-1] of a priority
                else nums[i] = nums[i-1];                                                //have to modify nums[i]
            }
        }
        return cnt<=1;
    }

    public static void main(String[] args) {
        Non_decreaseingAarray_665 a = new Non_decreaseingAarray_665();
        int [] array = {1,2,3,2,1,5};
        int [] array1 = {4,2,3};
         System.out.println(a.checkPossibility(array1));
    }
}
