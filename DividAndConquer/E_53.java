package LeetCode_Mid.DividAndConquer;

public class E_53 {
    int maxSum(int[] array) {
        int max = Integer.MAX_VALUE;
        int sum = 0;
        int size = array.length;
        for(int i = 0;i<size;i++) {
            if(sum<0) {
                sum = array[i];
            }
            else {
                sum+=array[i];
            }
            max = Math.max(max,sum);
        }
        return max;
    }
}
