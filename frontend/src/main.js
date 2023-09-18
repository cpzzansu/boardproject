import Vue from 'vue'
import App from './App.vue'
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue';
// Bootstrap CSS 및 BootstrapVue CSS 임포트
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';
import axios from 'axios';
import Home from "@/components/Home.vue";
import VueRouter from 'vue-router';



Vue.config.productionTip = false
Vue.prototype.$http = axios;
Vue.use(BootstrapVue);
Vue.use(IconsPlugin);

let routes = [
  {
    path: "/",
    name: "home",
    component: Home,
  },
];

let router = new VueRouter({
  routes
});

new Vue({
  render: h => h(App),
  router
}).$mount('#app');
