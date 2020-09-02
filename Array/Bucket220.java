package LeetCode_Mid.Array;

import java.net.PortUnreachableException;
import java.util.HashMap;
import java.util.TreeSet;

public class Bucket220 {
    public boolean containsNearbyDuplicates(int[] nums,int k,int t){
        if(nums==null||nums.length==0||k<=0||t<0){
            return false;

        }
        int min= Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min,nums[i]);
        }
        HashMap<Long,Integer> bucket = new HashMap<>();
        long diff = Long.valueOf(t)+1;//incase t = 0
        for (int i = 0; i < nums.length; i++) {
            long index = (Long.valueOf(nums[i])-Long.valueOf(min))/diff;

            if((bucket.get(index-1)!=null&&Math.abs(Long.valueOf(bucket.get(index-1))-Long.valueOf(nums[i]))<=t)||
                    (bucket.get(index+1)!=null&&Math.abs(Long.valueOf(bucket.get(index+1))-Long.valueOf(nums[i]))<=t)||
                            (bucket.get(index)!=null&&Math.abs(Long.valueOf(bucket.get(index))-Long.valueOf(nums[i]))<=t )){
                return true;
            }
            bucket.put(index,nums[i]);
            if(i>=k){
                bucket.remove((Long.valueOf(nums[i-k])-Long.valueOf(min))/diff);
            }


        }
        return true;
    }

    public boolean myDuplicate(int[] nums,int indexDiff,int valDiff) {
        if(indexDiff<1||valDiff<0) return false;
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0;i<nums.length;i++) {
            if(set.contains(nums[i]))return true;
            Integer ceil = set.ceiling(nums[i]);
            if(ceil!=null&&Long.valueOf(ceil)-nums[i]<=valDiff) return true;
            Integer floor = set.floor(nums[i]);
            if(floor!=null&&nums[i]-Long.valueOf(floor)<=valDiff) return true;
            set.add(nums[i]);
            if(i>indexDiff) set.remove(nums[i-indexDiff]);
        }
        return false;
    }

    public static void main(String[] args) {
        Bucket220 test = new Bucket220();
        int[] arr = {1};
        System.out.println(test.myDuplicate(arr,3,0));
    }

}
