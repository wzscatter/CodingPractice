package LeetCode_Mid.Array;

import java.util.Stack;

public class reversePolandNotation_150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numberStack = new Stack<>();
        for(String token:tokens) {
            if(isNum(token)) {
                numberStack.push(Integer.parseInt(token));
                System.out.println(token);
            }
            else {
                int secondNum = numberStack.pop();
                int firstNum = numberStack.pop();
                if(token.equals("+")) {
                numberStack.add(firstNum+secondNum);
                }
                else if(token.equals("-")) {
                    numberStack.add(firstNum-secondNum);
                }
                else if(token.equals("*")) {
                    numberStack.add(firstNum*secondNum);
                }
                else if(token.equals("/")) {
                    numberStack.add(firstNum/secondNum);
                }



            }
        }
        return numberStack.pop();


    }
    private boolean isNum(String token) {
        return !(token.equals("+")||token.equals("-")||token.equals("*")||token.equals("/"));
    }

    public static void main(String[] args) {
        reversePolandNotation_150 a = new reversePolandNotation_150();
        String[] array = {"4", "13", "5", "/", "+"};
        System.out.println(a.evalRPN(array));
    }
}
