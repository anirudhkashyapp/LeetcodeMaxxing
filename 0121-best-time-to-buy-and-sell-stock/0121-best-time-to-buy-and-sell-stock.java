class Solution {
    public int maxProfit(int[] prices) {
        int minimum=prices[0];
        int profit=0;
        int n =prices.length;

        for(int i = 1; i<n; i++){
            int cost=prices[i]-minimum;
            profit=Math.max(profit,cost);
            minimum=Math.min(minimum,prices[i]);
        }
        return profit;
    }

}