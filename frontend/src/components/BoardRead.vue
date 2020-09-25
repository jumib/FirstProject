<template>
  <div>
    <v-container>
      <v-col cols="8">
        <v-textarea :value="board.title" rows="1" readonly label="title" row-height="25"></v-textarea>
        <v-textarea :value="board.writer" rows="1" readonly  label="writer" row-height="25"></v-textarea>
        <v-textarea :value="board.content" rows="5" readonly  label="content" row-height="25"></v-textarea>
      </v-col>
    </v-container>
  </div>
</template>

<script>
export default {
  name: 'BoardRead',
  props: {
    board: {
      type: Object,
      required: true
    }
  }
}
</script>
