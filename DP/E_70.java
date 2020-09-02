package LeetCode_Mid.DP;

public class E_70 {
    public int climbStairs(int n) {
        int[] stair = new int[n];
        stair[0]=1;
        stair[1] = 1;
        stair[2] = 2;
        for(int i =3;i<n;i++) {
            stair[i] = stair[i-1]+stair[i-2];
        }
        return stair[n-1];
    }
}
