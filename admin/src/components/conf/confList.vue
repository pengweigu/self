<template>
  <div><!--一个模板只能有一个艮节点  多个时使用div包起来-->
    <el-table
      :data="tableData"
      stripe
      style="width: 100%">
      <el-table-column
        prop="code"
        label="编码">
      </el-table-column>
      <el-table-column
        prop="value"
        label="内容">
      </el-table-column>
      <el-table-column
        label="操作">
        <template slot-scope="scope">
          <el-button type="text" size="small">查看</el-button>
          <el-button type="text" size="small">编辑</el-button>
          <el-button type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>
<script>
  export default {
    name:'confList',
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
      }
    }
  }
</script>
