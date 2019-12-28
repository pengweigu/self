<template>
  <el-table
    :data="tableData"
    stripe
    style="width: 100%">
    <el-table-column
      prop="id"
      label="序号"
      width="180">
    </el-table-column>
    <el-table-column
      prop="account"
      label="账号"
      width="180">
    </el-table-column>
    <el-table-column
      prop="name"
      label="名称">
    </el-table-column>
    <el-table-column
      prop="status"
      label="状态">
    </el-table-column>
    <el-table-column
      prop="phone"
      label="手机">
    </el-table-column>
    <el-table-column
      prop="sex"
      label="性别">
    </el-table-column>
    <el-table-column
      prop="email"
      label="邮箱">
    </el-table-column>
  </el-table>
</template>

<script>
  export default {
    name:'userList',
    data() {
      return {
        tableData: []
      }
    },
    created() {
      const vm = this;
      vm.$axios.post('/admin/user/list.json',{}).then(function (res) {
        if(res.data.isSuccess == "true"){
          vm.tableData = res.data.items;
        }
      }).catch(function (error) {

      });
    }
  }
</script>
