package LeetCode_Mid.DivideConquer;

public class E_majorityElement_169 {
    public int majorityElement(int[] nums) {
        int num = 1;
        int result = nums[0];
        for(int i = 0;i<nums.length;i++) {
            if(num==0) {

                num++;
                result=nums[i];
            }
            else if(nums[i]==result) num++;
            else  num--;
            System.out.println(result);

        }
        return result;
    }

    public static void main(String[] args) {
        E_majorityElement_169 test = new E_majorityElement_169();
        int [] array= {1,2,3,1,1,1,3,4,2,1};
        System.out.println(test.majorityElement(array));
    }
}
