<template>
  <v-form @submit.prevent="onSubmit">
    <v-container>
      <v-col cols="8">
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
          <v-textarea
            v-model="content"
            outlined
            auto-grow
            label="content"
            rows="8"
            row-height="20"
          ></v-textarea>
      </v-col>
    </v-container>
    <v-row justify="center">
        <v-btn depressed small color="green" dark
               type="submit">complete</v-btn>
    </v-row>
    <br>
    <v-row justify="center">
      <v-btn depressed small color="green"
             @click="$router.push('/board')">back</v-btn>
    </v-row>
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
