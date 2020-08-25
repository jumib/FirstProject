<template>
  <div align="center">
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <h2>Sign up</h2>
    <br>
    <br>
    <br>
    <signup-form @submit="onSubmit"/>
  </div>
</template>

<script>
import axios from 'axios'
import SignupForm from '@/components/SignupForm.vue'

export default {
  name: 'SignupPage',
  components: {
    SignupForm
  },
  methods: {
    onSubmit (payload) {
      console.log('payload: ' + payload.Id + ', ' + payload.Pw + ', ' + payload.Name + ', ' + payload.Dob + ', ' + payload.Contact)
      const { Id, Pw, Name, Dob, Contact } = payload
      axios.post('http://localhost:7777/postsignup',
        { Id, Pw, Name, Dob, Contact })
        .then(res => {
          alert('Register Success')
          this.$router.push({
            name: 'Home'
          })
        })
        .catch(err => {
          alert(err.response.data)
        })
    }
  }
}
</script>
