// optimized- clean code solution O(N) time, O(1) space
class Solution {
	public int[] moveZeroes(int[] nums) {
		int k = 0;
		for (int i = 0; i < nums.length; i++) {
				if (nums[i] != 0) {
						swap(nums, k++, i);
				}
		}
		return nums;
	}
	private void swap(int[] nums, int x, int y){
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}
}
// two pointers  solution O(N) time, O(1) space
class Solution {
  public int[] moveZeroes(int[] nums) {
	  int l=0, r=1;
		while(l<nums.length && r<nums.length){
			int leftValue = nums[l];
			int rightValue = nums[r];
			if(leftValue != rightValue){
				if(leftValue == 0)
					swap(nums, l, r);
				l++;
				r++;
			}else{
				if(leftValue == 0) r++;
				else {l+=2; r+=2; }
			}
		}
		
    return nums;
  }
	private void swap(int[] nums, int x, int y){
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}
}
