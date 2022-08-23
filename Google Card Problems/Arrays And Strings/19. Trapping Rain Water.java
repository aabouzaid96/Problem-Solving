class Solution {
    public int trap(int[] height) {
        int length = height.length;
        int[] leftMax  = new int[length];
        int[] rightMax = new int[length];
        
        leftMax[0]=height[0];
        for(int i=1; i<length; i++){
            leftMax[i] = Math.max(leftMax[i-1] , height[i]);
        }
        
        rightMax[length-1]=height[length-1];
        for(int i=length-2; i>=0 ; i--){
            rightMax[i] = Math.max(rightMax[i+1] , height[i]);
        }
        
        int res =0;
        for(int i=0; i<length; i++){
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }
}
