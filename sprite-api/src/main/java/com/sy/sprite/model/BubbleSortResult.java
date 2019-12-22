package com.sy.sprite.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Map;

/**
 * @description 冒泡排序结果类,用于封装排序结果
 * @author dxy
 * @date 2019-12-21
 */
@ApiModel("冒泡排序结果类")
public class BubbleSortResult extends SortResult{

    //步骤
    @ApiModelProperty("全的排序步骤")
    private Integer allStep;

    //步骤
    @ApiModelProperty("排序步骤-去除不交换")
    private Integer realStep;

    //比较数1
    @ApiModelProperty("比较数1")
    private Map<Integer,Comparable> compareNum1;

    //比较数2
    @ApiModelProperty("比较数2")
    private Map<Integer,Comparable> compareNum2;

    //比较规则
    @ApiModelProperty(value = "比较规则,asc:compareNum1<compareNum2;desc:compareNum1>compareNum2")
    private String compareRule;

    //是否交换
    @ApiModelProperty(value = "是否交换，1：交换；0：未交换")
    private String isChanged;

    //交换数1
    @ApiModelProperty("交换数1")
    private Map<Integer,Comparable> exchangeNum1;

    //交换数2
    @ApiModelProperty("交换数2")
    private Map<Integer,Comparable> exchangeNum2;

    private static class SingletonHolder{
        private static BubbleSortResult instance = new BubbleSortResult();
    }
    //单例
    public static BubbleSortResult getInstance(){
    return SingletonHolder.instance;
    }

    public BubbleSortResult() {
        //步骤默认为0
        this.allStep = 0;
        this.allStep = 0;
    }

    public Integer getAllStep() {
        return allStep;
    }

    public void setAllStep(Integer allStep) {
        this.allStep = allStep;
    }

    public Integer getRealStep() {
        return realStep;
    }

    public void setRealStep(Integer realStep) {
        this.realStep = realStep;
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

    public Map<Integer, Comparable> getCompareNum1() {
        return compareNum1;
    }

    public void setCompareNum1(Map<Integer, Comparable> compareNum1) {
        this.compareNum1 = compareNum1;
    }

    public Map<Integer, Comparable> getCompareNum2() {
        return compareNum2;
    }

    public void setCompareNum2(Map<Integer, Comparable> compareNum2) {
        this.compareNum2 = compareNum2;
    }

    public String getCompareRule() {
        return compareRule;
    }

    public void setCompareRule(String compareRule) {
        this.compareRule = compareRule;
    }

    public String getIsChanged() {
        return isChanged;
    }

    public void setIsChanged(String isChanged) {
        this.isChanged = isChanged;
    }
}
