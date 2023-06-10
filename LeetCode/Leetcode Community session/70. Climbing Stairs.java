// Solution using Fibonacci 
class Solution {
    public int climbStairs(int n) {
        int series[] = new int[45];
        series[0] = 1;
        series[1] = 2;
        
        for(int i=2;i<n;i++){
            series[i] = series[i-1] + series[i-2];
        }
        
        return series[n-1];
    }
}
