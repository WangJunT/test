package com.jy.dongtaiguihua.mianshi;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个长度至少为 3 的子序列，其中每个子序列都由连续整数组成。
 * <p>
 * 如果可以完成上述分割，则返回 true ；否则，返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPossible {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> have = new HashMap<>();
        Map<Integer, Integer> need = new HashMap<>();
        for (int a : nums) {
            have.put(a, have.getOrDefault(a, 0) + 1);
        }
        for (int a : nums) {
            if (!have.containsKey(a)) {
                continue;
            } else if (need.containsKey(a)) {
                int hava_count = have.get(a);
                if (hava_count > 1) {
                    have.put(a, hava_count - 1);
                } else {
                    have.remove(a);
                }

                int need_count = need.get(a);
                if (need_count > 1) {
                    need.put(a, need_count - 1);
                } else {
                    need.remove(a);
                }
                need.put(a + 1, need.getOrDefault(a + 1, 0) + 1);
            } else if (have.containsKey(a + 1) && have.containsKey(a + 2)) {
                int hava_1 = have.get(a);
                if (hava_1 > 1) {
                    have.put(a, hava_1 - 1);
                } else {
                    have.remove(a);
                }

                int hava_2 = have.get(a + 1);
                if (hava_2 > 1) {
                    have.put(a + 1, hava_2 - 1);
                } else {
                    have.remove(a + 1);
                }

                int hava_3 = have.get(a + 2);
                if (hava_3 > 1) {
                    have.put(a + 2, hava_3 - 1);
                } else {
                    have.remove(a + 2);
                }

                need.put(a + 3, need.getOrDefault(a + 3, 0) + 1);

            } else {
                return false;
            }
        }
        return true;
    }
}
