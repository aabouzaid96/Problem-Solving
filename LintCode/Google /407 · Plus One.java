Problem  https://www.lintcode.com/problem/407/?fromId=18&_from=collection
  
public class Solution {
  /**
   * @param digits: a number represented as an array of digits
   * @return: the result
   */
  public int[] plusOne(int[] digits) {
      int newSize = digits.length;

      newSize += checkAllIsNine(digits) ? 1 :0;
      int[] result = new int[newSize];

      int carry =1;
      int i, j;
      for(i=digits.length-1, j=newSize-1; i>=0; i--,j--){
          result[j] = (digits[i] + carry) %10;
          carry = (digits[i] + carry) / 10;
      }
      if(carry == 1)
          result[j] = carry;

      return result;
  }
  private boolean checkAllIsNine(int[] digits){
       for(int i: digits)
          if(i != 9) return false;
       return true;   
   }
}

/***

8999

**/
