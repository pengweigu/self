//公共js
const CommonUtils = {
  isNull : function (val) {
    if(null == val){
      return true;
    }
    if(typeof val == "undefined"){
      return true;
    }
    if(val.length == 0){
      return true;
    }
    return false;
  }
}

export default CommonUtils
