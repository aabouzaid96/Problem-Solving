https://www.lintcode.com/problem/427/?fromId=18&_from=collection

3 solution 

Recursive using DFS more optimized [Best solution]
public class Solution {
  /**
   * @param n: n pairs
   * @return: All combinations of well-formed parentheses
   *          we will sort your return value in output
   */
  private int N;
  public List<String> generateParenthesis(int n) {
      if(n ==0 ) return new ArrayList<>();
      
      N =n;
      List<String> list = new ArrayList<>();       
      generateAllWays("",0,0, list);
      return list;
  }
  private void generateAllWays(String cur, int i, int j,  List<String> list){
      if(i == N && j == N){
        list.add(cur);
        return ;
      }
      // check if ( is not equal N And number of '(' greater than ')'
      if(i < N && j <= i) generateAllWays(new StringBuilder(cur).append("(").toString(),i+1,j, list);
      // check if ) is not equal N And number of ')' less than '('
      if(j < N && i >= i) generateAllWays(new StringBuilder(cur).append(")").toString(),i,j+1, list);
  }
}
------------------------------------------------------
Recussive using DFS
class Solution {
  private int N;
  public List<String> generateParenthesis(int n) {
      if(n ==0 ) return new ArrayList<>();
      
      N =n;
      List<String> list = new ArrayList<>();       
      generateAllWays("", list);
      return list;
  }

  private void generateAllWays(String cur, List<String> list){
      if(cur.length() == N*2){
          if(validParenthesis(cur)) {
              list.add(cur);
              System.out.println(cur);
          }
          return ;
      }

      generateAllWays(new StringBuilder(cur).append(")").toString(), list);
      generateAllWays(new StringBuilder(cur).append("(").toString(), list);
  }

  private boolean validParenthesis(String str){
      Stack<Character> stack = new Stack<>();
      for(Character c: str.toCharArray()){
          if(c =='(')
              stack.add(c);
          else {
              if(stack.isEmpty()) return false;
              char top = stack.pop();
              if(!(top == '(' && c == ')')) return false;
          }
      }
      return stack.isEmpty();
  }
}
------------------------------------------
**Iterative using stack
class Solution {
  public List<String> generateParenthesis(int n) {
      if(n ==0 ) return new ArrayList<>();

      List<String> list = new ArrayList<>();       
      Stack<String> stack = new Stack<>();
      stack.push("(");
      while(!stack.isEmpty()){
          String cur = stack.pop();
          if(cur.length() == n*2){
              if(validParenthesis(cur)) {
                  list.add(cur);
                  System.out.println(cur);
              }
              continue;
          }
          stack.push(new StringBuilder(cur).append("(").toString());
          stack.push(new StringBuilder(cur).append(")").toString());
      }
      return list;
  }

  private boolean validParenthesis(String str){
      Stack<Character> stack = new Stack<>();
      for(Character c: str.toCharArray()){
          if(c =='(')
              stack.add(c);
          else {
              if(stack.isEmpty()) return false;
              char top = stack.pop();
              if(!(top == '(' && c == ')')) return false;
          }
      }
      return stack.isEmpty();
  }
} 
