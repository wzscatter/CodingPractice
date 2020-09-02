package LeetCode_Mid.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combination_40 {
    public List<List<Integer>> combinationSum2(int[] cand,int target) {
        Arrays.sort(cand);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs_com (cand,0,target,path,result);
        return result;

    }
    private void dfs_com(int[] cand,int start,int target,List<Integer> path,List<List<Integer>> result) {
        if(target==0) {
            result.add(new ArrayList(path));
            return;
        }
        if(target<0) {
            return;
        }
        for (int i = start; i <cand.length ; i++) {
            if(i>start&&cand[i]==cand[i-1]) continue;
            path.add(path.size(),cand[i]);
            dfs_com(cand,i+1,target-cand[i],path,result);
            System.out.printf("i=%d,the path is %s%n",i,path.toString());
            path.remove(path.size()-1);

        }
    }

    public static void main(String[] args) {
        combination_40 a = new combination_40();
        int[] array = {1,2,3,4};
        System.out.println(a.combinationSum2(array,4));
    }
}
