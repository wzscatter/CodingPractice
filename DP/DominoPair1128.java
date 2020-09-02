package LeetCode_Mid.DP;

import java.util.HashMap;
import java.util.Map;

public class DominoPair1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer,Integer> map = new HashMap<>();
        int result = 0;
        int temp ;
        for(int i=0;i<dominoes.length;i++) {
            if(map.containsKey(i)) continue;
            temp = 0;
            for (int j = i+1; j <dominoes.length ; j++) {
                if(map.containsKey(j)) continue;
                else if((dominoes[i][1]==dominoes[j][1]&&dominoes[i][0]==dominoes[j][0])||
                        (dominoes[i][1]==dominoes[j][0]&&dominoes[i][0]==dominoes[j][1])) {
                    temp++;
                    map.put(j,1);
                }
            }
            result+= factorial(temp);


        }return result;

    }
    private int factorial(int n) {
        int result = 0;
        while (n>0) {
            result+=(n--);
        }
        return result;
    }

    public static void main(String[] args) {
        int [][] array = {{1,2},{2,1},{3,4},{4,3}};
        DominoPair1128 tets = new DominoPair1128();
        System.out.println(tets.numEquivDominoPairs(array));
    }
}
