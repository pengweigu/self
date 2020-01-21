<!--登录页-->
<template>
  <!--顶部-->
  <el-form :inline="true" label-width="80px" :model="formlogin" ref="formlogin" :rules="formloginRule" class="demo-form-inline">
    <!-- :interval间隔 -->
    <el-carousel :interval="3000" type="card" height="200px">
      <el-carousel-item v-for="item in items" :key="item.text">
        <h3>{{ item.text }}</h3>
      </el-carousel-item>
    </el-carousel>
    <!--1-->
    <el-row>
    <el-form-item prop="account">
      <el-input v-model="formlogin.account" placeholder="账号"></el-input>
    </el-form-item>
    </el-row>
    <!--2-->
    <el-row>
    <el-form-item prop="password">
      <el-input type="password" v-model="formlogin.password" placeholder="密码"></el-input>
    </el-form-item>
    </el-row>
    <!--3-->
    <el-row>
    <el-form-item>
      <el-button type="primary" @click="onSubmit">登录</el-button>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onRegAdminUser">注册</el-button>
    </el-form-item>
    </el-row>
  </el-form>
</template>
<script>
export default {
  name: 'login',
  data () {
    return {
      items: [{text:"欢迎"},{text:"欢迎"},{text:"欢迎"}],//跑马灯内容
      formlogin: {
        account: '',
        password: ''
      },
      formloginRule: {
        account: [
          { required:true, pattern: /^[0-9a-zA-Z]{4,8}$/, message: '请输入4-8位数字字母', trigger: 'blur' }
        ],
        password: [
          { required:true, pattern: /^[0-9a-zA-Z]{6,12}$/, message: '请输入6-12位数字字母', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    onSubmit() {
      var vm = this;
      this.$refs['formlogin'].validate(valid=>{
        if(valid){
          vm.$axios.post('/admin/user/dologin.json',this.formlogin).then(function (res) {
            if(res.data.isSuccess == "true"){
              vm.$message({
                message: '登录成功！',
                type: 'success'
              });
              vm.$router.push({name: 'adminIndex',params:{}});
            }else{
              vm.$message.error('登录失败！');
            }
          }).catch(function (error) {
            vm.$message.error('登录异常！');
          });
        }
      });
    },
    onRegAdminUser() {
      this.$router.push({name: 'adminReg',params:{}});
    }
  },
  created() {
    //获取跑马灯信息
    var vm = this;

    vm.$axios.post('/admin/sys/carousel.json',{}).then(function (res) {
      if(res.data.isSuccess == "true"){
        const obj = res.data.obj;
        const strs = obj.value.split("|"); //字符分割
        for (let i=0;i<strs.length ;i++ ){
          vm.items[i] = {"text":strs[i]};
        }
      }
    }).catch(function (error) {
      console.log("获取跑马灯信息失败...")
    });
  }
}
</script>
<style>
  .el-carousel__item h3 {
    color: #000000;
    font-size: 14px;
    opacity: 0.75;
    line-height: 200px;
    margin: 0;
  }
  .el-carousel__item:nth-child(2n) {
    background-color: #85bf71;
  }
  .el-carousel__item:nth-child(2n+1) {
    background-color: #8585e6;
  }
</style>
