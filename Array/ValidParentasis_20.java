package LeetCode_Mid.Array;

import LeetCode_Mid.DFS.test;

import java.util.*;

public class ValidParentasis_20 {
    public boolean isValid(String s ){
        Deque<Integer> dq = new ArrayDeque<>();
        Queue<Integer> q = new ArrayDeque<>();
        dq.offerFirst(1);
        Stack<Integer> st = new Stack<>();
        dq.push(null);
        
        Stack stack = new Stack();
        char [] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if(str[i]=='('||str[i]=='['||str[i]=='{'){
                stack.push(str[i]);

            }
            else {
                if(stack.empty()){
                    return false;
                }
                else if(str[i]=='}' && stack.peek().equals( '{'))stack.pop();
                else if(str[i]==']' && stack.peek().equals( '['))stack.pop();
                else if(str[i]==')' && stack.peek().equals( '('))stack.pop();

            }



        }
        return true;
    }


}
