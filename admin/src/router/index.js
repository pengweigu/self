import Vue from 'vue'
import Router from 'vue-router'
import login from '@/components/login'
import adminReg from '@/components/adminReg'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      component: login
    },
    {
      path: '/admin/adminReg',
      name: 'adminReg',
      component: adminReg
    }
  ]
})
