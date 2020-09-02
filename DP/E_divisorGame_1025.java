package LeetCode_Mid.DP;

public class E_divisorGame_1025 {
    public boolean divisorGame(int N) {
        boolean[] dp = new boolean[N+1];
        dp[0] = false;
        dp[1] = false;
        for(int i=2; i <= N; i++){
            for(int j=1; j < i; j++){
                if(i % j == 0){
                    if(dp[i-j] == false){
                        dp[i] = true;
                        break;
                    }
                }
            }
            System.out.println(i);
        }
        return dp[N];

    }

    public static void main(String[] args) {
        E_divisorGame_1025 test = new E_divisorGame_1025();
        System.out.println(test.divisorGame(4));
    }
}
