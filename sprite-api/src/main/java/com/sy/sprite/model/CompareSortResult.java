package com.sy.sprite.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @description 比较排序结果类,用于封装有关比较的排序算法
 * @author dxy
 * @date 2020-01-06
 */
@ApiModel("比较排序结果类")
public class CompareSortResult extends SortResult{

    //步骤
    @ApiModelProperty("全的排序步骤")
    private Integer allStep;

    //步骤
    @ApiModelProperty("排序步骤-去除不交换")
    private Integer realStep;

    //比较数1
    @ApiModelProperty("比较数1")
    private Comparable compareNum1;

    //比较数2
    @ApiModelProperty("比较数2")
    private Comparable compareNum2;

    //比较数1
    @ApiModelProperty("比较数1的index")
    private Integer compareNum1Index;

    //比较数2
    @ApiModelProperty("比较数2的index")
    private Integer compareNum2Index;

    //比较规则
    @ApiModelProperty(value = "比较规则,asc:compareNum1<compareNum2;desc:compareNum1>compareNum2")
    private String compareRule;

    //是否交换
    @ApiModelProperty(value = "是否交换，1：交换；0：未交换")
    private String isChanged;

    //交换数1
    @ApiModelProperty("交换数1")
    private Comparable exchangeNum1;

    //交换数2
    @ApiModelProperty("交换数2")
    private Comparable exchangeNum2;

    //交换数1
    @ApiModelProperty("交换数1的index")
    private Integer exchangeNum1Index;

    //交换数2
    @ApiModelProperty("交换数2的index")
    private Integer exchangeNum2Index;

    private static class SingletonHolder{
        private static CompareSortResult instance = new CompareSortResult();
    }
    //单例
    public static CompareSortResult getInstance(){
    return SingletonHolder.instance;
    }

    public CompareSortResult() {
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

    public Comparable getCompareNum1() {
        return compareNum1;
    }

    public void setCompareNum1(Comparable compareNum1) {
        this.compareNum1 = compareNum1;
    }

    public Comparable getCompareNum2() {
        return compareNum2;
    }

    public void setCompareNum2(Comparable compareNum2) {
        this.compareNum2 = compareNum2;
    }

    public Integer getCompareNum1Index() {
        return compareNum1Index;
    }

    public void setCompareNum1Index(Integer compareNum1Index) {
        this.compareNum1Index = compareNum1Index;
    }

    public Integer getCompareNum2Index() {
        return compareNum2Index;
    }

    public void setCompareNum2Index(Integer compareNum2Index) {
        this.compareNum2Index = compareNum2Index;
    }

    public Comparable getExchangeNum1() {
        return exchangeNum1;
    }

    public void setExchangeNum1(Comparable exchangeNum1) {
        this.exchangeNum1 = exchangeNum1;
    }

    public Comparable getExchangeNum2() {
        return exchangeNum2;
    }

    public void setExchangeNum2(Comparable exchangeNum2) {
        this.exchangeNum2 = exchangeNum2;
    }

    public Integer getExchangeNum1Index() {
        return exchangeNum1Index;
    }

    public void setExchangeNum1Index(Integer exchangeNum1Index) {
        this.exchangeNum1Index = exchangeNum1Index;
    }

    public Integer getExchangeNum2Index() {
        return exchangeNum2Index;
    }

    public void setExchangeNum2Index(Integer exchangeNum2Index) {
        this.exchangeNum2Index = exchangeNum2Index;
    }
}
