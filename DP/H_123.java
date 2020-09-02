package LeetCode_Mid.DP;

import java.util.Arrays;

public class H_123 {
    public int maxProfit(int[] prices) {
        int res = help(prices);
        for(int i = 1;i<prices.length-2;i++) {
           int[] arr1 = Arrays.copyOfRange(prices,0,i+1);
           int[] arr2 = Arrays.copyOfRange(prices,i+1,prices.length);
           res = Math.max(help(arr1)+help(arr2),res);
        }
        return res;
    }
    public int help(int[] prices) {
        int res = 0;
        if(prices.length<2) return res;
        int min = prices[0];
        for(int i = 1;i<prices.length;i++) {
            res = Math.max(prices[i]-min,res);
            min = Math.min(min,prices[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        H_123 test = new H_123();
        int[] arr = {3,3,5,0,0,3,1,4};
        int[] arr1 = {2,1,2,0,1};
        System.out.println(test.maxProfit(arr1));
    }
}
