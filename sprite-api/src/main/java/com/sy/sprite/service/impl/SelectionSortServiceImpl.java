package com.sy.sprite.service.impl;

import com.sy.sprite.model.QuickSortResult;
import com.sy.sprite.service.IMergeSortService;
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

    //步骤
    private static Integer step = 0;

    /**
     * 选择排序算法：
     * 1.遍历比较，选出数组中最小的元素，放在数组的第1个位置（即与数组第1位置的元素交换位置）
     * 2.然后在从数组第2的位置开始遍历比较，找出剩下数组中最小的元素，放在数组的第2个位置（即与数组第2位置的元素交换位置）
     * 3.依次类推，知道将数组的所有元素排序完成
     * @param
     * @throws Exception
     */
    @Override
    public List<QuickSortResult> sort(Comparable[] arrays) throws Exception {

        //将数组随机打乱
        //StdRandom.shuffle(arrays);

        List<QuickSortResult> resultList  = new ArrayList<>();
        //TODO 只有排序算法代码，未解析注释，待设计model封装排序结果

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
                //最小数交换到遍历位置
                exch(arrays, i, minIndex);
                //打印数组
                SortUtil.show(arrays);
            }
        }
        //验证是否有序
        assert SortUtil.isSorted(arrays);

        return resultList;

    }



//    public static void main(String[] args) {
//
//
//        Integer[] arrays = new Integer[]{12,12,4,23,12,11,24,66,12,34,12,56,12,98,12,34,12};
//        sort(new ArrayList<>(),arrays, 0, arrays.length - 1);
//        SortUtil.show(arrays);
//    }

}
