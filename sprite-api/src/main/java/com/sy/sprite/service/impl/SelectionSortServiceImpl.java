package com.sy.sprite.service.impl;

import com.sy.sprite.model.SelectionSortResult;
import com.sy.sprite.service.ISelectionSortService;
import com.sy.sprite.util.SortUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.sy.sprite.util.SortUtil.exch;
import static com.sy.sprite.util.SortUtil.less;

/**
 * @description 选择排序算法实现
 * @author dxy
 * @date 2019-12-19
 */
@Service("selectionSortService")
public class SelectionSortServiceImpl implements ISelectionSortService {

    //步骤-全
    private static Integer allStep = 0;
    //步骤-真实的交换，去除不交换的步骤
    private static Integer realStep = 0;

    /**
     * 选择排序算法：
     * 1.遍历比较，选出数组中最小的元素，放在数组的第1个位置（即与数组第1位置的元素交换位置）
     * 2.然后在从数组第2的位置开始遍历比较，找出剩下数组中最小的元素，放在数组的第2个位置（即与数组第2位置的元素交换位置）
     * 3.依次类推，知道将数组的所有元素排序完成
     * @param
     * @throws Exception
     */
    @Override
    public List<SelectionSortResult> sort(Comparable[] arrays) throws Exception {

        //将数组随机打乱
        //StdRandom.shuffle(arrays);

        List<SelectionSortResult> resultList  = new ArrayList<>();

        //打印数组
        SortUtil.show(arrays);
        //数组长度
        int arrayLength = arrays.length;

        for(int i = 0; i < arrayLength-1; i++) {
            //最小数的下标
            int minIndex = i;

            for(int j = i + 1; j < arrayLength; j++) {
                //比较获得最小值
                if (less(arrays[j], arrays[minIndex])) {
                    //最小下标赋值
                    minIndex = j;
                }
            }
            //如果拿去的数就是最小数，不需要交换
            if (i != minIndex) {

                // 交换前封装
                SelectionSortResult selection = getBeforeBubbleSortResult(arrays,i,minIndex,minIndex);

                //最小数交换到遍历位置
                exch(arrays, i, minIndex);

                // 交换后封装
                selection = getAfterBubbleSortResult(selection,arrays);

                resultList.add(selection);

                //打印数组
                SortUtil.show(arrays);


            } else {

                //不交换，封装结果
                SelectionSortResult selection = getNoChangeBubbleSortResult(arrays,i,minIndex);

                resultList.add(selection);

            }
        }
        //验证是否有序
        assert SortUtil.isSorted(arrays);

        return resultList;

    }

    /**
     * 封装不交换结果
     * @param arrays
     * @param i
     * @param j
     * @return
     */
    private SelectionSortResult getNoChangeBubbleSortResult(Comparable[] arrays, int i, int j) {

        //拷贝数组
        Comparable[] resultArrays = arrays.clone();

        SelectionSortResult selection = new SelectionSortResult();
        //排序前的数组
        selection.setBeforeArrays(resultArrays);
        //排序后
        selection.setAfterArrays(resultArrays);
        //排序步骤-全，没交换排序步骤也+1
        allStep = allStep+1;
        selection.setAllStep(allStep);
        //实际排序步骤，没交换，真实排序步骤不加1
        selection.setRealStep(realStep);
        //比较数1
        selection.setCompareNum1Index(j);
        selection.setCompareNum1(resultArrays[j]);
        //比较数2
        selection.setCompareNum2Index(i);
        selection.setCompareNum2(resultArrays[i]);
        //比较规则
        selection.setCompareRule("asc");
        //是否交换
        selection.setIsChanged("0");
        //最小数
        selection.setMinIndex(j);
        selection.setMinNum(resultArrays[j]);

        return selection;
    }

    /**
     * 封装交换后结果
     * @param selection
     * @param arrays
     * @return
     */
    private SelectionSortResult getAfterBubbleSortResult(SelectionSortResult selection, Comparable[] arrays) {

        //拷贝数组
        Comparable[] resultArrays = arrays.clone();

        //交换后的数组
        selection.setAfterArrays(resultArrays);

        //排序步骤-全
        allStep = allStep+1;
        selection.setAllStep(allStep);
        //实际排序步骤
        realStep = realStep+1;
        selection.setRealStep(realStep);

        return selection;

    }

    /**
     * 封装交换前结果
     * @param arrays
     * @param i
     * @param minIndex
     * @return
     */
    private SelectionSortResult getBeforeBubbleSortResult(Comparable[] arrays, int i, int j, int minIndex) {

        //拷贝数组
        Comparable[] resultArrays = arrays.clone();

        SelectionSortResult selection = new SelectionSortResult();
        //排序前的数组
        selection.setBeforeArrays(resultArrays);
        //比较数1
        selection.setCompareNum1Index(j);
        selection.setCompareNum1(resultArrays[j]);
        //比较数2
        selection.setCompareNum2Index(i);
        selection.setCompareNum2(resultArrays[i]);
        //比较规则
        selection.setCompareRule("asc");
        //交换数1
        selection.setExchangeNum1Index(j);
        selection.setExchangeNum1(resultArrays[j]);
        //交换数2
        selection.setExchangeNum2Index(i);
        selection.setExchangeNum2(resultArrays[i]);
        //是否交换
        selection.setIsChanged("1");
        //最小数
        selection.setMinIndex(minIndex);
        selection.setMinNum(resultArrays[minIndex]);

        return selection;

    }


//    public static void main(String[] args) {
//
//
//        Integer[] arrays = new Integer[]{12,12,4,23,12,11,24,66,12,34,12,56,12,98,12,34,12};
//        sort(new ArrayList<>(),arrays, 0, arrays.length - 1);
//        SortUtil.show(arrays);
//    }

}
