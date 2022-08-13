// Solution 1
// O(n^2) time

class Solution {
    public String multiply(String num1, String num2) {

        if(num1.equals("0") || num2.equals("0")) 
            return "0";

        
        StringBuilder finalResult = new StringBuilder();
        String [] multipledResults = new String [num2.length()];
        int numberOfLeadingZeros = 0, maxNumberLength=0;
        
        for(int i=num2.length()-1; i>= 0;i--, numberOfLeadingZeros++){
            
            StringBuilder temp = buildStringWithZeros(numberOfLeadingZeros);
            
            multipledResults[numberOfLeadingZeros] = 
                getProduct(num2.charAt(i)-'0', 0, num1.length()-1, temp, num1.toCharArray());
        
            maxNumberLength = Math.max(maxNumberLength,  multipledResults[numberOfLeadingZeros].length());
        }

        return sumOfMultipliedValues(multipledResults, maxNumberLength);
    }
    private StringBuilder buildStringWithZeros(int number){
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<number;i++)
            sb.append("0");
        return sb;
    }

    private String getProduct(int num, int carry, int index, StringBuilder result  ,char[] num1){
        if(index < 0){
            if(carry != 0) result.append(carry);
            return result.toString();
        }
        int curNumber =num1[index]-'0';
        int multipliedValue = (num * curNumber) + carry;
        result.append(Integer.toString(multipliedValue %10));
        carry = multipliedValue / 10;
        return getProduct(num,carry, index-1, result, num1);
    }
    
    private String sumOfMultipliedValues(String multipledResults[], int maxNumberLength){

        StringBuilder finalResult = new StringBuilder();
        int carry =0;
        
        for(int i=0;i<maxNumberLength;i++){
            int num =0;
            for(int j=0;j< multipledResults.length;j++){
               int currentValue = (i < multipledResults[j].length())? multipledResults[j].charAt(i)-'0' : 0;
               num += currentValue+carry;
               carry =0;
            }
            finalResult.append(Integer.toString(num%10));
            carry = num / 10 ;
        }
         if(carry != 0) finalResult.append(carry);   
        return finalResult.reverse().toString();
    }
    
}
