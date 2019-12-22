package com.sy.sprite.service.impl;

import com.sy.sprite.model.QuickSortResult;
import com.sy.sprite.service.IShellSortService;
import com.sy.sprite.util.SortUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 希尔排序算法实现
 * @author dxy
 * @date 2019-12-13
 */
@Service("shellSortService")
public class ShellSortServiceImpl implements IShellSortService {

    //步骤
    private static Integer step = 0;

    /**
     * 希尔排序算法：
     * 1.
     * 2.
     * 3.
     * @param
     * @throws Exception
     */
    @Override
    public List<QuickSortResult> sort(Comparable[] arrays) throws Exception {

        //将数组随机打乱
        //StdRandom.shuffle(arrays);

        List<QuickSortResult> resultList  = new ArrayList<>();
        //TODO 只有排序算法代码，未解析注释，待设计model封装排序结果

        int arrayLength = arrays.length;

        // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ...
        int h = 1;
        while (h < arrayLength/3) h = 3*h + 1;

        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < arrayLength; i++) {
                for (int j = i; j >= h && SortUtil.less(arrays[j], arrays[j-h]); j -= h) {
                    SortUtil.exch(arrays, j, j-h);
                }
            }
            assert SortUtil.isHsorted(arrays, h);
            h /= 3;
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
