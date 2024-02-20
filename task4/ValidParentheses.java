class Solution {
       public boolean isValid(String s) {

        Stack<Character> openParen = new Stack<>();


        ArrayList<Character> opend = new ArrayList<>();
        opend.add('(');
        opend.add('{');
        opend.add('[');


        for (var prac : s.toCharArray()){
            if (opend.contains(prac))
            {
                openParen.push(prac);
            }else{

                if (openParen.isEmpty())
                    return false;

                char pracN = openParen.pop();
                
                if (prac == '}' && pracN != '{'
                || prac == ')' && pracN != '('
                || prac == ']' && pracN != '['){
                    return false;
                }
            }
        }

        if (!openParen.isEmpty())
            return false;
        
        return true;
    }
}