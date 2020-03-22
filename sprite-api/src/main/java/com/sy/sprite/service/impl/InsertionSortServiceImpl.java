package com.sy.sprite.service.impl;

import com.sy.sprite.model.InsertionSortResult;
import com.sy.sprite.service.IInsertionSortService;
import com.sy.sprite.util.SortUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 插入排序算法实现
 * @author dxy
 * @date 2019-12-13
 */
@Service("insertionSortService")
public class InsertionSortServiceImpl implements IInsertionSortService {

    //步骤-全
    private static Integer allStep = 0;
    //步骤-真实的交换，去除不交换的步骤
    private static Integer realStep = 0;

    /**
     * 插入排序算法：
     * 1.认定数组前n-1的元素是有序的，在拿第n个元素时，与前n-1个元素做比较，插入相应的位置
     * 2.开始时，从第二个元素开始拿，与第一个元素比较，比第一个元素大插在它的右边，小插到左边
     * 3.再拿第三个元素，与前两个元素比较，插入适当的位置，依次类推，直到数组排序完成。
     * @param
     * @throws Exception
     */
    @Override
    public List<InsertionSortResult> sort(Comparable[] arrays) throws Exception {

        //将数组随机打乱
        //StdRandom.shuffle(arrays);

        List<InsertionSortResult> resultList  = new ArrayList<>();
        //打印数组
        SortUtil.show(arrays);

        //数组长度
        int arrLength = arrays.length;
        //元素从第2个开始拿，所有遍历arrLength-1即可
        for (int i = 0; i < arrLength-1; i++) {
            //拿的元素与前面的所有元素比较
            for (int j = i+1; j > 0; j--) {
                //如果拿的元素与比较的元素小，则交换位置
                if(SortUtil.less(arrays[j], arrays[j-1])) {

                    // 交换前封装
                    InsertionSortResult insertion = getBeforeBubbleSortResult(arrays,j,j-1,j);


                    //交换
                    SortUtil.exch(arrays, j, j - 1);
                    //打印数组
                    SortUtil.show(arrays);

                    // 交换后封装
                    insertion = getAfterBubbleSortResult(insertion,arrays);

                    resultList.add(insertion);


                }else{

                    //未交换
                    InsertionSortResult insertion = getNoChangeBubbleSortResult(arrays,j,j-1);

                    resultList.add(insertion);

                    //由于前面的数组是有序的，在与比较元素相比大的话即已插入正确的位置，即可退出循环比较
                    break;
                }
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
    private InsertionSortResult getNoChangeBubbleSortResult(Comparable[] arrays, int i, int j) {

        //拷贝数组
        Comparable[] resultArrays = arrays.clone();

        InsertionSortResult insertion = new InsertionSortResult();
        //排序前的数组
        insertion.setBeforeArrays(resultArrays);
        //排序后
        insertion.setAfterArrays(resultArrays);
        //排序步骤-全，没交换排序步骤也+1
        allStep = allStep+1;
        insertion.setAllStep(allStep);
        //实际排序步骤，没交换，真实排序步骤不加1
        insertion.setRealStep(realStep);
        //比较数1
        insertion.setCompareNum1Index(j);
        insertion.setCompareNum1(resultArrays[j]);
        //比较数2
        insertion.setCompareNum2Index(i);
        insertion.setCompareNum2(resultArrays[i]);
        //比较规则
        insertion.setCompareRule("asc");
        //是否交换
        insertion.setIsChanged("0");
        //插入数
        insertion.setInsertIndex(i);
        insertion.setInsertNum(resultArrays[i]);


        return insertion;
    }

    /**
     * 封装交换后结果
     * @param selection
     * @param arrays
     * @return
     */
    private InsertionSortResult getAfterBubbleSortResult(InsertionSortResult selection, Comparable[] arrays) {

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
     * @param insertIndex
     * @return
     */
    private InsertionSortResult getBeforeBubbleSortResult(Comparable[] arrays, int i, int j, int insertIndex) {

        //拷贝数组
        Comparable[] resultArrays = arrays.clone();

        InsertionSortResult insertion = new InsertionSortResult();
        //排序前的数组
        insertion.setBeforeArrays(resultArrays);
        //比较数1
        insertion.setCompareNum1Index(j);
        insertion.setCompareNum1(resultArrays[j]);
        //比较数2
        insertion.setCompareNum2Index(i);
        insertion.setCompareNum2(resultArrays[i]);
        //比较规则
        insertion.setCompareRule("asc");
        //交换数1
        insertion.setExchangeNum1Index(j);
        insertion.setExchangeNum1(resultArrays[j]);
        //交换数2
        insertion.setExchangeNum2Index(i);
        insertion.setExchangeNum2(resultArrays[i]);
        //是否交换
        insertion.setIsChanged("1");
        //插入数
        insertion.setInsertIndex(insertIndex);
        insertion.setInsertNum(resultArrays[insertIndex]);


        return insertion;

    }



//    public static void main(String[] args) {
//
//
//        Integer[] arrays = new Integer[]{12,12,4,23,12,11,24,66,12,34,12,56,12,98,12,34,12};
//        sort(new ArrayList<>(),arrays, 0, arrays.length - 1);
//        SortUtil.show(arrays);
//    }

}
