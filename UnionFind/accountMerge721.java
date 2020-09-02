package LeetCode_Mid.UnionFind;

import java.util.*;

public class accountMerge721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String ,String> owner = new HashMap<>();
        Map<String,String> parent = new HashMap<>();
        Map<String, TreeSet<String>> unions = new HashMap<>();
        for(List<String> a:accounts) {
            for(int i =1;i<a.size();i++) {
                owner.put(a.get(i),a.get(0));
                parent.put(a.get(i),a.get(i));
            }
        }
        for(List<String> a:accounts) {
            String p = find(a.get(1),parent);
            for(int i= 2;i<a.size();i++) {
                parent.put(find(a.get(i),parent),p);
            }
        }
        for(List<String> a:accounts) {
            String p = find(a.get(1),parent);
            if(!unions.containsKey(p)) unions.put(p,new TreeSet<>());
            for(int i = 1;i<a.size();i++) {
                unions.get(p).add(a.get(i));
            }
        }

        List<List<String>> result = new ArrayList<>();
        for(String p:unions.keySet()) {
            List<String> temp = new ArrayList<>(unions.get(p));
            temp.add(0,owner.get(p));
            result.add(temp);
        }
        return result;



    }
    private String find(String str,Map<String,String> map) {
        return str==map.get(str)?str:find(map.get(str),map);
    }

}
