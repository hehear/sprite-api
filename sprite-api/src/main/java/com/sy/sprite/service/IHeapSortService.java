package com.sy.sprite.service;

import com.sy.sprite.model.QuickSortResult;

import java.util.List;

/**
 * @description 堆排序算法sercice
 * @author dxy
 * @date 2019-12-19
 */
public interface IHeapSortService {

    /**
     * 堆排序算法
     * @throws Exception
     */
    public List<QuickSortResult> sort(Comparable[] data) throws Exception;
}
