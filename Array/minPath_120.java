package LeetCode_Mid.Array;
import java.util.List;

public class minPath_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==0) {
            return 0;
        }
        for (int i = triangle.size()-2; i >=0 ; i--) {
            List<Integer> nextRow = triangle.get(i+1);
            for (int j = 0; j < i; j++) {
                triangle.get(i).set(j,Math.min(nextRow.get(j),nextRow.get(j+1))+triangle.get(i).get(j));
            }

        }
        return triangle.get(0).get(0);
    }
}
