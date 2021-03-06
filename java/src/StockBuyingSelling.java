/**
 * 题目：714 股票交易，给一组数组，每个元素代表当天股票的价格，买卖股票收取一定的费用，同一天只能买或者卖，买股票必须先把手中的股票卖掉。
 *
 * eg.   Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
         Output: 8
         Explanation: The maximum profit can be achieved by:
         Buying at prices[0] = 1
         Selling at prices[3] = 8
         Buying at prices[4] = 4
         Selling at prices[5] = 9
         The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 *
 * 一开始思路用动态规划，从左到右，拿当前到元素跟之前到每一个元素相减。用的是LCS的思想，结果O(N^2)超时
 *
 * 正确思路，贪心，用cash来代表手里没有股票的利润，hold代表手里有股票的利润，cash 到最后肯定是比hold大的。
 *
 * 因为是需要先买股票，所以最开始需要第一个元素作为hold的值。一开始手里没有股票所以cash为0。
 *
 * 然后决策，卖出去后的利润和不持有这支股票的利润哪个大。
 *
 * 现在的cash是最佳决策，利用 cash 来决策 hold。保持之前的股票，还是保持当前的股票。这里目的在于找当前情况下，买入价格最小的股票。
 *
 *
 *
 *
 */

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee); //决定 卖还是不卖
            hold = Math.max(hold, cash - prices[i]);//
        }
        return cash;
    }
}