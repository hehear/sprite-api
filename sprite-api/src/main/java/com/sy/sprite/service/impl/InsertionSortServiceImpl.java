package com.sy.sprite.service.impl;

import com.sy.sprite.model.QuickSortResult;
import com.sy.sprite.service.IInsertionSortService;
import com.sy.sprite.service.IMergeSortService;
import com.sy.sprite.util.SortUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @description 插入排序算法实现
 * @author dxy
 * @date 2019-12-13
 */
@Service("insertionSortService")
public class InsertionSortServiceImpl implements IInsertionSortService {

    //步骤
    private static Integer step = 0;

    /**
     * 插入排序算法：
     * 1.认定数组前n-1的元素是有序的，在拿第n个元素时，与前n-1个元素做比较，插入相应的位置
     * 2.开始时，从第二个元素开始拿，与第一个元素比较，比第一个元素大插在它的右边，小插到左边
     * 3.再拿第三个元素，与前两个元素比较，插入适当的位置，依次类推，直到数组排序完成。
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
        int arrLength = arrays.length;
        //元素从第2个开始拿，所有遍历arrLength-1即可
        for (int i = 0; i < arrLength-1; i++) {
            //拿的元素与前面的所有元素比较
            for (int j = i+1; j > 0; j--) {
                //如果拿的元素与比较的元素小，则交换位置
                if(SortUtil.less(arrays[j], arrays[j-1])) {
                    //交换
                    SortUtil.exch(arrays, j, j - 1);
                    //打印数组
                    SortUtil.show(arrays);
                }else{
                    //由于前面的数组是有序的，在与比较元素相比大的话即已插入正确的位置，即可退出循环比较
                    break;
                }
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
