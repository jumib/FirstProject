<template>
  <v-app id="inspire">
  <header>
    <v-app-bar
      app
      clipped-right
      color="#FFFFFF"
    >
     <v-app-bar-nav-icon @click.stop="drawer = !drawer" color="#B71C1C"></v-app-bar-nav-icon>
     <v-toolbar-title><div @click="$router.push('MainPage')">our interior</div></v-toolbar-title>
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
            <v-icon color="#B71C1C">mdi-account</v-icon>
            </button>
            <v-spacer></v-spacer>
            <button id="login" @click="$router.push('AdminSetupPage')">
            <v-icon color="#B71C1C">mdi-account-supervisor</v-icon>
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
              <v-list-item-title @click="category">items</v-list-item-title>
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
              <v-list-item-title @click="picture">Picture</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list>

      </v-navigation-drawer>
      </header>

      <!-- 여기까지 왼쪽 바 -->
    <v-container>
      <v-content id="content">
        <slot name="content" class="font">
              <v-row align="center" justify="center">
                <v-img
                  :src="require('/home/bitai/Downloads/NAVERCloud/interior1.jpeg')"
                  class="my-3"
                  contain
                  max-width="300"
                  max-height="400"
                />
                <v-img
                  :src="require('/home/bitai/Downloads/NAVERCloud/interior2.jpeg')"
                  class="my-3"
                  max-width="300"
                  max-height="400"
                />
                 <v-img
                   :src="require('/home/bitai/Downloads/NAVERCloud/interior3.jpeg')"
                   class="my-3"
                   max-width="300"
                   max-height="400"
                 />
                 <v-img
                   :src="require('/home/bitai/Downloads/NAVERCloud/interior4.jpeg')"
                   class="my-3"
                   contain
                   max-width="300"
                   max-height="400"
                 />
                 <v-img
                    :src="require('/home/bitai/Downloads/NAVERCloud/interior5.jpeg')"
                    class="my-3"
                    contain
                    max-width="300"
                    max-height="400"
                 />
                 <br>
                   <v-img
                     :src="require('/home/bitai/Downloads/NAVERCloud/interior6.jpeg')"
                     class="my-3"
                     contain
                     max-width="300"
                     max-height="400"
                   />
                   <v-img
                     :src="require('/home/bitai/Downloads/NAVERCloud/interior7.jpeg')"
                     class="my-3"
                     max-width="300"
                     max-height="400"
                   />
                    <v-img
                      :src="require('/home/bitai/Downloads/NAVERCloud/interior8.jpeg')"
                      class="my-3"
                      max-width="300"
                      max-height="400"
                    />
                    <v-img
                      :src="require('/home/bitai/Downloads/NAVERCloud/interior9.jpeg')"
                      class="my-3"
                      contain
                      max-width="300"
                      max-height="400"
                    />
                    <v-img
                       :src="require('/home/bitai/Downloads/NAVERCloud/interior10.jpeg')"
                       class="my-3"
                       contain
                       max-width="300"
                       max-height="400"
                    />
                  </v-row>
                  <template v-slot:placeholder>
                    <v-row
                      class="fill-height ma-0"
                      align="center"
                      justify="center"
                    >
                      <v-progress-circular indeterminate color="grey lighten-5"></v-progress-circular>
                    </v-row>
                  </template>
        </slot>
      </v-content>
    </v-container>

    <v-footer
      app
      color="#B71C1C"
      dark
      class="white--text"
    >
    <v-card
        flat
        tile
        class="red darken-4 white--text text-center"
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
    ]
    // items: [
    //   { title: 'login' },
    //   { title: 'my board' },
    //   { title: 'logout' },
    //   { title: 'c/s' }
    // ]
  }),
  methods: {
    category () {
      (window.location.pathname !== '/ItemsPage') ? router.push('/ItemsPage') : router.go(0)
    },
    suggest () {
      (window.location.pathname !== '/suggestednews/list') ? router.push('/suggestednews/list') : router.go(0)
    },
    savednews () {
      (window.location.pathname !== '/savednews/list') ? router.push('/savednews/list') : router.go(0)
    },
    board () {
      this.$router.push({ name: 'BoardListPage' })
    },
    picture () {
      this.$router.push({ name: 'FilePondPage' })
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
