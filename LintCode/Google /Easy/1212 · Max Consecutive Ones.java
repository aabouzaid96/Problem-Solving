Problem https://www.lintcode.com/problem/1212/?fromId=18&_from=collection

public class Solution {
    /**
     * @param nums: a binary array
     * @return:  the maximum number of consecutive 1s
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt= 0, mx =0;
        for(int num: nums){
            cnt = (num == 1) ? cnt+1 : 0;
            mx = Math.max(cnt, mx);
        }
        return mx;
    }
}
