/**
 * Creator : wangtaishan
 * Date : 2018/8/27
 * Title : 309. Best Time to Buy and Sell Stock with Cooldown
 * Description :
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 *
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * Example:
 *
 * Input: [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 *
 * Analysis :
 *
 * sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
 * buy[i] = Math.max(sell[i - 2] - prices[i], buy[i - 1]);
 *
 */

public class BestTimetoBuyandSellStockwithCooldown {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        int b1 = -prices[0];
        int s1 = 0;
        int s2 = s1;
        int s0 = 0;
        int b0 = 0;
        for(int i = 1; i < prices.length; i++){
            s0 = Math.max(s1, b1 + prices[i]);
            b0 = Math.max(s2 - prices[i], b1);
            s2 = s1;
            s1 = s0;
            b1 = b0;
        }
        return s0;
    }

    public int old_maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        sell[0] = 0;
        for(int i = 1; i < prices.length; i++){
            if(i != 1){
                sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
                buy[i] = Math.max(sell[i - 2] - prices[i], buy[i - 1]);
            }
            else{
                sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
                buy[i] = Math.max(sell[i - 1] - prices[i], buy[i - 1]);
            }
        }
        return sell[prices.length - 1];
    }
}
