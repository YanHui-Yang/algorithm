package com.yyh.algorithm.array;

import org.junit.Assert;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * <p>
 * https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * <p>
 * 找出数组中重复的数字。
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 */
public class _03_数组中重复的数字 {

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 1, 0, 2, 5, 3};
        int ret1 = findRepeatNumber4(array);
        System.out.println(ret1);
        Assert.assertTrue(ret1 == 2 || ret1 == 3);
    }

    // 使用Set
    public static int findRepeatNumber1(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("参数错误");
        }

        Set<Integer> set = new HashSet<>();

        for (int num : array) {
            if (!set.add(num)) {
                return num;
            }
        }

        throw new IllegalArgumentException("无重复数字");
    }

    // 下标=值
    public static int findRepeatNumber2(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("参数错误");
        }

        for (int i = 0; i < array.length; i++) {
            // 第一个数字是0，continue
            if (i == array[i]) {
                continue;
            }
            if (array[i] != array[array[i]]) {
                swap(i, array[i], array);
            } else {
                return array[i];
            }
        }

        return 0;
    }

    private static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // 设置一个布尔数组，第一次查找到则设置为True，后面如果booleans[i]为True则重复
    public static int findRepeatNumber3(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("参数错误");
        }

        boolean[] extar = new boolean[array.length];
        // [2, 3, 1, 0, 2, 5, 3]
        for (int num : array) {
            if (extar[num]) {
                return num;
            }
            extar[num] = true;
        }

        throw new IllegalArgumentException("无重复数字");
    }

    // 排序对比
    public static int findRepeatNumber4(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("参数错误");
        }

        Arrays.sort(array);
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                return array[i];
            }
        }
        return -1;
    }
}
