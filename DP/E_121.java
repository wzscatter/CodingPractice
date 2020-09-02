package LeetCode_Mid.DP;

public class E_121 {
    public int maxProfit(int[] prices) {
        int res = 0;
        int min = prices[0];
        for(int i = 1;i<prices.length;i++) {
            res = Math.max(prices[i]-min,res);
            min = Math.min(min,prices[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        E_121 test = new E_121();
        int[] arr = {7,1,5,3,6,4,9};
        System.out.println(test.maxProfit(arr));
    }
}
