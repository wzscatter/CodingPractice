package LeetCode_Mid.Array;

import java.util.Map;
import java.util.TreeMap;

public class M_954_doublePairs {
    public boolean canReorderDoubled(int[] A) {
        Map<Integer,Integer> count = new TreeMap<>();
        for(int i:A) {
            count.put(i,count.getOrDefault(i,0)+1);
        }
        for(int key:count.keySet()) {
            int want = key<0?key/2:key*2;
            if(key<0&&key%2!=0||count.getOrDefault(want,0)<count.get(key)) return false;
            count.put(want,count.get(want)-count.get(key));
        }
        return true;
    }
}
