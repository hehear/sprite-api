package com.sy.sprite.service;

import com.sy.sprite.model.BubbleSortResult;
import com.sy.sprite.model.QuickSortResult;

import java.util.List;

/**
 * @description 冒泡排序算法sercice
 * @author dxy
 * @date 2019-12-19
 */
public interface IBubbleSortService {

    /**
     * 冒泡排序算法
     * @throws Exception
     */
    public List<BubbleSortResult> sort(Comparable[] data) throws Exception;
}
