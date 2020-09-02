package LeetCode_Mid.DFS;

import java.util.*;

public class H_472 {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList();
        Set<String> pre = new HashSet<>();
        Arrays.sort(words,new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.length()-s2.length();
            }

        });
        for(int i = 0;i<words.length;i++) {
            if(canForm(words[i],pre)) {
                res.add(words[i]);
            }
            pre.add(words[i]);
        }

        return res;

    }
    private boolean canForm(String word, Set<String> pre) {
        boolean[] dp = new boolean[word.length()+1];
        for(int i =1;i<word.length();i++) {
            for(int j = 0;j<i;j++) {
                if(dp[j]) {
                    if(pre.contains(word.substring(j,i))) {
                        dp[i] = true;
                        break;
                    }

                }
            }
        }
        return dp[word.length()];

    }
}
