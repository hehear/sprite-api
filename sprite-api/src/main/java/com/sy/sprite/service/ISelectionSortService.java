package com.sy.sprite.service;

import com.sy.sprite.model.QuickSortResult;
import com.sy.sprite.model.SelectionSortResult;

import java.util.List;

/**
 * @description 选择排序算法sercice
 * @author dxy
 * @date 2019-12-19
 */
public interface ISelectionSortService {

    /**
     * 选择排序算法
     * @throws Exception
     */
    public List<SelectionSortResult> sort(Comparable[] data) throws Exception;
}
