<template>
  <v-form @submit.prevent="submit">
    <v-container>
      <v-col cols="4">
        <v-text-field
          v-model="userid"
          label="e-mail"
          clearable
        ></v-text-field>
        <v-text-field
          input type="password"
          v-model="password"
          label="password"
          clearable
        ></v-text-field>
      </v-col>
    </v-container>
    <v-row>
      <v-col cols="12">
        <div class="my-2">
          <v-btn text depressed small
                 @click="forgot">Forgot your password?</v-btn>
          <br><br>
          <v-btn depressed small
            type="submit" color="green" dark>SIGN IN</v-btn>
          <br><br>
          <v-btn text depressed small
            @click="signup">Creat account</v-btn>
        </div>
      </v-col>
    </v-row>
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
      this.$router.push({ name: 'AdminSetupPage' })
    },
    forgot () {
      this.$router.push({ name: 'ForgotPwPage' })
    }
  }
}
</script>
