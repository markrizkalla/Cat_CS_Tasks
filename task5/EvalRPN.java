package leetcode;

import java.util.Stack;

public class EvalRPN {

    public static void main(String[] args){

        String[] arr = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(new EvalRPN().evalRPN(arr));
    }


    public int evalRPN(String[] tokens) {

        Stack<Integer> result = new Stack<>();

        for (var c : tokens){
            int x1,x2;

            switch (c){
                case "+":
                    x1 = result.pop();
                    x2 = result.pop();
                    result.push(x2 + x1);
                    continue;

                case "-":
                    x1 = result.pop();
                    x2 = result.pop();
                    result.push(x2 - x1);
                    continue;

                case "*":
                    x1 = result.pop();
                    x2 = result.pop();
                    result.push(x2 * x1);
                    continue;

                case "/":
                    x1 = result.pop();
                    x2 = result.pop();
                    result.push(x2 / x1);
                    continue;
            }
            result.push(Integer.parseInt(c));
        }

        return result.pop();

    }
}


