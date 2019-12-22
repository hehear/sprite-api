package com.sy.sprite.service.impl;

import com.sy.sprite.model.QuickSortResult;
import com.sy.sprite.service.IMergeSortService;
import com.sy.sprite.util.SortUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 归并排序算法实现
 * @author dxy
 * @date 2019-12-13
 */
@Service("mergeSortService")
public class MergeSortServiceImpl implements IMergeSortService {

    //步骤
    private static Integer step = 0;

    /**
     * 归并排序算法：
     * 1.将数组折半切分，递归切分至数组至少有两个元素(即将数组二分法的方式拆为一个个小的数组)
     * 2.将最小单位的数组排序，然后按照切分时的顺序，依次合并数组，再排序
     * 3.小数组排序合并成原来的数组，即排序完成
     * @param
     * @throws Exception
     */
    @Override
    public List<QuickSortResult> sort(Comparable[] arrays) throws Exception {

        //将数组随机打乱
        //StdRandom.shuffle(arrays);

        List<QuickSortResult> resultList  = new ArrayList<>();
        //TODO 只有排序算法代码，未解析注释，待设计model封装排序结果

        Comparable[] arrays1 = new Comparable[arrays.length];
        sort(arrays, arrays1, 0, arrays.length - 1);

        //验证是否有序
        assert SortUtil.isSorted(arrays);

        return resultList;

    }

    /**
     * 归并算法
     * @param arrays0 待排序数组
     * @param arrays1 空数组
     * @param low 数组低位
     * @param high 数组高位
     */
    private static void sort(Comparable[] arrays0, Comparable[] arrays1, int low, int high) {

        //数组高位>数组低位
        if (high > low) {
            //数组平均分成两半
            int middle = low + (high - low) / 2;

            //前半段继续切分排序
            sort(arrays0, arrays1, low, middle);
            //后半段继续切分排序
            sort(arrays0, arrays1, middle + 1, high);

            //合并排序
            merge(arrays0, arrays1, low, middle, high);
        }
    }

    /**
     * 合并并排序，将数组arrays[low,middle] arrays[low,middle] 合并并排序
     * @param arrays0
     * @param arrays1
     * @param low
     * @param middle
     * @param high
     */
    private static void merge(Comparable[] arrays0, Comparable[] arrays1, int low, int middle, int high) {

        //指针
        int pointer0;
        //arrays0数组拷贝到arrays1
        for(pointer0 = low; pointer0 <= high; ++pointer0) {
            arrays1[pointer0] = arrays0[pointer0];
        }

        //指针重新指到低位
        pointer0 = low;

        //右侧新的低位
        int lowRight = middle + 1;

        //遍历重新赋值数组
        for(int pointer1 = low; pointer1 <= high; ++pointer1) {

            if (pointer0 > middle) {
                //指针0扫过中间位
                //将数组右侧的低位的值依次从左侧低位赋值，然后右侧低位指针右移
                arrays0[pointer1] = arrays1[lowRight++];
            } else if (lowRight > high) {
                //右侧低位指针移过最高位，即指针0扫过一半的数组
                //右边的值正常赋值
                arrays0[pointer1] = arrays1[pointer0++];
            } else if (SortUtil.less(arrays1[lowRight], arrays1[pointer0])) {
                //右半段的值 < 左半段的值，右边的值赋值到左面
                arrays0[pointer1] = arrays1[lowRight++];
            } else {
                //左边的值 < 右边的值，左边值正常赋值
                arrays0[pointer1] = arrays1[pointer0++];
            }
            //打印数组
            SortUtil.show(arrays0);

        }

    }

//    public static void main(String[] args) {
//
//
//        Integer[] arrays = new Integer[]{12,12,4,23,12,11,24,66,12,34,12,56,12,98,12,34,12};
//        sort(new ArrayList<>(),arrays, 0, arrays.length - 1);
//        SortUtil.show(arrays);
//    }

}
