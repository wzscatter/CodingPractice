package LeetCode_Mid.DFS;

import LeetCode_Mid.Sort.M_1424;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.HashMap;
import java.util.Map;

public class M_130 {

    public void solve(char[][] board) {
        for(int i =0;i<board.length;i++) {
            dfs(i,0,board);
            dfs(i,board[0].length,board);
        }
        for(int j =0;j<board[0].length;j++) {
            dfs(0,j,board);
            dfs(board.length-1,j,board);
        }
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++) {
            for(int j =0;j<n;j++) {
                if(board[i][j]=='G') board[i][j]= 'O';
                else if(board[i][j]=='O') board[i][j]='X';
            }
        }
    }
    private void dfs(int x,int y,char[][]board) {
        if(x>=board.length||x<0||y>=board[0].length||y<0||board[x][y]!='O') return;
        board[x][y] = 'G';
        dfs(x-1,y,board);
        dfs(x,y-1,board);
        dfs(x+1,y,board);
        dfs(x,y+1,board);
    }

    public static void main(String[] args) {
        M_130 test = new M_130();
        char[][] array = {{'O','X','X','X','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
        char[][] array2 = {{'O','X','O','O','X','X'},{'O','X','X','X','O','X'},{'X','O','O','X','X','O'},{'X','O','X','X','X','X'},{'O','O','X','O','X','X'},{'X','X','O','O','O','O'}};
        test.solve(array2);
        int m = array2.length;
        int n = array2[0].length;
        for(int i =0;i<m;i++) {
            System.out.println(array2[i]);
        }
    }
}
