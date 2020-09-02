package LeetCode_Mid.Array;

import java.util.ArrayList;
import java.util.List;

public class pascalsTriangle_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row, pre = null;
        for (int i = 0; i < numRows; i++) {
            row = new ArrayList<>();
            for (int j = 0; j <= i; j++)
                row.add(j == 0 || i == j ? 1 : pre.get(j-1) + pre.get(j));
            pre = row;
            res.add(pre);
        }
        return res;
    }

    public static void main(String[] args) {
        pascalsTriangle_118 a = new pascalsTriangle_118();
        System.out.println(a.generate(5));
    }
}
