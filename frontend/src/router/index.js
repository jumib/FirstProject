import Vue from 'vue'
import VueRouter from 'vue-router'
// import Home from '../views/Home.vue'

// For Login System
import LoginPage from '../views/LoginPage.vue'
import AdminSetupPage from '../views/AdminSetupPage.vue'
import MainPage from '../views/MainPage.vue'
import SignupPage from '../views/SignupPage.vue'

// 페이지
import FavorPage from '../views/FavorPage.vue'
import PictureBoardPage from '../views/PictureBoardPage.vue'
import ItemsPage from '../views/ItemsPage.vue'

// 게시판
import VuetifyBoardListPage from '../views/VuetifyBoardListPage.vue'
import BoardListPage from '../views/BoardListPage.vue'
import BoardRegisterPage from '../views/BoardRegisterPage.vue'
import BoardModifyPage from '../views/BoardModifyPage.vue'
import BoardReadPage from '../views/BoardReadPage.vue'

// 크롤링게시판
// import CrawlCategory from '../views/CrawlCategory.vue'

Vue.use(VueRouter)

const routes = [
  // {
  //   path: '/',
  //   name: 'Home',
  //   component: Home
  // },
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
    path: '/VuetifyBoardListPage',
    name: 'VuetifyBoardListPage',
    components: {
      default: VuetifyBoardListPage
    }
  },
  {
    path: '/BoardRegisterPage',
    name: 'BoardRegisterPage',
    components: {
      default: BoardRegisterPage
    }
  },
  {
    path: '/FavorPage',
    name: 'FavorPage',
    components: {
      default: FavorPage
    }
  },
  {
    path: '/PictureBoardPage',
    name: 'PictureBoardPage',
    components: {
      default: PictureBoardPage
    }
  },
  {
    path: '/ItemsPage',
    name: 'ItemsPage',
    components: {
      default: ItemsPage
    }
  },
  {
    path: '/board',
    name: 'BoardListPage',
    components: {
      default: BoardListPage
    }
  },
  {
    path: '/board/create',
    name: 'BoardRegisterPage',
    components: {
      default: BoardRegisterPage
    }
  },
  {
    path: '/board/:boardNo',
    name: 'BoardReadPage',
    components: {
      default: BoardReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/board/:boardNo/edit',
    name: 'BoardModifyPage',
    components: {
      default: BoardModifyPage
    },
    props: {
      // 이 옵션을 설정하면 route.params가 컴포넌트의 props에 자동 설정됨
      default: true
    }
  }
//   {
//     path: '/CrawlCategory',
//     name: 'CrawlCategory',
//     components: {
//       default: CrawlCategory
//     }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
