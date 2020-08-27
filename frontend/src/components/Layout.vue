<template>
  <v-app id="inspire">
    <v-app-bar
      app
      clipped-right
      color="white"
    >
     <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
     <v-toolbar-title><div @click="$router.push('MainPage')">our home</div></v-toolbar-title>
      <v-spacer></v-spacer>
      <slot name="menubar"></slot>

      <template>
        <div class="home">
          <!-- <img alt="Vue logo" src="../assets/logo.png"> -->
          <div id="header" v-if="isAuthorized">
            <button id="login" @click="onClickLogout" >Logout</button>
          </div>
          <div id="header" v-else>
            <button id="login" @click="$router.push('LoginPage')">
            <v-icon>mdi-account</v-icon>
              Login
            </button>
            <v-spacer></v-spacer>
            <button id="login" @click="$router.push('AdminSetupPage')">
            <v-icon>mdi-account-supervisor</v-icon>
              Register
            </button>
          </div>
        </div>
      </template>

    </v-app-bar>

    <!-- 여기부터 왼쪽 바 -->
    <v-navigation-drawer
      v-model="drawer"
      app
    >
      <v-list dense>
        <v-list-item @click.stop="left = !left">
          <v-list-item-action>
            <v-icon>mdi-exit-to-app</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title @click="home">Home</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>

        <v-list dense>
          <v-list-item @click.stop="left = !left">
            <v-list-item-action>
              <v-icon>mdi-exit-to-app</v-icon>
            </v-list-item-action>
            <v-list-item-content>
              <v-list-item-title @click="category">Crawling</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list>

        <v-list dense>
          <v-list-item @click.stop="left = !left">
            <v-list-item-action>
              <v-icon>mdi-exit-to-app</v-icon>
            </v-list-item-action>
            <v-list-item-content>
              <v-list-item-title @click="suggest">Suggest</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list>

        <v-list dense>
          <v-list-item @click.stop="left = !left">
            <v-list-item-action>
              <v-icon>mdi-exit-to-app</v-icon>
            </v-list-item-action>
            <v-list-item-content>
              <v-list-item-title @click="board">Board</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list>

        <v-list dense>
          <v-list-item @click.stop="left = !left">
            <v-list-item-action>
              <v-icon>mdi-exit-to-app</v-icon>
            </v-list-item-action>
            <v-list-item-content>
              <v-list-item-title @click="savednews()">Saved</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list>
      </v-navigation-drawer>
      <!-- 여기까지 왼쪽 바 -->

      <v-spacer></v-spacer>
      <template>
        <v-carousel hide-delimiters>
          <v-carousel-item
            v-for="(item,i) in items"
            :key="i"
            :src="item.src"
          ></v-carousel-item>
        </v-carousel>
      </template>

    <v-container>
      <v-content id="content">
        <slot name="content" class="font">
        </slot>
      </v-content>
    </v-container>

    <v-footer
      app
      color="#FF7043"
      dark
      class="white--text"
    >
    <v-card
        flat
        tile
        class="deep-orange lighten-1 white--text text-center"
        dark
      >
        <v-card-text>
          <v-btn
            v-for="icon in icons"
            :key="icon"
            class="mx-4 white--text"
            icon
          >
            <v-icon size="20px">{{ icon }}</v-icon>
          </v-btn>
        </v-card-text>

        <v-card-text class="white--text pt-0">
         Phasellus feugiat arcu sapien, et iaculis ipsum elementum sit amet. Mauris cursus commodo interdum. Praesent ut risus eget metus luctus accumsan id ultrices nunc. Sed at orci sed massa consectetur dignissim a sit amet dui. Duis commodo vitae velit et faucibus. Morbi vehicula lacinia malesuada. Nulla placerat augue vel ipsum ultrices, cursus iaculis dui sollicitudin. Vestibulum eu ipsum vel diam elementum tempor vel ut orci. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.
        </v-card-text>

        <v-divider></v-divider>

        <v-card-text class="white--text">
          {{ new Date().getFullYear() }} — <strong>interior</strong>
        </v-card-text>
      </v-card>
    </v-footer>
  </v-app>
</template>

<script>
import router from '../router'
// import store from '../store'
// import Vue from 'vue'
import { mapState, mapGetters, mapActions } from 'vuex'

export default {
  data: () => ({
    drawer: false,
    left: false,
    icons: [
      'mdi-facebook',
      'mdi-twitter',
      'mdi-linkedin',
      'mdi-instagram'
    ],
    items: [
      {
        src: 'https://cdn.vuetifyjs.com/images/carousel/squirrel.jpg'
      },
      {
        src: 'https://cdn.vuetifyjs.com/images/carousel/sky.jpg'
      },
      {
        src: 'https://cdn.vuetifyjs.com/images/carousel/bird.jpg'
      },
      {
        src: 'https://cdn.vuetifyjs.com/images/carousel/planet.jpg'
      }
    ]
    // items: [
    //   { title: 'login' },
    //   { title: 'my board' },
    //   { title: 'logout' },
    //   { title: 'c/s' }
    // ]
  }),
  methods: {
    home () {
      (window.location.pathname !== '/') ? router.push('/') : router.go(0)
    },
    category () {
      (window.location.pathname !== '/CrawlCategory') ? router.push('/CrawlCategory') : router.go(0)
    },
    suggest () {
      (window.location.pathname !== '/suggestednews/list') ? router.push('/suggestednews/list') : router.go(0)
    },
    savednews () {
      (window.location.pathname !== '/savednews/list') ? router.push('/savednews/list') : router.go(0)
    },
    board () {
      this.$router.push({ name: 'VuetifyBoardListPage' })
    },
    onClickLogout () {
      this.logout()
      alert('Success Logout')
      this.$router.push({ name: 'MainPage' })
    },
    ...mapActions(['logout'])
  },
  computed: {
    ...mapState(['myinfo']),
    ...mapGetters(['isAuthorized'])
  },
  components: {
  }
}

</script>
