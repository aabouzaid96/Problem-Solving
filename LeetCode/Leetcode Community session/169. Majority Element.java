// Soultion 1 using Map O(N) time, O(N) space 
// **Runtime 21 ms, Beats 10.99%   - Memory 46.9 MB Beats 63.59%
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int mxNum = 0, mxFreq =0;
        for(int num: nums){
            map.put(num, map.getOrDefault(num,0)+1);
            if(map.get(num) > mxFreq){
                mxNum = num;
                mxFreq = map.get(num);
            }
        }
        return mxNum;
    }
}

// Soultion 2 - More optimized using Map O(N) time, O(1) space  
// Runtime: 1 ms - Beats 99.74%    - Memory: 48.7 MB Beats 20.46% 
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0, majorityElement =0;
        for(int num: nums){
            if(count == 0) majorityElement =num;

            if(majorityElement == num) count++;
            else count--;
        }
        return majorityElement;
    }
}
/** 
[1,1,1,2,2,2,2]
1, count =1 
1, count =2
1, count =3
1, count =2
1, count =1
1, count =0  
*/
