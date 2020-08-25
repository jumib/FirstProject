<template>
  <form @submit.prevent="submit">
    <table>
      <tr>
        <td>Id</td>
        <td><input type="text" v-model="Id"></td>
      </tr>
      <br>
      <tr>
        <td>Password</td>
        <td><input type="password" v-model="Pw"></td>
      </tr>
      <br>
      <tr>
        <td>Name</td>
        <td><input type="text" v-model="Name"></td>
      </tr>
      <br>
      <tr>
        <td>Day of birth</td>
        <td><input type="text" v-model="Dob"></td>
      </tr>
      <br>
      <tr>
        <td>Contact</td>
        <td><input type="text" v-model="Contact"></td>
      </tr>
    </table>
    <br>
    <div>
      <button type="submit">complete</button>
    </div>
  </form>
</template>

<script>
export default {
  name: 'SignupForm',
  data () {
    return {
      Id: '',
      Pw: '',
      Name: '',
      Dob: '',
      Contact: ''
    }
  },
  methods: {
    submit () {
      console.log('this: ' + this.Id +
                  ', ' + this.Pw +
                  ', ' + this.Name +
                  ', ' + this.Dob +
                  ', ' + this.Contact)
      const { Id, Pw, Name, Dob, Contact } = this
      this.$emit('submit', { Id, Pw, Name, Dob, Contact })
    }
  }
}
</script>
