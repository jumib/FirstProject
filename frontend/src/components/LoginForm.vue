<template>
  <form @submit.prevent="submit">
    <table>
      <tr>
        <td>Id</td>
        <td><input type="text" v-model="userid"></td>
      </tr>
      <tr>
        <td>Password</td>
        <td><input type="password" v-model="password"></td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <button type="submit">log in</button>
        </td>
        <td colspan="2" align="center">
          <button id="login" @click="signup">
            Signup
          </button>
        </td>
      </tr>
    </table>
  </form>
</template>

<script>

export default {
  name: 'LoginForm',
  data () {
    return {
      userid: '',
      password: ''
    }
  },
  methods: {
    submit () {
      console.log('LoginForm submit()')
      const { userid, password } = this
      this.$emit('submit', { userid, password })
    },
    signup () {
      this.$router.push({ name: 'SignupPage' })
    }
  }
}
</script>
