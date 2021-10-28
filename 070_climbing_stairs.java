// You are climbing a staircase. It takes n steps to reach the top.
// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
class Solution {
    public int climbStairs(int n) {
        // return climbStairs(0, n);
        // 3. Dynamic Programming - O(n)
        if(n == 1)
            return 1;
        
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }
        
        return dp[n];
    }
    
    // 1. Brute Force O(2^n) - time limit exceeded
    public int climbStairs(int i, int n) {
        if(i > n)
            return 0;
        
        if(i == n)
            return 1;
        
        return climbStairs(i+1, n) + climbStairs(i+2, n);
    }
}
