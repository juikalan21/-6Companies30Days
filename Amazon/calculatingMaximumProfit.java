class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[k+1][n];
        
        if(n < 2) return 0;
        
        for(int i = 1; i <= k; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j-1], helper(i, j, prices, dp));
            }
        }
        
        return dp[k][n-1];
        
    }
    
    private int helper(int k, int x, int[] prices, int[][] dp){
        int max = 0;
        for(int i = 0; i < x; i++) {
            //Sell on day_x, buy on day_i and add profit from (i-1) transsactions dp[k-1][i]
            max = Math.max(max, prices[x]-prices[i] + dp[k-1][i]);
        }
        return max;
    }
}