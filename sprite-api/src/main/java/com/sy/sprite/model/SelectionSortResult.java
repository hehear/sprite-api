package com.sy.sprite.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @description 选择排序结果类,用于封装排序结果
 * @author dxy
 * @date 2020-03-20
 */
@ApiModel("选择排序结果类")
public class SelectionSortResult extends CompareSortResult{

    //组内最小数下标
    @ApiModelProperty("组内最小数下标")
    private Integer minIndex;

    @ApiModelProperty("组内最小数")
    private Comparable minNum;

    public Integer getMinIndex() {
        return minIndex;
    }

    public void setMinIndex(Integer minIndex) {
        this.minIndex = minIndex;
    }

    public Comparable getMinNum() {
        return minNum;
    }

    public void setMinNum(Comparable minNum) {
        this.minNum = minNum;
    }
}
