import Vue from 'vue'
import Router from 'vue-router'
import login from '@/components/login'
import adminReg from '@/components/adminReg'
import adminIndex from '@/components/index'
import welcome from '@/components/welcome/welcome'
import userList from '@/components/user/userList'
import confList from '@/components/conf/confList'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      component: login
    },
    {
      path: '/admin/index',
      name: 'adminIndex',
      component: adminIndex,
      children:[
        {
          path:'/welcome',
          name:'welcome',
          component:welcome
        },
        {
          path:'/userList',
          name:'userList',
          component:userList
        },
        {
          path:'/confList',
          name:'confList',
          component:confList
        }
      ]
    },
    {
      path: '/admin/adminReg',
      name: 'adminReg',
      component: adminReg
    }
  ]
})
