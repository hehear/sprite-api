package com.sy.sprite.rest;

import com.sy.sprite.common.CommonRest;
import com.sy.sprite.common.SimpleMessage;
import com.sy.sprite.model.BubbleSortResult;
import com.sy.sprite.model.Quick3WaySortResult;
import com.sy.sprite.model.QuickSortResult;
import com.sy.sprite.model.SelectionSortResult;
import com.sy.sprite.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @description 排序算法类
 * @author dxy
 * date 2019-12-10
 */
@Path("sort")
@Api(value = "排序算法接口")
public class SortRest extends CommonRest{

    private Logger LOGGER = LoggerFactory.getLogger(SortRest.class);

    @Autowired
    private IQuickSortService quickSortService;
    @Autowired
    private IQuick3WaySortService quick3WaySortService;
    @Autowired
    private IMergeSortService mergeSortService;
    @Autowired
    private IShellSortService shellSortService;
    @Autowired
    private IInsertionSortService insertionSortService;
    @Autowired
    private ISelectionSortService selectionSortService;
    @Autowired
    private IBubbleSortService bubbleSortService;
    @Autowired
    private IHeapSortService heapSortService;

    @POST
    @Path("quick")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value="快速排序算法", notes="快速排序算法Rest方法")
    @ApiResponse(code = 200,message = "成功",response = SimpleMessage.class)
    public SimpleMessage<List<QuickSortResult>> quickSort(Integer[] arrays ){

        SimpleMessage<List<QuickSortResult>> sortResultSimpleMessage = null;
        try {

            LOGGER.info("执行快速排序算法。。");

            List<QuickSortResult> resultList = quickSortService.sort(arrays);

            sortResultSimpleMessage = new SimpleMessage<List<QuickSortResult>>();

            sortResultSimpleMessage.setRecord(resultList);

        }catch (Exception e){

            return error(e);
        }

        return sortResultSimpleMessage;

    }

    @POST
    @Path("quick3Way")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value="三向切分快速排序算法", notes="三向切分快速排序算法Rest方法")
    @ApiResponse(code = 200,message = "成功",response = SimpleMessage.class)
    public SimpleMessage<List<Quick3WaySortResult>> quick3WaySort(Integer[] arrays ){

        SimpleMessage<List<Quick3WaySortResult>> sortResultSimpleMessage = null;
        try {

            LOGGER.info("执行三向切分快速排序算法。。");

            List<Quick3WaySortResult> resultList = quick3WaySortService.sort(arrays);

            sortResultSimpleMessage = new SimpleMessage<List<Quick3WaySortResult>>();

            sortResultSimpleMessage.setRecord(resultList);

        }catch (Exception e){

            return error(e);
        }

        return sortResultSimpleMessage;

    }


    @POST
    @Path("merge")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value="归并排序算法", notes="归并排序算法Rest方法")
    @ApiResponse(code = 200,message = "成功",response = SimpleMessage.class)
    public SimpleMessage<List<QuickSortResult>> mergeSort(Integer[] arrays ){

        SimpleMessage<List<QuickSortResult>> sortResultSimpleMessage = null;
        try {

            LOGGER.info("执行归并排序算法。。");
            //TODO 只有排序算法代码，未解析注释，待设计model封装排序结果

            List<QuickSortResult> resultList = mergeSortService.sort(arrays);

            sortResultSimpleMessage = new SimpleMessage<List<QuickSortResult>>();

            sortResultSimpleMessage.setRecord(resultList);

        }catch (Exception e){

            return error(e);
        }

        return sortResultSimpleMessage;

    }

    @POST
    @Path("shell")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value="希尔排序算法", notes="希尔排序算法Rest方法")
    @ApiResponse(code = 200,message = "成功",response = SimpleMessage.class)
    public SimpleMessage<List<QuickSortResult>> shellSort(Integer[] arrays ){

        SimpleMessage<List<QuickSortResult>> sortResultSimpleMessage = null;
        try {

            LOGGER.info("执行希尔排序算法。。");
            //TODO 只有排序算法代码，未解析注释，待设计model封装排序结果

            List<QuickSortResult> resultList = shellSortService.sort(arrays);

            sortResultSimpleMessage = new SimpleMessage<List<QuickSortResult>>();

            sortResultSimpleMessage.setRecord(resultList);

        }catch (Exception e){

            return error(e);
        }

        return sortResultSimpleMessage;

    }


    @POST
    @Path("insertion")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value="插入排序算法", notes="插入排序算法Rest方法")
    @ApiResponse(code = 200,message = "成功",response = SimpleMessage.class)
    public SimpleMessage<List<QuickSortResult>> insertionSort(Integer[] arrays ){

        SimpleMessage<List<QuickSortResult>> sortResultSimpleMessage = null;
        try {

            LOGGER.info("执行插入排序算法。。");
            //TODO 只有排序算法代码，未解析注释，待设计model封装排序结果

            List<QuickSortResult> resultList = insertionSortService.sort(arrays);

            sortResultSimpleMessage = new SimpleMessage<List<QuickSortResult>>();

            sortResultSimpleMessage.setRecord(resultList);

        }catch (Exception e){

            return error(e);
        }

        return sortResultSimpleMessage;

    }


    @POST
    @Path("selection")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value="选择排序算法", notes="选择排序算法Rest方法")
    @ApiResponse(code = 200,message = "成功",response = SimpleMessage.class)
    public SimpleMessage<List<SelectionSortResult>> selectionSort(Integer[] arrays ){

        SimpleMessage<List<SelectionSortResult>> sortResultSimpleMessage = null;
        try {

            LOGGER.info("执行选择排序算法。。");
            //TODO 只有排序算法代码，未解析注释，待设计model封装排序结果

            List<SelectionSortResult> resultList = selectionSortService.sort(arrays);

            sortResultSimpleMessage = new SimpleMessage<List<SelectionSortResult>>();

            sortResultSimpleMessage.setRecord(resultList);

        }catch (Exception e){

            return error(e);
        }

        return sortResultSimpleMessage;

    }


    @POST
    @Path("bubble")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value="冒泡排序算法", notes="冒泡排序算法Rest方法")
    @ApiResponse(code = 200,message = "成功",response = SimpleMessage.class)
    public SimpleMessage<List<BubbleSortResult>> bubbleSort(Integer[] arrays ){

        SimpleMessage<List<BubbleSortResult>> sortResultSimpleMessage = null;
        try {

            LOGGER.info("执行冒泡排序算法。。");
            //TODO 只有排序算法代码，未解析注释，待设计model封装排序结果

            List<BubbleSortResult> resultList = bubbleSortService.sort(arrays);

            sortResultSimpleMessage = new SimpleMessage<List<BubbleSortResult>>();

            sortResultSimpleMessage.setRecord(resultList);

        }catch (Exception e){

            return error(e);
        }

        return sortResultSimpleMessage;

    }


    @POST
    @Path("heap")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value="堆排序算法", notes="堆排序算法Rest方法")
    @ApiResponse(code = 200,message = "成功",response = SimpleMessage.class)
    public SimpleMessage<List<QuickSortResult>> heapSort(Integer[] arrays ){

        SimpleMessage<List<QuickSortResult>> sortResultSimpleMessage = null;
        try {

            LOGGER.info("执行堆排序算法。。");
            //TODO 只有排序算法代码，未解析注释，待设计model封装排序结果

            List<QuickSortResult> resultList = heapSortService.sort(arrays);

            sortResultSimpleMessage = new SimpleMessage<List<QuickSortResult>>();

            sortResultSimpleMessage.setRecord(resultList);

        }catch (Exception e){

            return error(e);
        }

        return sortResultSimpleMessage;

    }


}
