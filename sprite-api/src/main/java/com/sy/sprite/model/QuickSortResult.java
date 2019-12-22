package com.sy.sprite.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Map;

/**
 * @description 快速排序结果类,用于封装排序结果
 * @author dxy
 * @date 2019-12-12
 */
@ApiModel("快速排序结果类")
public class QuickSortResult extends SortResult{

    //步骤
    @ApiModelProperty("排序步骤")
    private Integer step;

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
        private static QuickSortResult instance = new QuickSortResult();
    }
    //单例
    public static QuickSortResult getInstance(){
    return SingletonHolder.instance;
    }

    public QuickSortResult() {
        //步骤默认为0
        this.step = 0;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public void setStepAddOne() {
        this.step=this.step+1;
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
