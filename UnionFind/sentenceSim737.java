package LeetCode_Mid.UnionFind;

import java.util.HashMap;
import java.util.Map;

public class sentenceSim737 {
    Map<String,String> father = new HashMap<>();
       boolean isSimiliar(String[] word1, String[] word2, String[][] pairs) {

        for(int i = 0;i<pairs.length;i++){
            this.father.put(pairs[i][0],pairs[i][0]);
            this.father.put(pairs[i][1],pairs[i][1]);
        }
        for(int i=0;i<pairs.length;i++){
            union(pairs[i][0],pairs[i][1]);
        }
        for (int i = 0; i < word1.length; i++) {
            if((!father.containsKey(word1[i]))||(!father.containsKey(word2[i]))||!find(word1[i]).equals(find(word2[i]))) return false;
        }
        return true;
        
    }
    public static void main(String[] args) {
        String[] word1={"great", "acting", "skills"};
        String[] word2={"fine", "drama", "talent"};
        String[][] pairs={{"great", "good"}, {"fiene", "good"}, {"acting","drama"}, {"skills","talent"}};
        sentenceSim737 test = new sentenceSim737();
        System.out.println(test.isSimiliar(word1,word2,pairs));
    }
    private void union(String str1,String str2) {
        String str1P = find(str1);
        String str2P = find(str2);
        if (!str1P.equals(str2P) ) {
            father.put(str2P,str1P);
        }

    }
    private String find(String str) {
        if(!father.get(str).equals(str)) {
            String lastP = father.get(str);
            father.put(str,find(lastP));
        }
        return father.get(str);
    }


}