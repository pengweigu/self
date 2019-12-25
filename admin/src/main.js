import Vue from 'vue'
import App from './App'
import router from './router'

import Axios from 'axios'
Vue.prototype.$axios = Axios

//npm install element-ui -S
import Element from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

Vue.use(Element)

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
