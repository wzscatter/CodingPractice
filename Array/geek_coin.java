package LeetCode_Mid.Array;

import java.util.ArrayList;
import java.util.List;

public class geek_coin {
    private int result;
    public int minCoins(int num) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 20; i++) {
            list.add(i^2+1);
        }
        for(int value:list) {
            if(value>num) {
                result =  list.indexOf(value)+1;
                break;
            }
        }
        return result;
    }
}
