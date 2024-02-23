class Solution {
    public String removeDuplicates(String s) {
            Stack<Character> stack = new Stack<>();

        for(var ch: s.toCharArray()){


                while (stack.size() >= 2){

                    char x1 = stack.pop();
                    char x2 = stack.pop();

                    if (x1 != x2){
                        stack.push(x2);
                        stack.push(x1);

                        break;
                    }
                }
                stack.push(ch);

        }

         while (stack.size() >= 2){

                    char x1 = stack.pop();
                    char x2 = stack.pop();

                    if (x1 != x2){
                        stack.push(x2);
                        stack.push(x1);

                        break;
                    }
                }

        StringBuilder word = new StringBuilder();
        while (!stack.empty()){
            word.append(stack.pop());
        }



        return word.reverse().toString();
    }
}