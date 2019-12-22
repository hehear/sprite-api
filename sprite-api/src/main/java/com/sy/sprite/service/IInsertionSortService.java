package com.sy.sprite.service;

import com.sy.sprite.model.QuickSortResult;

import java.util.List;

/**
 * @description 插入排序算法sercice
 * @author dxy
 * @date 2019-12-13
 */
public interface IInsertionSortService {

    /**
     * 插入排序算法
     * @throws Exception
     */
    public List<QuickSortResult> sort(Comparable[] data) throws Exception;
}
