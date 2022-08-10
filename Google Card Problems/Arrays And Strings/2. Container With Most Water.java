//Problem: Container With Most Water

class Solution {
    public int maxArea(int[] height) {
        int left =0, right =height.length -1;
        int numberOfLines = height.length -1, maxWater = 0, curWater=0;
        
       while(left != right){
            curWater = Math.min(height[left], height[right]) * numberOfLines ;
            if(height[left] < height[right]) 
                left++; 
            else right--;
           numberOfLines--;
            maxWater = Math.max(maxWater, curWater);
      }	
	    return maxWater;
    }
}
