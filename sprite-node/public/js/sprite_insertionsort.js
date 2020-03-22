
const {Scene, Sprite,Label} = spritejs;
 
/**
 * 计算各个元素的宽度，高度，位置等信息
 * 返回格式[ {left:0, right:0,width:0,height:0},{...}]
 * 
 * 规则：
 *   高度计算：取最大值，以其高度为100%标准【等于画布的高度】，判断其它各元素的显示高度
 *   宽度计算：根据画布宽度和
 */

var sy={
    //默认属性信息
    attr:{
        //画布的高度
        h:200,
        //画布的宽度
        w:1000,
        //每个元素最大/小的宽度
        w_max:30,
        w_min:5,
        //每个元素最大间隔
        space_max:30,
        space_min:5,
        //元素对齐方式
        align:'left',
        sprites:{},
        timing:{
            duration: 1200, // 动画播放一次的时长
            delay: 20, // 延时1s后执行动画
            fill: 'both', // 保留在最后状态
            endDelay:10
        },
        scene:null,
        layer:null,

        //算法执行步骤结果
        steps:[],
        //当前执行到第几部
        currStep:0,

    },

    //创建数组精灵、画布
    createElements:function(arr){

        //清空原有精灵
        if(this.attr.scene){
            this.attr.scene.removeLayer(this.attr.layer);
        }

        //生成每个精灵的长宽高位置等信息
        var optionList=this._calItemOption(arr);

        //开始生成精灵
        this._createSprites(optionList);


        //绘制到画布
        if(!this.attr.scene){

            this.attr.scene = new Scene('#my-scene', {viewport:  ['auto', 300], resolution: ['flex', 'flex'],stickExtend:false});
        }
        this.attr.layer = this.attr.scene.layer(0,{pos: [0, 200]});

        for(var i=0;i<arr.length;i++){

            this.attr.layer.append(sy.sprites.spriteList[i]);
            this.attr.layer.append(sy.sprites.labelSpriteList[i]);
        }


    },


    //按照步骤排序
    stepSort:function(i,callback){

        console.log("要走第几步骤了："+i);

        if(i>=this.attr.steps.length){
            return false;
        }

        var compareNum1Index=this.attr.steps[i].compareNum1Index;


        var compareNum2Index=this.attr.steps[i].compareNum2Index;
        if(this.attr.steps[i].isChanged == '0'){

            // 不交换的变颜色
            sy.noExchange(compareNum1Index,compareNum2Index,i);
            callback(1);

        } else if(this.attr.steps[i].isChanged == '1'){

            // 交换元素
            sy.singleExchange(i,function (status) {

                callback(status);
            });

        }
    },



    //未交换元素
    noExchange: function(firstIndex,secondIndex,stepId){

        if(!firstIndex){
            return false;
        }

        var compareIndex1=this.attr.steps[stepId].compareNum1Index;
        var compareIndex2=this.attr.steps[stepId].compareNum2Index;
        var insertIndex=this.attr.steps[stepId].insertIndex;

        var step = stepId+1;

        $("#my-title").append("第"+step+"步：插入数:data["+insertIndex+"]="+this.attr.steps[stepId].insertNum
            +"  比较的两个数:data["+compareIndex1+"]="+this.attr.steps[stepId].compareNum1+"和data["+compareIndex2+"]="+this.attr.steps[stepId].compareNum2+"相等不交换。<br/>")

        //滚动条始终在最下面
        var boxId="my-title";
        var boxElement=document.getElementById(boxId);
        boxElement.scrollTop=boxElement.scrollHeight-boxElement.clientHeight;

        console.log("调用了=="+this.attr.currStep);

        (async function f() {

            //比较元素变颜色
            await sy.sprites.spriteList[firstIndex].setAttribute('bgcolor','#B82D26');
            await sy.sprites.spriteList[secondIndex].setAttribute('bgcolor','#B82D26');

            await sy.sprites.spriteList[insertIndex].setAttribute('bgcolor','#18aecc');


            //等待
            sy.sprites.spriteList[firstIndex].animate([

                {...sy.sprites.spritePosition[firstIndex]}

            ], sy.attr.timing).finished;

            sy.sprites.spriteList[firstIndex].animate([
                {...sy.sprites.spritePosition[firstIndex]}

            ], sy.attr.timing).finished;

            sy.sprites.labelSpriteList[firstIndex].animate([

                {...sy.sprites.spritePosition[firstIndex]}

            ], sy.attr.timing).finished;

            await sy.sprites.labelSpriteList[firstIndex].animate([
                {...sy.sprites.spritePosition[firstIndex]}

            ], sy.attr.timing).finished;


            var tempFirst=sy.sprites.spriteList[firstIndex];
            sy.sprites.spriteList[firstIndex]=sy.sprites.spriteList[firstIndex];
            sy.sprites.spriteList[firstIndex]=tempFirst;
            var tempLabelFirst=sy.sprites.labelSpriteList[firstIndex];
            sy.sprites.labelSpriteList[firstIndex]=sy.sprites.labelSpriteList[firstIndex];
            sy.sprites.labelSpriteList[firstIndex]=tempLabelFirst;

            //比较颜色恢复
            await sy.sprites.spriteList[firstIndex].setAttribute('bgcolor','#7fb80e');
            await sy.sprites.spriteList[secondIndex].setAttribute('bgcolor','#7fb80e');

            console.log("我在await里面面啊");


        }());

        console.log("我在await后面啊");
    },

    //交换元素
    singleExchange: function(stepId,callback){

        var exchangeIndex1=this.attr.steps[stepId].exchangeNum1Index;
        var exchangeIndex2=this.attr.steps[stepId].exchangeNum2Index;
        var insertIndex=this.attr.steps[stepId].insertIndex;



        var step = stepId+1;

        $("#my-title").append("第"+step+"步：插入数:data["+insertIndex+"]="+this.attr.steps[stepId].insertNum
            +"  交换的两个数:data["+exchangeIndex1+"]="+this.attr.steps[stepId].exchangeNum1+"和data["+exchangeIndex2+"]="+this.attr.steps[stepId].exchangeNum2+"交换。<br/>")

        //滚动条始终在最下面
        var boxId="my-title";
        var boxElement=document.getElementById(boxId);
        boxElement.scrollTop=boxElement.scrollHeight-boxElement.clientHeight;

        var firstIndex = exchangeIndex1;
        var secondIndex = exchangeIndex2;

        if(!firstIndex && firstIndex!=0){
            callback(0);
        }

        console.log("调用了=="+this.attr.currStep);

        (async function f() {


            //比较元素变颜色
            await sy.sprites.spriteList[firstIndex].setAttribute('bgcolor','#B82D26');
            await sy.sprites.spriteList[secondIndex].setAttribute('bgcolor','#B82D26');

            await sy.sprites.spriteList[insertIndex].setAttribute('bgcolor','#18aecc');




            sy.sprites.spriteList[firstIndex].animate([

                {...sy.sprites.spritePosition[secondIndex]}

            ], sy.attr.timing).finished;

            sy.sprites.spriteList[secondIndex].animate([
                {...sy.sprites.spritePosition[firstIndex]}

            ], sy.attr.timing).finished;

            sy.sprites.labelSpriteList[firstIndex].animate([

                {...sy.sprites.spritePosition[secondIndex]}

            ], sy.attr.timing).finished;

            await sy.sprites.labelSpriteList[secondIndex].animate([
                {...sy.sprites.spritePosition[firstIndex]}

            ], sy.attr.timing).finished;


            var tempFirst=sy.sprites.spriteList[firstIndex];
            sy.sprites.spriteList[firstIndex]=sy.sprites.spriteList[secondIndex];
            sy.sprites.spriteList[secondIndex]=tempFirst;
            var tempLabelFirst=sy.sprites.labelSpriteList[firstIndex];
            sy.sprites.labelSpriteList[firstIndex]=sy.sprites.labelSpriteList[secondIndex];
            sy.sprites.labelSpriteList[secondIndex]=tempLabelFirst;

            //比较颜色恢复
            await sy.sprites.spriteList[secondIndex].setAttribute('bgcolor','#7fb80e');
            await sy.sprites.spriteList[firstIndex].setAttribute('bgcolor','#7fb80e');

            if(stepId==sy.attr.steps.length-1){



                for(var j = 0;j<=sy.sprites.spriteList.length;j++){

                    //组内元素还原
                    sy.sprites.spriteList[j].setAttribute('bgcolor','#7fb80e');

                }
            }

            callback(0);
            //sy.attr.currStep++;
            //sy.sort(sy.attr.currStep);

        }());

        console.log("我在await后面啊");
    },
    //创建精灵
    _createSprites:function(optionList){
        var spriteList=[];
        var labelSpriteList=[];
        var spritePosition=[];
        var w=50;
        var wSum = 50;
        for(var i=0;i<optionList.length;i++){
            wSum = wSum+w+20;
            let curr=optionList[i];
            let tempSprite = new Sprite({
                anchor: curr.value>0?[0,1]:[0,0],
                bgcolor: '#7fb80e',
                pos: [curr.left, curr.top],
                size: [w,(curr.value>0?curr.value:0-curr.value)*30],
                shadow: {
                    offset: [10, -10],
                    blur: 30,
                    color: '#7c7',
                }
                 
            });

            let tenpLabel = new Label(''+curr.value);
            tenpLabel.attr({
                anchor: curr.value>0?[0,0]:[0,1],
                pos: [curr.left+8, curr.top],
                fillColor: '#7fb80e',
                font: 'bold 36px "微软雅黑"  ',
                //lineHeight: 112,
                textAlign: 'center',
                //padding: [0, 30],
                // border: [2.5, '#ccc'],
            });

            spriteList.push(tempSprite);
            labelSpriteList.push(tenpLabel);
            spritePosition.push({x:curr.left,y:curr.top});
        };



        sy.sprites={spriteList,labelSpriteList,spritePosition};

    },
    //计算元素的长宽高等元素
    _calItemOption:function(arr){
        var result=[];
        let p_l=0;
        let p_r=0;
        let w=50;
        for(var i=0;i<arr.length;i++){
            var currVal=arr[i];
            p_l=p_l+w+20;
            var tempOption={};
            tempOption.left=p_l;
            tempOption.top=500;
            tempOption.width=50;
            tempOption.height=(currVal>0?currVal:0-currVal)*30;
            tempOption.value=currVal;

            result.push(tempOption);

        }
        return result;
    }

}

   