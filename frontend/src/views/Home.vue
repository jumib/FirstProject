<template>
  <div class="home">
    <div id="header" v-if="isAuthorized">
      <button id="login" @click="onClickLogout">Logout</button>
      <router-link :to="{ name: 'Home' }"
          class="nav-link"
          active-class="active">
          Home
      </router-link>
      <router-link :to="{ name: 'MainPage' }"
          class="nav-link"
          active-class="active">
          MainPage
      </router-link>
      <h2 align="center">hi</h2>
      <div align="center">
        <br><span>{{ myinfo.auth }}, welcome !</span>
      </div>
    </div>
    <div id="header" v-else>
      <button id="login" @click="$router.push('LoginPage')">
        Login
      </button>
      <br>
      <button id="login" @click="$router.push('AdminSetupPage')">
        Register Admin
      </button>
      <router-link :to="{ name: 'Home' }"
          class="nav-link"
          active-class="active">
        Home
      </router-link>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
// import HelloWorld from '@/components/HelloWorld.vue'
/* eslint-disable no-unused-vars */
import store from '../store'
import Vue from 'vue'
// import cookies from 'vue-cookies'

import { mapState, mapGetters, mapActions } from 'vuex'

// Vue.use(cookies)

export default {
  name: 'Home',
  data: function () {
    return {
      message: 'Vue Test Message'
    }
  },
  methods: {
    onClickLogout () {
      this.logout()
      alert('Success Logout')
      this.$router.push({ name: 'Home' })
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

<style scoped>
div {
  border: 1px solid #ccc;
}

#header {
  padding: 15px;
  margin-bottom: 15px;
  margin: 5px 5px;
}

img {
  width: auto;
  height: auto;
  max-width: 1000px;
  max-height: 350px;
  display: block;
  margin-left: auto;
  margin-right: auto;
}

#login {
  background-color: #ffffff;
  color: #111111;
  font-weight: bold;
  float: right;
}

</style>
