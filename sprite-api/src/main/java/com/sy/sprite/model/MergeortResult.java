package com.sy.sprite.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Map;

/**
 * @description 归并排序结果类,用于封装排序结果
 * @author dxy
 * @date 2019-12-17
 */
@ApiModel("归并排序结果类")
public class MergeortResult extends SortResult{

    //步骤
    @ApiModelProperty("排序步骤")
    private Integer step;

    //交换数1
    @ApiModelProperty("交换数1")
    private Map<Integer,Comparable> exchangeNum1;

    //交换数2
    @ApiModelProperty("交换数2")
    private Map<Integer,Comparable> exchangeNum2;

    private static class SingletonHolder{
        private static MergeortResult instance = new MergeortResult();
    }
    //单例
    public static MergeortResult getInstance(){
    return SingletonHolder.instance;
    }

    public MergeortResult() {
        //步骤默认为0
        this.step = 0;
    }




}
