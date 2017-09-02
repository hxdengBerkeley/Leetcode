public class Solution {
    public int maxProfit(int[] prices) {
        int profit1=0, profit2=0;
        int hold1=Integer.MIN_VALUE, hold2=Integer.MIN_VALUE;
        for (int x:prices) {
            profit2 = Math.max(profit2,hold2+x);
            hold2 = Math.max(hold2,profit1-x);
            profit1 = Math.max(profit1,hold1+x);
            hold1 = Math.max(hold1,-x);
        }
        return profit2;
    }
}