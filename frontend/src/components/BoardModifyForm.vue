<template>
  <div>
    <h3>Board Modified Form</h3>
    <v-form @submit.prevent="onSubmit">
      <table>
        <tr>
          <td>No</td>
          <td><input type="text" :value="board.boardNo" disabled></td>
        </tr>
        <tr>
          <td>Registration Date</td>
          <td><input type="text" :value="board.regDate" disabled></td>
        </tr>
        <tr>
          <td>Title</td>
          <td><input type="text" v-model="title"></td>
        </tr>
        <tr>
          <td>Writer</td>
          <td><input type="text" :value="board.writer" disabled></td>
        </tr>
        <tr>
          <td>Content</td>
          <td><textarea v-model="content" rows="5"></textarea></td>
        </tr>
      </table>

      <div>
        <v-btn type="submit">complete<v-icon>mdi-check-bold</v-icon></v-btn>
        <v-btn router-link :to="{ name: 'BoardReadPage', params: { boardNo: board.boardNo.toString() } }"
        >back<v-icon>mdi-arrow-left-bold</v-icon></v-btn>
      </div>
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
