// very easy problem
class Solution {
    public int[] runningSum(int[] nums) {
        int sz=nums.length;
        for(int i=1;i<sz;i++) 
            nums[i]=nums[i-1]+nums[i];
        
        return nums; 
    }
}
