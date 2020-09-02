package LeetCode_Mid.DFS;

import java.util.ArrayList;
import java.util.List;

public class M_394_decoding {
    public String decodeString(String s) {
        String result = "";
        int begin = 0;

        List<Integer> index= new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==']'){
                index.add(i+1);
            }

        }
        for (int i = 0; i < index.size(); i++) {
            System.out.println(index.get(i));
        }

        for (int i = 0; i < index.size(); i++) {
            if(i==0) {

                result+=helper(s.substring(0,index.get(i)));
            }
            else {
                System.out.println(index.get(i));
                result+=helper(s.substring(index.get(i-1),index.get(i)));
            }

        }
        return result;
    }
    String helper(String s) {
        int num = 0;
        int begin = 0;
        int end = 0;
        String temp ;
        String res="";
        for(int i = 0;i<s.length();i++) {
            if(s.charAt(i)-'0'>=0&&s.charAt(i)-'9'<=0){
                num = num*10 +s.charAt(i)-'0';
            }
            if(s.charAt(i)=='[') {
                begin = i+1;
            }
            if(s.charAt(i)==']') {
                end = i;
            }
        }
        temp = s.substring(begin,end);
        System.out.printf("temp:%s,num:%d%n",temp,num);

        for (int j = 0; j < num; j++) {
            res+=temp;
        }
        return res;
    }

    public static void main(String[] args) {
        M_394_decoding test = new M_394_decoding();
        System.out.println(test.decodeString("4[abc]10[a]3[b]"));
    }
}
