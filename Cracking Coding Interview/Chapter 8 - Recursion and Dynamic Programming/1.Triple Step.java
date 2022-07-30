Same: 1137. N-th Tribonacci Number
https://leetcode.com/problems/n-th-tribonacci-number/

class Solution {
    public int tribonacci(int n) {
        if(n == 0)return 0;
        else if(n==1 || n == 2) return 1;
        return getTribonacci(0,1,1,3,n);
    }
    private int getTribonacci(int T1, int T2, int T3, int indx, int n){
        if(indx == n) return T1+T2+T3;
        
        return getTribonacci(T2,T3,(T1+T2+T3),indx+1, n);
    }
}
