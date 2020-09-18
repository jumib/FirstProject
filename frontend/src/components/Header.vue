<template>
  <v-app>
    <v-app-bar
    app
    clipped-right
    color="#424242"
    flat
    dense
    >
    <v-app-bar-nav-icon @click.stop="drawer = !drawer" color="#FFFFFF"></v-app-bar-nav-icon>
    <v-btn text @click="$router.push('MainPage')" color="#FFFFFF">our interior</v-btn>
    <v-spacer></v-spacer>
      <slot name="menubar">
        <div class="home">
          <div id="header" v-if="isAuthorized">
            <v-btn text id="login" @click="onClickLogout" color="#FFFFFF">Logout</v-btn>
            <v-btn text color="#FFFFFF">
              <v-icon>mdi-bell</v-icon>
            </v-btn>
          </div>
        <div id="header" v-else>
          <v-btn text id="login" @click="$router.push('LoginPage')" color="#FFFFFF">
            Login</v-btn>
        </div>
        </div>
      </slot>
    </v-app-bar>
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
  </v-app>
</template>

<script>
import router from '../router'
import { mapState, mapGetters, mapActions } from 'vuex'

export default {
  data: () => ({
    drawer: false,
    left: false
  }),
  methods: {
    category () {
      (window.location.pathname !== '/ItemsPage') ? router.push('/ItemsPage') : router.go(0)
    },
    board () {
      this.$router.push({ name: 'BoardListPage' })
    },
    picture () {
      this.$router.push({ name: 'PondListPage' })
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
