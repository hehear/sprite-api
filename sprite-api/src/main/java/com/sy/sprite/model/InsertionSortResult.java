package com.sy.sprite.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @description 插入排序结果类,用于封装排序结果
 * @author dxy
 * @date 2020-03-22
 */
@ApiModel("插入排序结果类")
public class InsertionSortResult extends CompareSortResult{

    //插入数下标
    @ApiModelProperty("插入数下标")
    private Integer insertIndex;

    @ApiModelProperty("插入数")
    private Comparable insertNum;

    public Integer getInsertIndex() {
        return insertIndex;
    }

    public void setInsertIndex(Integer insertIndex) {
        this.insertIndex = insertIndex;
    }

    public Comparable getInsertNum() {
        return insertNum;
    }

    public void setInsertNum(Comparable insertNum) {
        this.insertNum = insertNum;
    }
}
