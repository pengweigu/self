<!--注册页-->
<template>
  <!--顶部-->
  <el-form :inline="true" label-width="100px" :model="formReg" ref="formReg" :rules="formRegrule" class="demo-form-inline">
    <!--1-->
    <el-row>
      <el-form-item prop="account">
        <el-input v-model="formReg.account" placeholder="账号"></el-input>
      </el-form-item>
    </el-row>
    <el-row>
      <el-form-item prop="name">
        <el-input v-model="formReg.name" placeholder="姓名"></el-input>
      </el-form-item>
    </el-row>
    <!--2-->
    <el-row>
      <el-form-item prop="password">
        <el-input type="password" v-model="formReg.password" placeholder="密码"></el-input>
      </el-form-item>
    </el-row>
    <!--3-->
    <el-row>
      <el-form-item prop="sex">
        <el-select v-model="formReg.sex" style="width: 200px;" placeholder="性别">
          <el-option label="男" value="1"></el-option>
          <el-option label="女" value="2"></el-option>
        </el-select>
      </el-form-item>
    </el-row>
    <el-row>
      <el-form-item prop="phone">
        <el-input v-model="formReg.phone" placeholder="手机号"></el-input>
      </el-form-item>
    </el-row>
    <el-row>
      <el-form-item prop="email">
        <el-input v-model="formReg.email" placeholder="邮箱"></el-input>
      </el-form-item>
    </el-row>
    <el-row>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">提交</el-button>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="goBack">返回</el-button>
      </el-form-item>
    </el-row>
    <!--4-->
  </el-form>
</template>

<script>
  export default {
    name: 'adminReg',
    data () {
      return {
        formReg: {
          account: '',
          name: '',
          phone: '',
          sex: '',
          email: '',
          password: ''
        },
        formRegrule: {
          account: [
            { required:true, pattern: /^[0-9a-zA-Z]{4,8}$/, message: '请输入4-8位数字字母', trigger: 'blur' }
          ],
          password: [
            { required:true, pattern: /^[0-9a-zA-Z]{6,12}$/, message: '请输入6-12位数字字母', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '请输入真实姓名', trigger: 'blur' }
          ],
          phone: [
            { required:true, pattern: /^\d{11}$/, message: '请输入11位手机号', trigger: 'blur' }
          ],
          sex: [
            { required:true, message: '不能为空', trigger: 'blur' }
          ],
          email: [
            { required:true, pattern: /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/, message: '请输入正确的邮箱', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      onSubmit() {
        //表单校验 ref属性
        this.$refs['formReg'].validate((valid) => {
          if (valid) {//校验通过 提交表单
            //提交表单
            this.$axios.post('/admin/user/reg.json',this.formReg).then(res => {
              if(res.data.isSuccess == "true"){
                this.$message({
                  message: '注册成功!',
                  type: 'success'
                });
                this.goBack();
              }else{
                this.$message.error('注册失败!');
              }
            }).catch(function (error) {
              this.$message.error('注册失败!');
            });
          }
        });

      },
      goBack() {
        this.$router.push({name: 'login',params:{}});
      }
    }
  }
</script>
