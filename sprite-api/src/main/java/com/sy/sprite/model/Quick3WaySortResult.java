package com.sy.sprite.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Map;

/**
 * @description 三向切分快速排序结果类,用于封装排序结果
 * @author dxy
 * @date 2019-12-13
 */
@ApiModel("三向切分快速排序结果类")
public class Quick3WaySortResult extends CompareSortResult{

    //基准数
    @ApiModelProperty("基准数")
    private Comparable keyNum;

    //基准数的下标
    @ApiModelProperty("基准数下标")
    private Integer keyNumIndex;

    //组内开始下标
    @ApiModelProperty("组内开始下标")
    private Integer startNumIndex;

    //组内截止下标
    @ApiModelProperty("组内截止下标")
    private Integer endNumIndex;

    //左游标
    @ApiModelProperty("左游标")
    private Integer leftIndex;

    //右游标
    @ApiModelProperty("右游标")
    private Integer rightIndex;


    //指针游标
    @ApiModelProperty("pointer游标")
    private Integer pointer;


    public Comparable getKeyNum() {
        return keyNum;
    }

    public void setKeyNum(Comparable keyNum) {
        this.keyNum = keyNum;
    }

    public Integer getKeyNumIndex() {
        return keyNumIndex;
    }

    public void setKeyNumIndex(Integer keyNumIndex) {
        this.keyNumIndex = keyNumIndex;
    }

    public Integer getStartNumIndex() {
        return startNumIndex;
    }

    public void setStartNumIndex(Integer startNumIndex) {
        this.startNumIndex = startNumIndex;
    }

    public Integer getEndNumIndex() {
        return endNumIndex;
    }

    public void setEndNumIndex(Integer endNumIndex) {
        this.endNumIndex = endNumIndex;
    }

    public Integer getLeftIndex() {
        return leftIndex;
    }

    public void setLeftIndex(Integer leftIndex) {
        this.leftIndex = leftIndex;
    }

    public Integer getRightIndex() {
        return rightIndex;
    }

    public void setRightIndex(Integer rightIndex) {
        this.rightIndex = rightIndex;
    }

    public Integer getPointer() {
        return pointer;
    }

    public void setPointer(Integer pointer) {
        this.pointer = pointer;
    }
}
