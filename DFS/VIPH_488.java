package LeetCode_Mid.DFS;

public class VIPH_488 {
    int maxCount = 5;
    public int findMinStep(String board, String hand) {
        int[] ballsInHand = new int[26];
        for(int i=0;i<hand.length();i++) {
            ballsInHand[hand.charAt(i)-'A']++;
        }
        int res = dfs(board+"#",ballsInHand);
        return res>=maxCount?-1:res;

    }
    private int dfs(String board,int[]ballsInHand) {
        board = removeConsecutive(board);
        if(board=="#") return 0;
        int ballsNeed = 3;
        int res = maxCount;
        for(int i =0,j=0;j<board.length();j++) {
            if(board.charAt(i)==board.charAt(j)) continue;
            ballsNeed = 3-(j-i);
            if(ballsInHand[i-'A']>=ballsNeed) {
                ballsInHand[i-'A']-=ballsNeed;
                res = Math.min(res,ballsNeed+dfs(board.substring(0,i)+board.substring(j),ballsInHand));
                ballsInHand[i-'A']+=ballsNeed;
            }

        }
        return res;

    };
    private String removeConsecutive (String str) {
        for(int i=0,j=0;j<str.length();j++) {
            if(str.charAt(i)==str.charAt(j)) continue;
            if(j-i>=3) return removeConsecutive(str.substring(0,i)+str.substring(j));
            i=j;
        }
        return str;
    }
}
