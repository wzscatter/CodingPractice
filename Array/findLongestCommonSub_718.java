package LeetCode_Mid.Array;

public class findLongestCommonSub_718 {
    public int findLength(int[] A, int[] B) {
        int Aextend = A.length+1;
        int Bextend = B.length+1;
        int result = 0;
        int [][] dp = new int[Aextend][Bextend];
        for (int i = 0; i < Aextend; i++) {
            for (int j = 0; j < Bextend; j++) {
                if(i==0||j==0) {
                    dp[i][j]=0;
                }
                else {
                    if(A[i-1]==B[j-1]) {
                        dp[i][j] = dp[i-1][j-1]+1;
                        result = Math.max(result,dp[i][j]);
                    }
                }
            }
        }
        return result;
    }
}
