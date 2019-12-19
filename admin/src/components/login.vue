<!--登录页-->
<template>
  <el-form :inline="true" :model="formlogin" class="demo-form-inline">
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
      <el-button type="primary" @click="onSubmit">查询</el-button>
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
      formlogin: {
        account: '',
        password: ''
      }
    }
  },
  methods: {
    onSubmit() {
      console.log('submit!');
    },
    onReset() {
      console.log('reset');
    }
  }
}
</script>
