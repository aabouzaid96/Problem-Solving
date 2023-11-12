https://www.lintcode.com/problem/514/?fromId=18&_from=collection

public class Solution {
    /**
     * @param n: non-negative integer, n posts
     * @param k: non-negative integer, k colors
     * @return: an integer, the total number of ways
     */
    public int numWays(int n, int k) {
         if( n == 1) return k;
        int sameColor = k;
        int diffColor = k*(k-1);
        int total = sameColor + diffColor;
        for(int i=3;i<=n;i++){
               sameColor = diffColor;
               diffColor =  total * (k-1);
               total = sameColor + diffColor;
        }
        return total;
    }
}
