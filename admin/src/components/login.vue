<!--登录页-->
<template>
  <!--顶部-->
  <el-form :inline="true" :model="formlogin" class="demo-form-inline">
    <el-carousel :interval="4000" type="card" height="200px">
      <el-carousel-item v-for="item in items" :key="item">
        <h3>{{ item }}</h3>
      </el-carousel-item>
    </el-carousel>
    <!--1-->
    <el-row>
    <el-form-item label="账号">
      <el-input v-model="formlogin.account" placeholder="账号"></el-input>
    </el-form-item>
    </el-row>
    <!--2-->
    <el-row>
    <el-form-item label="密码">
      <el-input v-model="formlogin.password" placeholder="密码"></el-input>
    </el-form-item>
    </el-row>
    <!--3-->
    <el-row>
    <el-form-item>
      <el-button type="primary" @click="onSubmit">登录</el-button>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onReset">注册</el-button>
    </el-form-item>
    </el-row>
    <!--4-->
  </el-form>
</template>

<script>
export default {
  name: 'login',
  data () {
    return {
      items: [
        '所有失去的，都会以另外一种方式归来，早安！' +
        '彭伟','笑只是个表情，与快乐无关!' +
        '彭伟','北风吹来，气温大降，你的冷暖，我记心上!' +
        '彭伟'
      ],
      formlogin: {
        account: '',
        password: ''
      }
    }
  },
  methods: {
    onSubmit() {
      this.$axios.post('/admin/user/dologin.json',{
        account:'pengwei',
        password:'123456'
      }).then(function () {

      }).catch(function (error) {

      });
    },
    onReset() {
      console.log('reset');
    }
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
