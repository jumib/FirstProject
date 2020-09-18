<template>
  <v-form @submit.prevent="onSubmit">
    <v-container>
      <v-col cols="12" sm="6">
        <v-text-field
          v-model="title"
          label="title"
          clearable
        ></v-text-field>
        <v-text-field
          v-model="writer"
          label="writer"
          clearable
        ></v-text-field>
        <v-text-field
          v-model="content"
          label="content"
          clearable
        ></v-text-field>
      </v-col>
    </v-container>
    <div>
      <v-btn depressed small
             type="submit">등록</v-btn>
    </div>
  </v-form>
</template>

<script>
export default {
  name: 'BoardRegisterForm',
  data () {
    return {
      title: '',
      writer: '',
      content: ''
    }
  },
  methods: {
    onSubmit () {
      const { title, writer, content } = this
      this.$emit('submit', { title, writer, content })
    }
  }
}
</script>
