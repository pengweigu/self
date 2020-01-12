<template>
  <div><!--一个模板只能有一个艮节点  多个时使用div包起来-->
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
    <!--编辑窗口-->
    <el-dialog title="编辑" :visible.sync="editDialog" width="50%" :before-close="handleClose">
      <span>编辑信息</span>
      <span slot="footer" class="dialog-footer">
        <el-button @click="editDialog = false">取 消</el-button>
        <el-button type="primary" @click="">确 定</el-button>
      </span>
    </el-dialog>
    <!--查看窗口-->
    <el-dialog title="查看" :visible.sync="viewDialog" width="50%" :before-close="handleClose">
      <span>查看信息</span>
      <span slot="footer" class="dialog-footer">
        <el-button @click="viewDialog = false">取 消</el-button>
        <el-button type="primary" @click="">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>
<script>
  export default {
    name:'userList',
    data() {
      return {
        tableData: [],
        editDialog: false,
        viewDialog: false,
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
        const vm = this;
        vm.editDialog = true;
      },
      viewAdminUser(row){
        const vm = this;
        vm.viewDialog = true;
      }
    }
  }
</script>
