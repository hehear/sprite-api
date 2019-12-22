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
public class Quick3WaySortResult extends SortResult{

    //步骤
    @ApiModelProperty("排序步骤")
    private Integer step;

    //TODO 不交换的步骤

    //left游标
    @ApiModelProperty("left游标")
    private Integer left;

    //right游标
    @ApiModelProperty("right游标")
    private Integer right;

    //指针游标
    @ApiModelProperty("pointer游标")
    private Integer pointer;

    //基准数
    @ApiModelProperty("基准数")
    private Comparable keyNum;

    //交换数1
    @ApiModelProperty("交换数1")
    private Map<Integer,Comparable> exchangeNum1;

    //交换数2
    @ApiModelProperty("交换数2")
    private Map<Integer,Comparable> exchangeNum2;

    private static class SingletonHolder{
        private static Quick3WaySortResult instance = new Quick3WaySortResult();
    }
    //单例
    public static Quick3WaySortResult getInstance(){
    return SingletonHolder.instance;
    }

    public Quick3WaySortResult() {
        //步骤默认为0
        this.step = 0;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public Integer getLeft() {
        return left;
    }

    public void setLeft(Integer left) {
        this.left = left;
    }

    public Integer getRight() {
        return right;
    }

    public void setRight(Integer right) {
        this.right = right;
    }

    public Integer getPointer() {
        return pointer;
    }

    public void setPointer(Integer pointer) {
        this.pointer = pointer;
    }

    public Comparable getKeyNum() {
        return keyNum;
    }

    public void setKeyNum(Comparable keyNum) {
        this.keyNum = keyNum;
    }

    public Map<Integer, Comparable> getExchangeNum1() {
        return exchangeNum1;
    }

    public void setExchangeNum1(Map<Integer, Comparable> exchangeNum1) {
        this.exchangeNum1 = exchangeNum1;
    }

    public Map<Integer, Comparable> getExchangeNum2() {
        return exchangeNum2;
    }

    public void setExchangeNum2(Map<Integer, Comparable> exchangeNum2) {
        this.exchangeNum2 = exchangeNum2;
    }
}
