package com.sy.sprite.service;

import com.sy.sprite.model.QuickSortResult;

import java.util.List;

/**
 * @description 并归排序算法sercice
 * @author dxy
 * @date 2019-12-13
 */
public interface IShellSortService {

    /**
     * 希尔排序算法
     * @throws Exception
     */
    public List<QuickSortResult> sort(Comparable[] data) throws Exception;
}
