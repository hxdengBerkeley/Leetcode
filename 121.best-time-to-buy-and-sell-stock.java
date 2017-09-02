public class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        int hold=Integer.MIN_VALUE;
        for (int x:prices) {
            profit = Math.max(profit,hold+x);
            hold = Math.max(hold,-x);
        }
        return profit;
    }
}