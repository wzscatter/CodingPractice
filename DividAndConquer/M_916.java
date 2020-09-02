package LeetCode_Mid.DividAndConquer;

import java.util.LinkedList;
import java.util.List;

public class M_916 {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] model = new int[26];
        List<String> result = new LinkedList<>();
        for(int i=0;i<B.length;i++) {
            for(int j = 0;j<B[i].length();j++) {
                model[B[i].charAt(j)-'a']++;
            }
        }
        for(int i = 0;i<A.length;i++) {
            int [] temp = new int [26];
            for(int j = 0;j<A[i].length();j++) {
                temp[A[i].charAt(j)-'a']++;
            }
            if(compare(temp,model)) result.add(A[i]);
        }
        return result;

    }
    private boolean compare(int[] a, int[] model) {
        for(int i = 0;i<model.length;i++) {
            if(a[i]>model[i]) return false;
        }
        return true;
    }
}
