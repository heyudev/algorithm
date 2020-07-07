package com.heyudev.algorithm.arrays;

import java.util.*;

/**
 * 两数之和
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * https://leetcode-cn.com/problems/two-sum/
 *
 * @author heyudev
 * @date 2020/07/07
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 4, 5, 8, 11, 19};
        int target = 15;

        System.out.println(Arrays.toString(towSum1(nums, target)));

        System.out.println(Arrays.toString(towSum2(nums, target)));

    }

    /**
     * 解法1
     *
     * 双层循环判断
     *
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(n)
     */

    /**
     * 解法2 两遍hash表
     * <p>
     * target-减法
     * 使用set hash表（时间复杂度都是O(1)）
     *
     * <p>
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] towSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
        }
        return null;
    }

    /**
     * 解法3 一遍hash表
     * 没有要求索引顺序
     * <p>
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] towSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return null;
    }

}
