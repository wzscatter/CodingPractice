package LeetCode_Mid.DFS;

import java.util.Arrays;

public class M_1504 {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length, height[] = new int[n], res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                height[j] = mat[i][j] == 0 ? 0 : height[j] + 1;   // horizontal height of histogram;
                for (int k = j, min = height[j]; k >= 0 && min > 0; k--) {
                    min = Math.min(min, height[k]);
                    res += min;
                }
            }
        }


                return res;
    }

    }

//        [1,1,1,0,0,1,0]
//        [0,1,1,0,1,1,1]
////      [1,1,1,1,1,1,0]->3
//        [1,0,1,1,1,0,1]
//        [1,1,1,1,1,0,1]
//        corner case : if there is 1 near by, the min val is 1,other case min1+min2
    //    [1,2,3,   0,1,2,0]
//        [2,4,6,   0,2,4,3]
//        [3,6,11,  1,2,4,0]
//        [1,0,1,1,1,0]
//        [1,1,1,1,1,0]

