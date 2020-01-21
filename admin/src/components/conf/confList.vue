<template>
  <div><!--一个模板只能有一个艮节点  多个时使用div包起来-->
    <el-table
      :data="tableData"
      stripe
      style="width: 100%">
      <el-table-column
        prop="name"
        label="描述">
      </el-table-column>
      <el-table-column
        prop="value"
        label="内容">
      </el-table-column>
      <el-table-column
        label="操作">
        <template slot-scope="scope">
          <el-button type="text" size="small" @click="editSysConf(scope.row)">编辑</el-button>
          <el-button type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!--编辑窗口-->
    <el-dialog title="编辑" :visible.sync="editDialog" width="50%">
      <el-form :inline="true" label-width="100px" :model="formEdit" ref="formEdit" class="demo-form-inline">
        <el-input type="hidden" v-model="formEdit.code"></el-input>
        <!--1-->
        <el-row>
          <el-form-item label="内容">
            <el-input v-model="formEdit.value"></el-input>
          </el-form-item>
        </el-row>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="formEdit = {}">重 置</el-button>
        <el-button type="primary">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>
<script>
  export default {
    name:'confList',
    data() {
      return {
        tableData: [],
        editDialog: false,
        formEdit:{},
      }
    },
    created() {
      const vm = this;
      vm.selectConf();
    },
    methods:{
      selectConf(){
        const vm = this;
        vm.$axios.post('/admin/sys/list.json',{}).then(function (res) {
          if(res.data.isSuccess == "true") {
            vm.tableData = res.data.items;
          }else{
            vm.tableData = [];
          }
        }).catch(function (error) {
          vm.$message.error("查询列表数据异常！");
        });
      },
      editSysConf(row){
        const vm = this;
        vm.formEdit = row;
        vm.editDialog = true;
      }
    }
  }
</script>
