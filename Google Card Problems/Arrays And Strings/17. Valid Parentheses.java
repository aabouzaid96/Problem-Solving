// More Readable Solution
class Solution {
    public boolean isValid(String s) {
        Stack<Character> characters = new Stack<>();
      for(char nextChar: s.toCharArray()){
            if(nextChar =='(' || nextChar == '{' || nextChar == '['){
                characters.push(nextChar);
                continue;
            }
            
            if(characters.isEmpty()) return false;

            char topChar = characters.peek();

            if((topChar == '(' && nextChar == ')') || 
                (topChar == '[' && nextChar == ']') ||
                (topChar == '{' && nextChar == '}')){
                characters.pop();
            }else
              return false;             
        }
        return characters.isEmpty();
    }
}

// Solution 2
class Solution {
    public boolean isValid(String s) {
        Stack<Character> characters = new Stack<>();
        characters.push(s.charAt(0));
        int i=1;
        while(!characters.isEmpty() && i < s.length()){
            char topChar = characters.peek();
            char nextChar =  s.charAt(i);

            if((topChar == '(' && nextChar == ')') ||
                    (topChar == '[' && nextChar == ']') ||
                    (topChar == '{' && nextChar == '}')){
                characters.pop();

            }else
                characters.push(nextChar);

            i++;
            if(characters.isEmpty() && i< s.length())
                characters.push(s.charAt(i++));
        }
        return characters.isEmpty();
    }
}
