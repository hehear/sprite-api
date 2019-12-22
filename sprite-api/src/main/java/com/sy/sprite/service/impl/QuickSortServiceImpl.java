package com.sy.sprite.service.impl;

import com.sy.sprite.model.QuickSortResult;
import com.sy.sprite.service.IQuickSortService;
import com.sy.sprite.util.SortUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description 快速排序算法实现
 * @author dxy
 * @date 2019-12-10
 */
@Service("quickSortService")
public class QuickSortServiceImpl implements IQuickSortService {

    //步骤
    private static Integer step = 0;

    /**
     * 快速排序算法：
     * 1. 先从数列中取出一个数作为基准数（一般取数组的第一个元素）
     * 2. 将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
     * 3. 再对左右区间重复第二步，直到各区间只有一个数。
     * @param
     * @throws Exception
     */
    @Override
    public List<QuickSortResult> sort(Comparable[] arrays) throws Exception {

        //将数组随机打乱
        //StdRandom.shuffle(arrays);

        List<QuickSortResult> resultList  = new ArrayList<>();

        //快速排序，将数组的第一个元素作为第一个
        sort(resultList,arrays, 0, arrays.length - 1);

        //验证是否有序
        assert SortUtil.isSorted(arrays);

        return resultList;

    }

    /**
     * 快速排序
     * @param arrays 需要排序的数组
     * @param var1 基准数的下标
     * @param var2 比较数的下标
     */
    private static void sort(List<QuickSortResult> resultList,Comparable[] arrays, int var1, int var2) {

        //如果比较数数组下标 > 基准数，当切分数组只剩一个元素停止递归
        if (var2 > var1) {
            //切分，将数组以基准数为分割点，左边都是小于基准的数，右边都是大于基准的数
            int var3 = partition(resultList,arrays, var1, var2);
            //递归，将左半部分排序
            sort(resultList,arrays, var1, var3 - 1);
            //递归，将右半部分排序
            sort(resultList,arrays, var3 + 1, var2);

            assert SortUtil.isSorted(arrays, var1, var2);

        }
    }

    /**
     * 切分
     * 将小于基准的数放在基准数的左边，大于基准的数放在基准数右边
     * 返回基准数的最后位置
     * @param arrays 数组
     * @param var1 基准数
     * @param var2 比较数
     * @return 基准数最后位置
     */
    private static int partition(List<QuickSortResult> resultList,Comparable[] arrays, int var1, int var2) {

        //基准数下标
        int var3 = var1;
        //比较数下标右移
        int var4 = var2 + 1;

        //基准数
        Comparable var5 = arrays[var1];

        while(true) {

            do {
                //比较数从左向右
                ++var3;

            } while(SortUtil.less(arrays[var3], var5) && var3 != var2);//从左向右扫描，碰到第一个大于基准的数跳出循环，全扫描一遍没有也跳出循环

            do {
                //比较数从右向左
                --var4;
            } while(SortUtil.less(var5, arrays[var4]) && var4 != var1);//从右向左扫描，碰到第一个小于基准的数跳出循环，全扫描一遍没有也跳出循环

            //如果左边第一个大于基准的数的位置 大于 右边第一个小于基准的数的位置
            if (var3 >= var4) {

                //封装排序结果
                QuickSortResult result = getQuickSortResult(arrays,var5,var1,var4);

                //将基准数与右边第一个小于基准的数交换位置
                SortUtil.exch(arrays, var1, var4);

                //操作之后的数组
                Comparable[] resultArrays = arrays.clone();
                result.setAfterArrays(resultArrays);
                resultList.add(result);

                //打印数组
                SortUtil.show(arrays);
                //返回基准数新的位置，此时基准左边都是小于基准的数，右边都是大于基准的数
                return var4;
            }

            //封装排序结果
            QuickSortResult result = getQuickSortResult(arrays,var5,var3, var4);

            //将左边大于基准和右边小于基准的数交换位置，然后继续扫描左右
            SortUtil.exch(arrays, var3, var4);

            //操作之后的数组
            Comparable[] resultArrays = arrays.clone();
            result.setAfterArrays(resultArrays);
            resultList.add(result);

            //打印数组
            SortUtil.show(arrays);
        }
    }

    /**
     * 封装排序结果
     * @param arrays
     * @param var5
     * @param var1
     * @param var4
     * @return
     */
    private static QuickSortResult getQuickSortResult(Comparable[] arrays, Comparable var5, int var1, int var4) {

        //拷贝数组
        Comparable[] resultArrays = arrays.clone();
        //获得对象
        QuickSortResult result = new QuickSortResult();
        //操作之前的数组
        result.setBeforeArrays(resultArrays);
        //步骤
        step = step+1;
        result.setStep(step);
        //基准数
        result.setKeyNum(var5);
        //交换数1
        Map exchange1 = new HashMap<>();
        exchange1.put(var1,resultArrays[var1]);
        result.setExchangeNum1(exchange1);
        //交换数2
        Map exchange2 = new HashMap<>();
        exchange2.put(var4,resultArrays[var4]);
        result.setExchangeNum2(exchange2);
        return result;
    }

//    public static void main(String[] args) {
//
//
//        Integer[] arrays = new Integer[]{12,12,4,23,12,11,24,66,12,34,12,56,12,98,12,34,12};
//        sort(new ArrayList<>(),arrays, 0, arrays.length - 1);
//        SortUtil.show(arrays);
//    }

}
