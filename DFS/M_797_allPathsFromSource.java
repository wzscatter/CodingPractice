package LeetCode_Mid.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class M_797_allPathsFromSource {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        path.add(0);
        dfs(graph,0,path,res);
        return res;

    }
    private void dfs(int[][] graph,int node,List<Integer> path,List<List<Integer>> res) {
        if(node == graph.length-1) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i:graph[node]) {

                path.add(node);
                dfs(graph,i,path,res);
                path.remove(path.size()-1);

        }
    }
    private List<List<Integer>> dfsAdvanced(int[][]graph, int node , Map<Integer,List<List<Integer>>> map ) {
        if(map.containsKey(node)) return map.get(node);
        List<List<Integer>> res = new ArrayList<>();
        if(node == graph.length-1) {

            List<Integer> path = new LinkedList<>();
            path.add(node);
            res.add(path);
        }
        else{
            for(int i :graph[node]) {
                List<List<Integer>> subPath = dfsAdvanced(graph,i,map);
                for(List<Integer> path:subPath) {
                    LinkedList<Integer> newPath = new LinkedList<>(path);
                    newPath.addFirst(node);
                    res.add(newPath);
                }
            }
        }
        map.put(node,res);
        return res;

    }
}
