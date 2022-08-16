/**
test cases :
"eceba"
"ccaabbb"
"cacacbbaca"

**/
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        
         if(s.length() == 1)
            return 1;

        Map<Character, Integer> map = new HashMap<>();
        Set<Character> characters = new HashSet<>();
        int left =0, right =0, uniqueChar =0, longestSubString =0, curSubStringLength=0;

        while(left <= right && right < s.length()){
            char rightChar = s.charAt(right);

            if(map.containsKey(rightChar) && map.get(rightChar) != 0){
                right++;
                curSubStringLength++;
                map.put(rightChar, map.get(rightChar)+1);
            }
            else{
                if(uniqueChar < 2){
                    map.put(rightChar, 1);
                    uniqueChar++;
                    curSubStringLength= right -left +1;
                    right ++;
                }else{
                    char leftChar = s.charAt(left);
                    map.put(leftChar, map.get(leftChar)-1);
                    if(map.get(leftChar) == 0){
                        uniqueChar--;
                    }
                    curSubStringLength--;
                    left++;
                }

            }
            longestSubString = Math.max(curSubStringLength, longestSubString);
        }
        return longestSubString;
    }
}
