Problem https://www.lintcode.com/problem/655/description?fromId=18&_from=collection

 // Better solution 
 //  Beats 100.00% Runtime  - Beats 56.80% Memory on Lettcode
public class Solution { 
    /**
     * @param num1: a non-negative integers
     * @param num2: a non-negative integers
     * @return: return sum of num1 and num2
     */
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int carry =0;
        for(int i=num1.length()-1, j= num2.length()-1; i>=0 || j >=0 || carry ==1; i--, j--){
            int n1 = (i >=0 ) ? num1.charAt(i) - '0' : 0;
            int n2 = (j >=0 ) ? num2.charAt(j) - '0' : 0;
            int sum = n1 + n2 + carry;
            carry = sum/10;
            res.append((char)(sum%10+'0'));
        }
        return res.reverse().toString();
    }
}

------------------------------------------

2nd Solution  - Beats 70.66% Runtime  - Beats 53.40% Memory

public class Solution {
    /**
     * @param num1: a non-negative integers
     * @param num2: a non-negative integers
     * @return: return sum of num1 and num2
     */
    public String addStrings(String num1, String num2) {
        
        // swap to make num1 will be always bigger
        if(num1.length() < num2.length()){
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        
        StringBuilder res= new StringBuilder();
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        int carry =0;
        for(int i=0; i<num1.length(); i++){
            int n1 = num1.charAt(i) - '0';  // 3
            int n2 = (i < num2.length()) ? num2.charAt(i) - '0' : 0;
            int sum = n1 + n2 + carry;
            carry = sum/10;
            res.append((char)(sum%10+'0'));
        }
        if(carry != 0) res.append((char)(carry+'0'));
        return res.reverse().toString();
    }
}
