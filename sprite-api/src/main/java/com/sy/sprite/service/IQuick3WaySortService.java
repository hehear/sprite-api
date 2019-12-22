package com.sy.sprite.service;

import com.sy.sprite.model.Quick3WaySortResult;
import com.sy.sprite.model.QuickSortResult;

import java.util.List;

/**
 * @description 三向切分快速排序算法sercice
 * @author dxy
 * @date 2019-12-12
 */
public interface IQuick3WaySortService {

    /**
     * 三向切分快速排序算法
     * @throws Exception
     */
    public List<Quick3WaySortResult> sort(Comparable[] data) throws Exception;
}
