package com.sy.sprite.util;

import java.util.Comparator;

/**
 * @description 排序工具类
 * @author dxy
 * @date 2019-12-11
 */
public class SortUtil {

    /**
     * 元素比较
     * @param var0
     * @param var1
     * @return var0<var1 则返回true
     */
    public static boolean less(Comparable var0, Comparable var1) {
        return var0.compareTo(var1) < 0;
    }

    public static boolean less(Object v, Object w, Comparator comparator) {
        return comparator.compare(v, w) < 0;
    }

    /**
     * 元素比较
     * @param var0
     * @param var1
     * @param var2
     * @return
     */
    public static boolean less(Comparable[] var0, int var1, int var2) {
        return var0[var1 - 1].compareTo(var0[var2 - 1]) < 0;
    }


    /**
     * 元素交换
     * @param var0 数组
     * @param var1 下标1
     * @param var2 下标2
     */
    public static void exch(Object[] var0, int var1, int var2) {
        Object var3 = var0[var1];
        var0[var1] = var0[var2];
        var0[var2] = var3;
    }

    /**
     * 数组是否有序
     * @param var0
     * @return
     */
    public static boolean isSorted(Comparable[] var0) {
        return isSorted(var0, 0, var0.length - 1);
    }

    public static boolean isHsorted(Comparable[] var0, int var1) {
        for(int var2 = var1; var2 < var0.length; ++var2) {
            if (less(var0[var2], var0[var2 - var1])) {
                return false;
            }
        }

        return true;
    }

    /**
     * 判断数组中元素1到元素2是否有序
     * @param var0 数组
     * @param var1 元素1
     * @param var2 元素2
     * @return
     */
    public static boolean isSorted(Comparable[] var0, int var1, int var2) {
        for(int var3 = var1 + 1; var3 <= var2; ++var3) {
            if (less(var0[var3], var0[var3 - 1])) {
                return false;
            }
        }

        return true;
    }

    /**
     * 遍历打印数组换行
     * @param var0
     */
    public static void showLn(Comparable[] var0) {
        for(int var1 = 0; var1 < var0.length; ++var1) {
            System.out.println(var0[var1]);
        }

    }

    /**
     * 遍历打印数组不换行
     * @param var0
     */
    public static void show(Comparable[] var0) {
        for(int var1 = 0; var1 < var0.length; ++var1) {
            System.out.print(var0[var1]+"  ");
        }
        System.out.println();

    }
}
