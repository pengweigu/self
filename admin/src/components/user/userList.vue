<template>
  <el-table
    :data="tableData"
    stripe
    style="width: 100%">
    <el-table-column
      prop="account"
      label="账号">
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
    <el-table-column
      label="操作">
      <template slot-scope="scope">
        <el-button type="text" size="small" @click="viewAdminUser(scope.row)">查看</el-button>
        <el-button type="text" size="small" @click="editAdminUser(scope.row)">编辑</el-button>
        <el-button type="text" size="small" @click="deleteAdminUser(scope.row)">删除</el-button>
      </template>
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
      vm.selectAdminUser();
    },
    methods:{
      selectAdminUser(){
        const vm = this;
        vm.$axios.post('/admin/user/list.json',{}).then(function (res) {
          if(res.data.isSuccess == "true") {
            vm.tableData = res.data.items;
          }else{
            vm.tableData = [];
          }
        }).catch(function (error) {
          vm.$message.error("查询列表数据异常！");
        });
      },
      deleteAdminUser(row){
        const vm = this;
        vm.$axios.post('/admin/user/delete.json',{'id':row.id}).then(function (res) {
          if(res.data.isSuccess == "true"){
            vm.$message.success("删除数据["+row.name+"]成功！");
            vm.selectAdminUser();
          } else {
            vm.$message.info("删除数据["+row.name+"]失败！");
          }
        }).catch(function (error) {
          vm.$message.error("删除数据["+row.name+"]异常！");
        });
      },
      editAdminUser(row){
        vm.$message.error("编辑数据["+row.name+"]异常！");
      },
      viewAdminUser(row){
        vm.$message.error("查看数据["+row.name+"]异常！");
      }
    }
  }
</script>
