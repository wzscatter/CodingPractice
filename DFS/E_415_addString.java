package LeetCode_Mid.DFS;

import java.time.temporal.Temporal;
import java.util.LinkedList;
import java.util.Queue;

public class E_415_addString {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        E_415_addString TEST = new E_415_addString();
        System.out.println(TEST.addStrings("123","2"));
    }
}
