<template>
  <div>
    <v-form @submit.prevent="onSubmit">
      <v-container>
        <v-col cols="8">
        <v-text-field
          v-model="title"
          label="title"
          clearable
        ></v-text-field>
        <v-text-field
          :value="board.writer"
          label="writer"
          disabled
        ></v-text-field>
        <v-textarea v-model="content" rows="5" label="content" outlined  row-height="30"></v-textarea>
        </v-col>
      </v-container>
      <v-row justify="center">
        <v-btn depressed small type="submit" color="green" dark>complete</v-btn>
      </v-row>
      <br>
      <v-row justify="center">
        <v-btn depressed small color="green"
               router-link :to="{ name: 'BoardReadPage', params: { boardNo: board.boardNo.toString() } }">back</v-btn>
      </v-row>
    </v-form>
  </div>
</template>

<script>
export default {
  name: 'BoardModifyForm',
  props: {
    board: {
      type: Object,
      required: true
    }
  },
  data () {
    return {
      title: '',
      content: ''
    }
  },
  methods: {
    onSubmit () {
      const { title, content } = this
      this.$emit('submit', { title, content })
    }
  },
  created () {
    this.title = this.board.title
    this.content = this.board.content
  }
}
</script>
