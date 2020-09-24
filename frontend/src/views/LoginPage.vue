<template>
  <v-container>
    <v-content>
      <div class="ma-16" align="center">
        <h1>Log in</h1>
        <br>
        <br>
        <br>
        <login-form @submit="onSubmit" />
      </div>
    </v-content>
  </v-container>
</template>

<script>
import LoginForm from '@/components/LoginForm.vue'
import { mapActions } from 'vuex'

export default {
  name: 'LoginPage',
  components: {
    LoginForm
  },
  methods: {
    onSubmit (payload) {
      console.log('loginPage onSubmit()')
      this.login(payload).then(res => {
        alert('Login Success')
        this.$router.push({ name: 'MainPage' })
      }).catch(err => {
        // alert(err.response.data.message)
        alert('Something Fail: ', err)
      })
    },
    ...mapActions(['login'])
  }
}
</script>
