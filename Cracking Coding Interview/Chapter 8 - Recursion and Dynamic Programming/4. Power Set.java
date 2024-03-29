//Power Set: Write a method to return all subsets of a set.

//Solution 1 O(2^n) time, O(n) space

class Solution {
    private List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums){
        result = new ArrayList<>();   
        generateSubsets(0, new ArrayList<>(), nums);
        return result;
    }
    
    private  void generateSubsets(int ind, List<Integer> subset, int [] nums){

        if(ind == nums.length){
            result.add(new ArrayList<>(subset));  
            return;
        }
        subset.add(nums[ind]);
        generateSubsets(ind+1, subset, nums);
        subset.remove(subset.size()-1);
        generateSubsets(ind+1, subset, nums);
      
    }
}
