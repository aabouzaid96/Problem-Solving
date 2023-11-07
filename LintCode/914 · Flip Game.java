Problem  https://www.lintcode.com/problem/914/?fromId=18&_from=collection

public class Solution {
    /**
     * @param s: the given string
     * @return: all the possible states of the string after one valid move
     *          we will sort your return value in output
     */
    public List<String> generatePossibleNextMoves(String s) {
        // check if length less than 2
        if(s.length()<2)
            return new ArrayList<>();

        List<String> result = new ArrayList<>();

        char[] str = s.toCharArray();
        for(int i=0;i<s.length()-1;i++){
            if(str[i] =='+' && str[i+1] =='+'){
                str[i] ='-';
                str[i+1] ='-';
                result.add(String.valueOf(str));
                str[i] ='+';
                str[i+1] ='+';
            }
        }
        return result;    
    }
}
