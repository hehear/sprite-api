package com.sy.sprite.service.impl;

import com.sy.sprite.model.QuickSortResult;
import com.sy.sprite.service.IBubbleSortService;
import com.sy.sprite.service.IHeapSortService;
import com.sy.sprite.util.SortUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.sy.sprite.util.SortUtil.exch;

/**
 * @description 堆排序算法实现
 * @author dxy
 * @date 2019-12-19
 */
@Service("heapSortService")
public class HeapSortServiceImpl implements IHeapSortService {

    //步骤
    private static Integer step = 0;

    /**
     * 堆排序算法：
     * 1.
     * @param
     * @throws Exception
     */
    @Override
    public List<QuickSortResult> sort(Comparable[] arrays) throws Exception {

        //将数组随机打乱
        //StdRandom.shuffle(arrays);

        List<QuickSortResult> resultList  = new ArrayList<>();
        //TODO 只有排序算法代码，未解析注释，待设计model封装排序结果

        int var1 = arrays.length;

        for(int var2 = var1 / 2; var2 >= 1; --var2) {
            sink(arrays, var2, var1);
        }

        while(var1 > 1) {
            exch(arrays, 1, var1--);
            sink(arrays, 1, var1);
        }

        //验证是否有序
        assert SortUtil.isSorted(arrays);

        return resultList;

    }

    private static void sink(Comparable[] var0, int var1, int var2) {
        while(true) {
            if (2 * var1 <= var2) {
                int var3 = 2 * var1;
                if (var3 < var2 && SortUtil.less(var0, var3, var3 + 1)) {
                    ++var3;
                }

                if (SortUtil.less(var0, var1, var3)) {
                    exch(var0, var1, var3);
                    var1 = var3;
                    continue;
                }
            }

            return;
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
