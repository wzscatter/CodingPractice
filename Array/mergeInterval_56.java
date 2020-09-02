package LeetCode_Mid.Array;

import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mergeInterval_56 {
    public int[][] merge(int [][] intervals) {
        if(intervals.length<2) {
            return intervals;
        }
        Arrays.sort(intervals,(i1,i2)->Integer.compare(i1[0],i2[0]));
        List<int[]> result = new ArrayList<>();
        int [] newInterval = intervals[0];
        result.add(newInterval);
        for(int[] interval:intervals) {
            if(interval[0]<=newInterval[1]) {
                newInterval[1] = Math.max(interval[1],newInterval[1]);

            }
            else {
                newInterval = interval;
                result.add(newInterval);
            }

        }
        return result.toArray(new int[result.size()][]);


    }}
//    public int [][] merge(int [][] intervals) {
//        if(intervals.length<=1) {
//            return intervals;
//        }
//        List<int[]> result = new ArrayList<>();
//        Arrays.sort(intervals,(i1,i2)->Integer.compare(i1[0],i2[0]));
//        int [] comparedObject = intervals[0];
//        for(int[] interval:intervals) {
//            if(interval[0]<comparedObject[1]) {
//                comparedObject[1] = Math.max(interval[1],comparedObject[1]);
//
//            }
//            else {
//                result.add(comparedObject);
//                comparedObject = interval;
//            }
//        }
//        return result.toArray(new int[result.size()][]);
//    }
//}
