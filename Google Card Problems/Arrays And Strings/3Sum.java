// Problem: 3Sum
// Solution 1
//O(n2) time , O(n3) space
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
  	    Map<Integer, Integer> map = new HashMap<>();
        Set<List<Integer>> visitedTriplet = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        int arraySize = nums.length;
        
        Arrays.sort(nums);
        for(int i=0;i<arraySize;i++) {
            map.put(nums[i], i);
        }
        
        for(int i=0;i< arraySize; i++){
            for(int j=i+1;j<arraySize;j++){
                int twoSum = nums[i]+nums[j];
                int target = twoSum * -1;
                if(map.containsKey(target) && map.get(target) > j){
                    List<Integer> currentTriple = new ArrayList<>
                        (Arrays.asList(nums[i],nums[j], target));
                    
                    if(!visitedTriplet.contains(currentTriple)){
                        result.add(currentTriple);
                        visitedTriplet.add(currentTriple);
                    }
                } 
            }
        }
        return result;
    }
}

 ---------------------------------------
// Solution 2
// //O(n2) time , O(n2) space
   class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
  	    Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        int arraySize = nums.length;
        
        Arrays.sort(nums);
        for(int i=0;i<arraySize;i++) {
            map.put(nums[i], i);
        }
        
        for(int i=0;i< arraySize; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j=i+1;j<arraySize;j++){
                if(j-1 != i && nums[j] == nums[j-1]) continue;

                int twoSum = nums[i]+nums[j];
                int target = twoSum * -1;
                if(map.containsKey(target) && map.get(target) > j){
                    List<Integer> currentTriple = new ArrayList<>
                        (Arrays.asList(nums[i],nums[j], target));
                    
                    // if(!visitedTriplet.contains(currentTriple)){
                        result.add(currentTriple);
                        // visitedTriplet.add(currentTriple);
                    // }
                } 
            }
        }
        return result;
    }
}
