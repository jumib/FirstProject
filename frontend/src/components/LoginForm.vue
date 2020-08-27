<template>
  <v-form @submit.prevent="submit">
    <v-container>
      <v-col cols="12" sm="6">
        <v-text-field
          v-model="userid"
          label="id"
          clearable
        ></v-text-field>
        <v-text-field
          v-model="password"
          label="pw"
          clearable
        ></v-text-field>
      </v-col>
    </v-container>
    <v-col class="text-center" cols="12" sm="4">
      <div class="my-2">
        <v-btn depressed small
        type="submit">로그인</v-btn>
      </div>
      <div class="my-2">
        <v-btn depressed small
        id="login" @click="signup">회원가입</v-btn>
      </div>
    </v-col>
  </v-form>
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
