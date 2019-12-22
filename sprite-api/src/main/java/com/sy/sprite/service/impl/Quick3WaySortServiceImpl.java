package com.sy.sprite.service.impl;

import com.sy.sprite.model.Quick3WaySortResult;
import com.sy.sprite.service.IQuick3WaySortService;
import com.sy.sprite.util.SortUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description 三向切分快速排序算法实现
 * @author dxy
 * @date 2019-12-13
 */
@Service("quick3WaySortService")
public class Quick3WaySortServiceImpl implements IQuick3WaySortService {

    //排序步骤
    private static Integer step = 0;

    /**
     * 三向切分快速排序算法：
     * 1.取数列中第一个元素作为基准数
     * 2.取数组最低位和最高位分别为左右游标，指针游标从左到右扫描，小于基准数的放在左游标的左面，
     *   大于基准数的放在右游标的右面，相等的不动。数组被分为小于基准、等于基准、大于基准三部分。
     * 3.再对左右区间重复第二步，直到各区间只有一个数。
     * @param
     * @throws Exception
     */
    @Override
    public List<Quick3WaySortResult> sort(Comparable[] arrays) throws Exception {

        //将数组随机打乱
        //StdRandom.shuffle(arrays);

        List<Quick3WaySortResult> resultList  = new ArrayList<>();

        //快速排序，将数组的第一个元素作为第一个
        sort(resultList,arrays, 0, arrays.length - 1);

        //验证是否有序
        assert SortUtil.isSorted(arrays);

        return resultList;

    }

    /**
     * 三向切分快速排序
     * @param resultList
     * @param arrays
     * @param low
     * @param high
     */
    private static void sort(List<Quick3WaySortResult> resultList,Comparable[] arrays, int low, int high) {

        //如果高位下标 <= 低位下标，即数组中只有一个元素或没有元素，则退出
        if (high <= low){
            return;
        }
        //存储当前左右指针
        int left = low, right = high;
        //拷贝当前左端的数值，作为基准数
        Comparable keyNum = arrays[low];
        //将数组低位下标设为初始游标
        int pointer = low;

        //当游标 <= 右边指针，即游标未扫描完，执行循环
        while (pointer <= right) {

            //游标指针的元素与基准数比较
            int cmp = arrays[pointer].compareTo(keyNum);

            if(cmp < 0){

                //封装排序前数据
                Quick3WaySortResult result = getBeforeQuick3WaySortResult(arrays);

                //小于基准数的放在left的左边，因此指针left和指针i整体右移
                SortUtil.exch(arrays, left++, pointer++);

                //封装排序后数据
                result = getAfterQuick3WaySortResult(result,arrays,left,right,pointer,keyNum,left-1,pointer-1);
                //封装一次操作的排序结果
                resultList.add(result);

                //打印数组
                SortUtil.show(arrays);
            } else if (cmp > 0) {

                //封装排序前数据
                Quick3WaySortResult result = getBeforeQuick3WaySortResult(arrays);

                //大于基准数的放在right右边，因此指针right需要左移
                SortUtil.exch(arrays, pointer, right--);

                //封装排序后数据
                result = getAfterQuick3WaySortResult(result,arrays,left,right,pointer,keyNum,pointer,right+1);
                //封装一次操作的排序结果
                resultList.add(result);

                //打印数组
                SortUtil.show(arrays);
            } else{
                //比较数 = 基准数，位置不动，游标指针右移取下一个元素
                pointer++;

                //封装数据
                Quick3WaySortResult result = getNoneChangeQuick3WaySortResult(arrays,left,right,pointer,keyNum,pointer);
                //封装一次操作的排序结果
                resultList.add(result);
            }
        }

        //left-right之间为基准数和等于基准数的元素，然后递归排序low～left-1，和right+1～high
        sort(resultList,arrays, low, left-1);
        sort(resultList,arrays, right+1, high);

    }

    /**
     * 封装交换后的数据
     * @param result
     * @param arrays
     * @param left
     * @param pointer
     * @return
     */
    private static Quick3WaySortResult getAfterQuick3WaySortResult(Quick3WaySortResult result, Comparable[] arrays, int left,int right, int pointer,Comparable keyNum,int change1,int change2) {

        //数组拷贝
        Comparable[] resultArrays = arrays.clone();
        //交换数1
        Map changeMap1 = new HashMap();
        changeMap1.put(change1,arrays[change1]);
        result.setExchangeNum1(changeMap1);
        //交换数2
        Map changeMap2 = new HashMap();
        changeMap2.put(change1,arrays[change1]);
        result.setExchangeNum2(changeMap2);
        //基准数
        result.setKeyNum(keyNum);
        //游标指针
        result.setPointer(pointer);
        //左游标
        result.setLeft(left);
        //右游标
        result.setRight(right);
        //步骤+1
        step = step+1;
        result.setStep(step);
        //交换后的数组
        result.setAfterArrays(resultArrays);

        return result;
    }

    /**
     * 封装交换前数据
     * @param arrays
     * @return
     */
    private static Quick3WaySortResult getBeforeQuick3WaySortResult(Comparable[] arrays) {

        Quick3WaySortResult result = new Quick3WaySortResult();
        //数组拷贝
        Comparable[] resultArrays = arrays.clone();
        //交换前数组
        result.setBeforeArrays(resultArrays);

        return result;
    }

    /**
     * 封装交换前数据
     * @param arrays
     * @param left
     * @param right
     * @param pointer
     * @param keyNum
     * @param i
     * @return
     */
    private static Quick3WaySortResult getNoneChangeQuick3WaySortResult(Comparable[] arrays, int left, int right, int pointer, Comparable keyNum, int i) {

        Quick3WaySortResult result = new Quick3WaySortResult();
        //数组拷贝
        Comparable[] resultArrays = arrays.clone();
        //交换前数组
        result.setBeforeArrays(resultArrays);
        //交换后
        result.setAfterArrays(resultArrays);
        //基准数
        result.setKeyNum(keyNum);
        //游标指针
        result.setPointer(pointer);
        //左游标
        result.setLeft(left);
        //右游标
        result.setRight(right);
        //步骤+1
        step = step+1;
        result.setStep(step);

        return result;
    }

//    public static void main(String[] args) {
//
//
//        Integer[] arrays = new Integer[]{12,12,4,23,12,11,24,66,12,34,12,56,12,98,12,34,12};
//        sort(null,arrays, 0, arrays.length - 1);
//        SortUtil.show(arrays);
//    }

}
