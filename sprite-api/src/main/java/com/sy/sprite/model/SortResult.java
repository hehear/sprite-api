package com.sy.sprite.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @description 排序结果父类
 * @author dxy
 * @date 2019-12-12
 */
@ApiModel("排序结果类")
public abstract class SortResult {

    //操作之前的数组
    @ApiModelProperty("操作之前的数组")
    private Comparable[] beforeArrays;

    //操作之后的数组
    @ApiModelProperty("操作之后的数组")
    private Comparable[] afterArrays;

    public Comparable[] getBeforeArrays() {
        return beforeArrays;
    }

    public void setBeforeArrays(Comparable[] beforeArrays) {
        this.beforeArrays = beforeArrays;
    }

    public Comparable[] getAfterArrays() {
        return afterArrays;
    }

    public void setAfterArrays(Comparable[] afterArrays) {
        this.afterArrays = afterArrays;
    }
}
