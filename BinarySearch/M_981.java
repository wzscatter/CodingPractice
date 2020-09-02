package LeetCode_Mid.BinarySearch;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class M_981 {
    private Map<String, TreeMap<Integer,String>> map;
    public  M_981() {
        map = new HashMap<>();
    }
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key,new TreeMap<>());
        }
        map.get(key).put(timestamp,value);
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        Map.Entry<Integer,String> entry = map.get(key).floorEntry(timestamp);
        return (entry!= null)?entry.getValue():"";
    }
}
