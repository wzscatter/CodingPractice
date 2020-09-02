package LeetCode_Mid.UnionFind;

import java.util.HashMap;
import java.util.Map;

public class calculate399_ADVANCED {
    public double[] calcEquation(String[][] e, double[] values, String[][] q) {
        double[] result = new double[q.length];
        Map<String,String> root = new HashMap<>();
        Map<String,Double> dist = new HashMap<>();
        for (int i = 0; i < e.length; i++) {

                String r1 = find(root,dist,e[i][0]);
                String r2 = find(root,dist,e[i][1]);
                root.put(r1,r2);
                dist.put(r1,dist.get(e[i][1])*values[i]/dist.get(e[i][0]));
        }
        for (int i = 0; i < q.length; i++) {
            String q1 = q[i][0];
            String q2 = q[i][1];
            if(!root.containsKey(q1)||!root.containsKey(q2)) {
                result[i] = -1.0;
                continue;
            }
            String r1 = find(root,dist,q1);
            String r2 = find(root,dist,q2);
            if(!r1.equals(r2)){

                result[i] = -1.0;
                continue;
            }
            result[i] = (double) dist.get(q1)/dist.get(q2);
        }
        return result;

    }
    private String find(Map<String,String> root, Map<String,Double> dist,String s) {
        if(!root.containsKey(s)){
            root.put(s,s);
            dist.put(s,1.0);
            return s;
        }
        if(root.get(s).equals(s)) return s;
        String lastP = root.get(s);
        String p = find(root,dist,lastP);
        root.put(s,p);
        dist.put(s,dist.get(s)*dist.get(lastP));
        return p;

    }
}
