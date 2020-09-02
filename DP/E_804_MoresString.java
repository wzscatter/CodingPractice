package LeetCode_Mid.DP;

import java.util.HashSet;
import java.util.Set;

public class E_804_MoresString {
    public int uniqueMorseRepresentations(String[] words) {
        String[] table= new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> result = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            String temp = "";
            for (int j = 0; j < words[i].length(); j++) {
                temp+=table[words[i].charAt(j)-'a'];
            }
            result.add(temp);
        }
        return result.size();
    }
}
