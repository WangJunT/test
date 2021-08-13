package com.jy.dongtaiguihua;

import java.util.Arrays;

/**
 * 给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，每种硬币的数量无限，
 * 再给一个总金额 amount，问你最少需要几枚硬币凑出这个金额，
 * 如果不可能凑出，算法返回 -1 。算法的函数签名如下：
 * https://labuladong.gitee.io/algo/1/3/
 */
public class ChangeCoin {
    static int min = -1;

    static int coinChange(int[] coins, int amount) {
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > amount) {
                break;
            }
            coinChangeReal(1, i, coins, amount - coins[i]);
        }
        return min;
    }

    /**
     * @param count  次数
     * @param index  角标
     * @param coins  硬币数组
     * @param amount 总金额
     */
    private static void coinChangeReal(int count, int index, int[] coins, int amount) {
        if (amount == 0) {
            min = min == -1 ? count : (min < count ? min : count);
        }
        for (int i = index; i < coins.length; i++) {
            if (coins[i] > amount) {
                break;
            }
            coinChangeReal(count + 1, i, coins, amount - coins[i]);
        }
    }

    public static void main(String[] args) {
//        int[] coins = {4, 5, 3, 2, 1};
//        int amount = 5;
        int[] coins = {1, 2, 5};
        int amount = 11;
        Arrays.sort(coins);
        System.out.println(coinChange(coins, amount));
    }
}
