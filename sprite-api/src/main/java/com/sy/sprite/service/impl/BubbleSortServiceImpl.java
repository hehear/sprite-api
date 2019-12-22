package com.sy.sprite.service.impl;

import com.sy.sprite.model.BubbleSortResult;
import com.sy.sprite.model.QuickSortResult;
import com.sy.sprite.service.IBubbleSortService;
import com.sy.sprite.service.IMergeSortService;
import com.sy.sprite.util.SortUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sy.sprite.util.SortUtil.exch;
import static com.sy.sprite.util.SortUtil.less;

/**
 * @description 冒泡排序算法实现
 * @author dxy
 * @date 2019-12-19
 */
@Service("bubbleSortService")
public class BubbleSortServiceImpl implements IBubbleSortService {

    //步骤-全
    private static Integer allStep = 0;
    //步骤-真实的交换，去除不交换的步骤
    private static Integer realStep = 0;

    /**
     * 冒泡排序算法：
     * 1.相邻的两个数比较，大的沉下去（交换到右边），小的冒上来（交换到左边）
     * 2.第一次将数组所有相邻的元素比较完，即将最小的元素移到最左边，第二次将剩下的最小元素移到数组第二的位置
     * 3.依次类推，就将所有元素的位置排序好了
     * @param
     * @throws Exception
     */
    @Override
    public List<BubbleSortResult> sort(Comparable[] arrays) throws Exception {

        //将数组随机打乱
        //StdRandom.shuffle(arrays);

        List<BubbleSortResult> resultList  = new ArrayList<>();

        //打印数组
        SortUtil.show(arrays);

        int arrLength = arrays.length;

        for (int i = 0; i < arrLength-1; i++) {
            // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            boolean flag = true;

            for (int j = arrLength - 1; j > i ; j--) {
                //相邻两个数比较，后面的数 < 前面的数
                if (SortUtil.less(arrays[j], arrays[j-1])) {

                    //交换前参数赋值
                    BubbleSortResult bubble = getBeforeBubbleSortResult(arrays,j,j-1);

                    //交换
                    SortUtil.exch(arrays,j,j-1);

                    //交换后参数赋值
                    bubble = getAfterBubbleSortResult(bubble,arrays,allStep,realStep);

                    resultList.add(bubble);


                    //打印数组
                    SortUtil.show(arrays);

                    //变动标识置为false
                    flag = false;
                }else{
                    //不交换
                    BubbleSortResult bubble = getNoChangeBubbleSortResult(arrays,allStep,realStep,j,j-1);

                    resultList.add(bubble);
                }

            }
            //无变动，则已排好序，可退出遍历
            if (flag) {
                break;
            }
        }

        //验证是否有序
        assert SortUtil.isSorted(arrays);

        return resultList;

    }

    /**
     * 不交换结果封装
     * @param arrays
     * @param integer
     * @param step
     * @param allStep
     * @param realStep
     * @return
     */
    private BubbleSortResult getNoChangeBubbleSortResult(Comparable[] arrays, Integer allStep, Integer realStep,Integer j, Integer i) {

        //拷贝数组
        Comparable[] resultArrays = arrays.clone();

        BubbleSortResult bubble = new BubbleSortResult();
        //排序前的数组
        bubble.setBeforeArrays(resultArrays);
        //排序后
        bubble.setAfterArrays(resultArrays);
        //排序步骤-全，没交换排序步骤也+1
        allStep = allStep+1;
        bubble.setAllStep(allStep);
        //实际排序步骤，没交换，真实排序步骤不加1
        bubble.setRealStep(realStep);
        //比较数1
        Map<Integer,Comparable> compareMap1 = new HashMap<>();
        compareMap1.put(j,resultArrays[j]);
        bubble.setCompareNum1(compareMap1);
        //比较数2
        Map<Integer,Comparable> compareMap2 = new HashMap<>();
        compareMap2.put(i,resultArrays[i]);
        bubble.setCompareNum2(compareMap2);
        //比较规则
        bubble.setCompareRule("asc");
        //是否交换
        bubble.setIsChanged("0");

        return bubble;
    }


    /**
     * 交换前的排序结果赋值
     * @param arrays
     * @param j
     * @param i
     * @return
     */
    private BubbleSortResult getBeforeBubbleSortResult(Comparable[] arrays, int j, int i) {

        //拷贝数组
        Comparable[] resultArrays = arrays.clone();

        BubbleSortResult bubble = new BubbleSortResult();
        //排序前的数组
        bubble.setBeforeArrays(resultArrays);
        //比较数1
        Map<Integer,Comparable> compareMap1 = new HashMap<>();
        compareMap1.put(j,resultArrays[j]);
        bubble.setCompareNum1(compareMap1);
        //比较数2
        Map<Integer,Comparable> compareMap2 = new HashMap<>();
        compareMap2.put(i,resultArrays[i]);
        bubble.setCompareNum2(compareMap2);
        //比较规则
        bubble.setCompareRule("asc");
        //交换数1
        Map<Integer,Comparable> map1 = new HashMap<>();
        map1.put(j,resultArrays[j]);
        bubble.setExchangeNum1(map1);
        //交换数2
        Map<Integer,Comparable> map2 = new HashMap<>();
        map2.put(i,resultArrays[i]);
        bubble.setExchangeNum2(map2);
        //是否交换
        bubble.setIsChanged("1");

        return bubble;
    }


    /**
     * 交换后的排序结果赋值
     * @param bubble
     * @param arrays
     * @param j
     * @param i
     * @param allStep
     * @param realStep
     * @return
     */
    private BubbleSortResult getAfterBubbleSortResult(BubbleSortResult bubble, Comparable[] arrays, Integer allStep, Integer realStep) {

        //拷贝数组
        Comparable[] resultArrays = arrays.clone();

        //交换后的数组
        bubble.setAfterArrays(resultArrays);

        //排序步骤-全
        allStep = allStep+1;
        bubble.setAllStep(allStep);
        //实际排序步骤
        realStep = realStep+1;
        bubble.setRealStep(realStep);

        return bubble;
    }

//    public static void main(String[] args) {
//
//
//        Integer[] arrays = new Integer[]{12,12,4,23,12,11,24,66,12,34,12,56,12,98,12,34,12};
//        sort(new ArrayList<>(),arrays, 0, arrays.length - 1);
//        SortUtil.show(arrays);
//    }

}
