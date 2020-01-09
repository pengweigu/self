<template>
  <div class="app">
    <el-container>
      <el-aside class="app-side app-side-left" :class="isCollapse ? 'app-side-collapsed' : 'app-side-expanded'">
        <div class="app-side-logo">
          <img src="@/assets/head.png" :width="isCollapse ? '60' : '60'" height="60" />
        </div>
        <div>
          <!-- 左边菜单 开始-->
          <el-menu :default-active="defaultActive" class="el-menu-vertical" @open="handleOpen" :collapse="isCollapse">
            <el-submenu index="1">
              <template slot="title">
                <i class="el-icon-location"></i>
                <span slot="title">后台管理</span>
              </template>
              <el-menu-item-group>
                <el-menu-item @click="leftMumClick('userList')" index="1-1">后台用户管理</el-menu-item>
                <el-menu-item @click="leftMumClick('')" index="1-2">后台权限管理</el-menu-item>
              </el-menu-item-group>
            </el-submenu>
          </el-menu>
        </div>
      </el-aside>
      <!--头部菜单 开始-->
      <el-container>
        <el-header class="app-header">
          <div style="width: 60px; cursor: pointer;" @click.prevent="toggleSideBar">
            <i v-show="!isCollapse" class="el-icon-d-arrow-left"></i>
            <i v-show="isCollapse" class="el-icon-d-arrow-right"></i>
          </div>
          <!-- 我是样例菜单 -->
          <el-menu style="float: left;width: 100%;" default-active="" class="el-menu-demo tab-page" mode="horizontal" @select="handleSelect" active-text-color="#409EFF">
            <el-menu-item @click="topMumClick('adminIndex')" index="1">首页</el-menu-item>
            <el-submenu index="2">
              <template slot="title">我的工作台</template>
              <el-menu-item index="2-1">选项1</el-menu-item>
              <el-menu-item index="2-2">选项2</el-menu-item>
              <el-submenu index="2-4">
                <template slot="title">选项4</template>
                <el-menu-item index="2-4-1">选项1</el-menu-item>
                <el-menu-item index="2-4-2">选项2</el-menu-item>
              </el-submenu>
            </el-submenu>
          </el-menu>

          <div style="float: right;" class="app-header-userinfo">
            <el-dropdown trigger="hover" :hide-on-click="false">
              <span class="el-dropdown-link">
                <font color="white">{{ username }}</font>
                <i class="el-icon-arrow-down el-icon--right"></i>
              </span>
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item>我的消息</el-dropdown-item>
                <el-dropdown-item>设置</el-dropdown-item>
                <el-dropdown-item divided @click.native="logout">退出登录</el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
          </div>
        </el-header>

        <el-main class="app-body">
          <template>
            <router-view/>
          </template>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
  export default {
    name: 'adminIndex',
    data() {//有data 必须返回一个对象
      return {
        defaultActive: "",
        username: '彭伟',
        isCollapse: false
      }
    },
    methods: {
      toggleSideBar() {
        this.isCollapse = !this.isCollapse
      },
      logout: function () {
        this.$router.push({path: '/'});
      },
      handleOpen(key, keyPath) {
        console.log(key +';'+keyPath)
      },
      handleClose(key, keyPath) {

      },
      handleSelect(key, keyPath) {
        console.log(key +';'+keyPath)
      },
      leftMumClick(path){
        console.log(path)
        this.$router.push({name:path})
      },
      topMumClick(path){
        if(this.$CommonUtils.isNull(path)){

        }
        //如果是首页 设置左边菜单不选中
        if('adminIndex' == path){
          this.defaultActive = "1";
        }
        this.$router.push({name:path})
      }
    },
    mounted: function () {

    },
    created() {

    }
  }
</script>

<style>

</style>
