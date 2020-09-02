package LeetCode_Mid.Array;

import java.net.Socket;
import java.util.*;

public class GroupAna_49 {

//    class Solution {
//    public List<List<String>> groupAnagrams(String[] strs) {
//        Hashtable<String, List<String>> map =  new Hashtable<String, List<String>>();
//        List<List<String>> results = new ArrayList<List<String>>();
//
//
//        for(String s : strs){
//            String x = s;
//            char tempArray[] = x.toCharArray();
//            Arrays.sort(tempArray);
//            String hash = new String(tempArray);
//            if (!map.containsKey(hash)) {
//                map.put(hash, new ArrayList<>());
//            }
//            map.get(hash).add(s);
//
//
//        }
//
//
//        // get keys() from Hashtable and iterate
//        Enumeration<String> enumeration = map.keys();
//
//        return new ArrayList(map.values());
//        //return results;
//    }
//}
    class soulution{
//        public List<List<String>> groupAnagrams(String [] strs){
//            List<List<String >> result = new ArrayList<List<String>>();
//            Map<String ,List<String>> map = new HashMap<String,List<String>>();
//            for(String str:strs){
//                String x = str;
//                char [] tempArray = x.toCharArray();
//                Arrays.sort(tempArray);
//                String hash = new String(tempArray);
//                if(!map.containsKey(hash)){
//                    map.put(hash,new ArrayList<>());
//                }
//                map.get(tempArray).add(str);
//
//            }
//            return new ArrayList<>(map.values());
//        };
    public List<List<String>> groupAnagrams(String [] strs){
        Map<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            String hashKey = Sorted(str);
            if(!map.containsKey(hashKey)){
                map.put(hashKey,new ArrayList<>());
            }
            map.get(hashKey).add(str);
        }
        return new ArrayList<>(map.values());
    };
    public String Sorted(String str){
        char [] res = str.toCharArray();
        Arrays.sort(res);
        return new String(res);
    }
    public List<List<String>> groupAnagrams_mine(String [] strs){
        Map<String ,List<String>> map = new HashMap<>();
        for(String str:strs) {
            String temp = sort(str);
            if(map.containsKey(temp)) {
                map.get(temp).add(str);
            }
            else {
                map.put(temp,new ArrayList<>());
                map.get(temp).add(str);
            }
        }
        return new ArrayList<>(map.values());

        }
    private String sort(String str) {
        char[] array = str.toCharArray();
        Arrays.sort(array);
        return array.toString();
    }





}





}

