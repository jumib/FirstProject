<template>
  <v-form @submit.prevent="submit">
    <v-container>
      <v-col cols="4">
        <v-row>
          <v-text-field
              v-model="userId"
              label="e-mail"
              clearable
            ></v-text-field>
            <v-btn class="mt-4" depressed small color="white" @click="check"><v-icon>mdi-check</v-icon></v-btn>
        </v-row>
        <v-row>
        <v-text-field
          v-model="userPw"
          label="password"
          clearable
        ></v-text-field><v-btn depressed small color="white"></v-btn>
        </v-row>
        <v-row>
        <v-text-field
          v-model="userName"
          label="name"
          clearable
        ></v-text-field><v-btn depressed small color="white"></v-btn>
        </v-row>
      </v-col>
    </v-container>
    <v-col class="text-center" cols="12" sm="4">
      <div class="my-2">
        <v-btn depressed small type="submit" color="green" dark>complete</v-btn>
      </div>
      <br>
      <v-btn depressed small color="green" @click="$router.push('LoginPage')">back</v-btn>
    </v-col>
  </v-form>
</template>

<script>
/*eslint-disable*/
import axios from 'axios'

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
    },
    check () {
      // alert("확인")
      axios.get(`http://localhost:7777/users/check/${this.userId}`)
        .then(res => {
          console.log(res)
          if (res.status === 200) {
            if(res.data === 'ok'){
              alert("사용가능합니다")
            } else {
              alert("중복된 Id 입니다")
            }
          }
        })
        .catch(err => {
          console.log(err)
        })
    }
  }
}
</script>
