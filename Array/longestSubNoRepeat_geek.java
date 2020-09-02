package LeetCode_Mid.Array;

import java.util.HashMap;
import java.util.Map;

public class longestSubNoRepeat_geek {
    public int findLongestSub(String str) {
        Map<Character,Integer> map = new HashMap<>();
        int result =1;
        char[] array= str.toCharArray();
        int mark = 0;
        for (int i = 0; i < array.length; i++) {
            if(map.containsKey(array[i])) {
                mark = i;
            }
            result = Math.max(result,i-mark+1);
            map.put(array[i],i);

        }
        return result;
    }

    public static void main(String[] args) {
        longestSubNoRepeat_geek a = new longestSubNoRepeat_geek();
        String str = "GEABCDFGEKSFORGEEKS";
        System.out.println(a.findLongestSub(str));
    }
}
