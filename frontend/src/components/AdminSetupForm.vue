<template>
  <v-form @submit.prevent="submit">
    <v-container>
      <v-col cols="12" sm="6">
        <v-text-field
          v-model="userId"
          label="id"
          clearable
        ></v-text-field>
        <v-text-field
          v-model="userPw"
          label="pw"
          clearable
        ></v-text-field>
        <v-text-field
          v-model="userName"
          label="name"
          clearable
        ></v-text-field>
      </v-col>
    </v-container>
    <v-col class="text-center" cols="12" sm="4">
      <div class="my-2">
        <v-btn depressed small
               type="submit">complete</v-btn>
      </div>
      <!-- <div class="my-2">
        <v-btn depressed small
        id="login" @click="signup">회원가입</v-btn>
      </div> -->
    </v-col>
  </v-form>
</template>

<script>
export default {
  name: 'AdminSetupForm',
  data () {
    return {
      userId: '',
      userName: '',
      userPw: ''
    }
  },
  methods: {
    submit () {
      console.log('this: ' + this.userId +
                  ', ' + this.userName +
                  ', ' + this.userPw)
      const { userId, userName, userPw } = this
      this.$emit('submit', { userId, userName, userPw })
    }
  }
}
</script>
