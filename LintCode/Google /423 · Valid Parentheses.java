https://www.lintcode.com/problem/423/?fromId=18&_from=collection

public class Solution {
    /**
     * @param s: A string
     * @return: whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
       Stack<Character> S=new Stack();
        for(Character c: s.toCharArray()){
            if(c=='(' || c=='{' || c=='[') 
                S.add(c);
            else{
                if(S.isEmpty()) return false;
                char top = S.pop();
                if(!((top == '(' && c==')') 
                || (top == '[' && c==']') 
                || (top == '{' && c=='}'))) return false;
            }
        }
        return S.isEmpty();
    }
}
