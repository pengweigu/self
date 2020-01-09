//公共js author:pengwei
const CommonUtils = {
  //判断是否为空
  isNull : function (val) {
    if(null == val){
      return true;
    }
    if(typeof val == "undefined"){
      return true;
    }
    if(typeof val == "number" && isNaN(val)){
      return true;
    }
    if(val.length == 0){
      return true;
    }
    return false;
  }
}

//导出组件
export default CommonUtils
