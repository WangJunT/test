package com.jy.dongtaiguihua.gupiao;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2：
 * <p>
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class MaxProfit {
    //
    public static void main(String[] args) {
        maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4});
        System.out.println(1);
    }

    /**
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //这个k只能一次，这里就确定只能买一次股票了
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    //状态转移方程没有太理解
    public int maxProfit2(int[] prices) {
        int dp_0 = 0, dp_1 = -prices[0];
        for (int i = 0; i < prices.length; i++) {
            dp_0 = Math.max(dp_0, dp_1 + prices[i]);
            dp_1 = Math.max(dp_1, -prices[i]);
        }
        return dp_0;
    }
//    int k = 2;
//    int[][][] dp = new int[prices.length][k+1][2];
//        for (int i  = 0; i < prices.length; i++) {
//        for(int j = k;k>=1;k--) {
//            if (i == 0) {
//                dp[i][j][0] = 0;
//                dp[i][j][1] = -prices[i];
//                continue;
//            }
//            dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
//
//            dp[i][j][1] = Math.max(dp[i - 1][j][1],dp[i - 1][j-1][0] -prices[i]);
//        }
//    }
//        return dp[prices.length - 1][k][0];

    //https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/submissions/
    public static int maxProfit(int[] prices) {
        int k = 2;
        int[][][] dp = new int[prices.length][k + 1][2];
        for (int i = 0; i < prices.length; i++) {
            for (int j = k; j >= 1; j--) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);

                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[prices.length - 1][k][0];
    }

}
