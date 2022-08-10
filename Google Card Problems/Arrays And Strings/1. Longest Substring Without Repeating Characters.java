//   Longest Substring Without Repeating Characters


class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map= new HashMap<>();
        int left=0, right=0, maxLength =0 , curLength=0;
       
      while(left <= right && right < s.length()){
          char leftChar = s.charAt(left);
          char rightChar = s.charAt(right);

          if(!map.containsKey(rightChar) || (map.containsKey(rightChar) && map.get(rightChar) == -1)){
              map.put(rightChar, right);
              right++;
              curLength++;	
            }else{
              for(int ll=left; ll<map.get(rightChar);ll++){
                  map.put(s.charAt(ll), -1);
              }
              left = map.get(rightChar) +1;
              map.put(rightChar, right);
              curLength= right -left +1;
              right++;
            }
            maxLength = Math.max(maxLength , curLength);

        }
        return maxLength;
    }
}
