class Solution {
    public boolean canJump(int[] nums) {
        int currentJump = nums[0];
        
        for(int i=0;i<nums.length;i++){
            if(currentJump < i) 
                return false;
            currentJump = Math.max(currentJump, i+nums[i]);
        }
        return true;
    }

}
