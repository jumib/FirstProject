import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

// For Login System
import LoginPage from '../views/LoginPage.vue'
import AdminSetupPage from '../views/AdminSetupPage.vue'
import MainPage from '../views/MainPage.vue'
import SignupPage from '../views/SignupPage.vue'

//
import FavorPage from '../views/FavorPage.vue'

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
    path: '/SignupPage',
    name: 'SignupPage',
    components: {
      default: SignupPage
    }
  },
  {
    path: '/MainPage',
    name: 'MainPage',
    components: {
      default: MainPage
    }
  },
  {
    path: '/FavorPage',
    name: 'FavorPage',
    components: {
      default: FavorPage
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
