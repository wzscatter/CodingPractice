package LeetCode_Mid.Array;

public class wordSearch_79 {
    public boolean exist(char[][] board,String word) {
        int height = board.length;
        int width = board[0].length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(helper(board,i,j,word.toCharArray(),0)) {
                    return true;
                }
            }
        }
        return false;

    }
    public boolean helper(char [][] board,int x,int y,char[] word,int t) {
        if(t== board.length) return true;
        if(x<0||y<0||x==board[y].length||y== board.length) return false;
        if(board[y][x]!=word[t]) return false;
        board[y][x]^= 256;
        boolean exist = helper(board,x+1,y,word,t+1)||
                helper(board,x-1,y,word,t+1)||
                helper(board,x,y+1,word,t+1)||
                helper(board,x,y-1,word,t+1);
        board[y][x]^=256;
        return exist;
    }
}
