package LeetCode_Mid.Array;

public class minCostClimbing_746 {
    public int minCostClimbingStairs(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i-1], cost[i-2]);
        }
        return Math.min(cost[cost.length-1], cost[cost.length-2]);

    }

    public static void main(String[] args) {
        minCostClimbing_746 a = new minCostClimbing_746();
        int[] array = {1,100,1,1,1,100,1,1,100,1};
        int [] array1 = {0,0,1,1};
         System.out.println(a.minCostClimbingStairs(array1));
    }
}
