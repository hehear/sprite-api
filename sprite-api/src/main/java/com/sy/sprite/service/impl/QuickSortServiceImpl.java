package com.sy.sprite.service.impl;

import com.sy.sprite.model.QuickSortResult;
import com.sy.sprite.service.IQuickSortService;
import com.sy.sprite.util.SortUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 快速排序算法实现
 * @author dxy
 * @date 2019-12-10
 */
@Service("quickSortService")
public class QuickSortServiceImpl implements IQuickSortService {

    //步骤-全
    private static Integer allStep = 0;
    //步骤-真实的交换，去除不交换的步骤
    private static Integer realStep = 0;

    /**
     * 快速排序算法：
     * 1. 先从数列中取出一个数作为基准数（一般取数组的第一个元素）
     * 2. 取数组最低位和最高位分别为左右游标，左右同时扫描，找到左边>基准的数与右边<基准的数据交换
     * 3. 当右游标<=左游标，即扫描一遍后，将基准数与右游标<基准的数交换，此时基准数左边的数都小于基准数。基准数下标右移一位。
     * 4. 再对左右区间重复第二步，直到各区间只有一个数。
     * @param
     * @throws Exception
     */
    @Override
    public List<QuickSortResult> sort(Comparable[] arrays) throws Exception {

        //将数组随机打乱
        //StdRandom.shuffle(arrays);

        allStep = 0;
        realStep = 0;

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

            } while(SortUtil.less(arrays[var3], var5) && var3 != var2);//从左向右扫描，碰到第一个大于等于基准的数跳出循环，全扫描一遍没有也跳出循环

            do {
                //比较数从右向左
                --var4;
            } while(SortUtil.less(var5, arrays[var4]) && var4 != var1);//从右向左扫描，碰到第一个小于等于基准的数跳出循环，全扫描一遍没有也跳出循环

            //当左右所有的数都与基准数比较完后
            if (var3 >= var4) {

                if(var1!=var4) {
                    //封装交换前排序结果
                    QuickSortResult result = getBeforeChangeQuickSortResult(arrays, var5, var1, var1, var4);

                    //将基准数与右边最后一个小于基准的数交换位置
                    SortUtil.exch(arrays, var1, var4);

                    //封装交换前排序后结果
                    result = getAfterChangeQuickSortResult(result, arrays,var1,var2,var3,var4);

                    resultList.add(result);

                    //打印数组
                    SortUtil.show(arrays);
                }
                //返回基准数新的位置，此时基准左边都是小于基准的数，右边都是大于基准的数
                return var4;
            }

            if(var3!=var4){

                //封装交换排序前排序结果
                QuickSortResult result = getBeforeChangeQuickSortResult(arrays,var5,var1,var3, var4);

                //将左边大于基准和右边小于基准的数交换位置，然后继续扫描左右
                SortUtil.exch(arrays, var3, var4);

                //封装交换后排序结果
                result = getAfterChangeQuickSortResult(result,arrays, var1, var2,var3,var4);

                resultList.add(result);
            }


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
    private static QuickSortResult getBeforeChangeQuickSortResult(Comparable[] arrays, Comparable var5, int var0,int var1, int var4) {

        //拷贝数组
        Comparable[] resultArrays = arrays.clone();
        //获得对象
        QuickSortResult result = new QuickSortResult();
        //操作之前的数组
        result.setBeforeArrays(resultArrays);

        //基准数
        result.setKeyNum(var5);
        result.setKeyNumIndex(var0);
        //比较数1
        result.setCompareNum1Index(var1);
        result.setCompareNum1(resultArrays[var1]);
        //比较数2
        result.setCompareNum2Index(var4);
        result.setCompareNum2(resultArrays[var4]);
        //比较规则
        result.setCompareRule("asc");
        //交换数1
        result.setExchangeNum1Index(var1);
        result.setExchangeNum1(resultArrays[var1]);
        //交换数2
        result.setExchangeNum2Index(var4);
        result.setExchangeNum2(resultArrays[var4]);
        //是否交换
        result.setIsChanged("1");

        return result;
    }

    /**
     * 封装排序结果
     * @param var5
     * @param var4
     * @param arrays
     * @param var1
     * @param var2
     * @return
     */
    private static QuickSortResult getAfterChangeQuickSortResult(QuickSortResult result, Comparable[] arrays, int var1, int var2,int leftIndex,int rightIndex) {

        //拷贝数组
        Comparable[] resultArrays = arrays.clone();
        // 排序后的数组
        result.setAfterArrays(resultArrays);
        //组内开始下标
        result.setStartNumIndex(var1);
        //组内截止下标
        result.setEndNumIndex(var2);
        //左游标
        result.setLeftIndex(leftIndex);
        //右游标
        result.setRightIndex(rightIndex);

        //排序步骤-全
        allStep = allStep+1;
        result.setAllStep(allStep);
        //实际排序步骤
        realStep = realStep+1;
        result.setRealStep(realStep);

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
