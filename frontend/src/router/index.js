import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

// For Login System
import LoginPage from '../views/LoginPage.vue'
import AdminSetupPage from '../views/AdminSetupPage.vue'
import MainPage from '../views/MainPage.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/LoginPage',
    name: 'LoginPage',
    components: {
      default: LoginPage
    }
  },
  {
    path: '/AdminSetupPage',
    name: 'AdminSetupPage',
    components: {
      default: AdminSetupPage
    }
  },
  {
    path: '/MainPage',
    name: 'MainPage',
    components: {
      default: MainPage
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
