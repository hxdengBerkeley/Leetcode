public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        if (prices.length==0) return profit;
        int start = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i]<prices[i-1]){
                profit+=prices[i-1]-start;
                start = prices[i];
            }
        }
        profit+=prices[prices.length-1]-start;
        return profit;
    }
}