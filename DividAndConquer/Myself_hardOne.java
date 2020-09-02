package LeetCode_Mid.DividAndConquer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Myself_hardOne {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        if(input == null||input.length()<1) return res;
        List<String> ops = new ArrayList<>();
        for(int i = 0;i<input.length();i++) {
            int j= i;
            while (j<input.length()&&Character.isDigit(input.charAt(j)))
                j++;
            String num = input.substring(i,j);
            ops.add(num);
            if(j!=input.length()) ops.add(input.substring(j,j+1));
            i = j;
        }
        res = compute(ops,0,ops.size()-1);
        return res;
    }
    private List<Integer> compute (List<String> ops, int left, int right) {
        List<Integer> result = new ArrayList<>();
        if(left ==right) {
            Integer num = Integer.getInteger(ops.get(left));
            result.add(num);
            return result;
        }

        for(int i =left+1;i<right-1;i+=2) {
            String operator = ops.get(i);
            List<Integer> leftpart = compute(ops,left,i-1), rightpart = compute(ops,i+1,right);
            for(int ln:leftpart) {
                for(int rn:rightpart) {
                    if(operator.equals("+")) {
                        result.add(ln+rn);

                    }
                    else if(operator.equals("-")) {
                        result.add(ln-rn);
                    }
                    else if(operator.equals("*")) {
                        result.add(ln*rn);
                    }
                }

            }

        }
        return result;
    }
}
