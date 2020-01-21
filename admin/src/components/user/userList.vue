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
    <el-dialog title="编辑" :visible.sync="editDialog" width="50%">
      <el-form :inline="true" label-width="100px" :model="formEdit" ref="formEdit" class="demo-form-inline">
        <el-input type="hidden" v-model="formEdit.id"></el-input>
        <!--1-->
        <el-row>
          <el-form-item label="账号">
            <el-input :disabled="true" v-model="formEdit.account"></el-input>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item label="姓名">
            <el-input v-model="formEdit.name"></el-input>
          </el-form-item>
        </el-row>
        <!--3-->
        <el-row>
          <el-form-item label="性别">
            <el-select v-model="formEdit.sex" style="width: 200px;">
              <el-option label="男" value="1"></el-option>
              <el-option label="女" value="2"></el-option>
            </el-select>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item label="手机">
            <el-input v-model="formEdit.phone"></el-input>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item label="邮箱">
            <el-input v-model="formEdit.email"></el-input>
          </el-form-item>
        </el-row>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="formEdit = {}">重 置</el-button>
        <el-button type="primary" @click="">确 定</el-button>
      </span>
    </el-dialog>
    <!--查看窗口-->
    <el-dialog title="查看" :visible.sync="viewDialog" width="50%">
      <el-form :inline="true" label-width="100px" :model="formView" ref="formView" class="demo-form-inline">
        <!--1-->
        <el-row>
          <el-form-item label="账号">
            <el-input v-model="formView.account"></el-input>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item label="姓名">
            <el-input v-model="formView.name"></el-input>
          </el-form-item>
        </el-row>
        <!--3-->
        <el-row>
          <el-form-item label="性别">
            <el-select v-model="formView.sex" style="width: 200px;">
              <el-option label="男" value="1"></el-option>
              <el-option label="女" value="2"></el-option>
            </el-select>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item label="手机">
            <el-input v-model="formView.phone"></el-input>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item label="邮箱">
            <el-input v-model="formView.email"></el-input>
          </el-form-item>
        </el-row>
      </el-form>
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
        formView:{},
        formEdit:{},
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
        vm.formEdit = row;
        vm.editDialog = true;
      },
      viewAdminUser(row){
        const vm = this;
        vm.formView = row;
        vm.viewDialog = true;
      }
    }
  }
</script>
