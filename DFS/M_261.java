package LeetCode_Mid.DFS;

public class M_261 {
    int[] parent;
    public boolean validTree(int n, int[][] edges) {
        if(n==0||n==1) return true;
        if(edges==null||edges.length==0) return false;
        parent = new int[n];
        for(int i =0;i<n;i++) {
            parent[i] = i;
        }
        for(int i=0;i<edges.length;i++) {
            if(findParent(edges[i][0])==findParent(edges[i][1])) return false;
            union(edges[i][0],edges[i][1]);
        }
        return true;
    }
    private void union(int a , int b) {
        int aP = findParent(a);
        int bP = findParent(b);
        parent[bP] = aP;
    }
    private int findParent(int a) {
        if(a==parent[a]) return a;
        else{
            parent[a] = findParent(parent[a]);
        }
        return parent[a];
    }
    public static void main(String[]args) {
        M_261 test = new M_261();
        int[][] array = {{0,1},{0,2}};
        System.out.println(test.validTree(3,array));
    }

}
