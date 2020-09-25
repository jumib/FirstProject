<template>
  <v-container>
  <v-col cols="10">
  <div class="ma-4" align="right">
    <v-btn depressed small dark
    @click="$router.push('BoardRegisterPage')">register</v-btn>
  </div>
  <v-card>
    <v-card-title>
      <v-spacer></v-spacer>
      <v-spacer></v-spacer>
      <v-spacer></v-spacer>
      <v-spacer></v-spacer>
      <v-spacer></v-spacer>
      <v-spacer></v-spacer>
      <v-text-field
        v-model="search"
          append-icon=""
          class="ma-3"
          flat
          hide-details
          label="search"
          prepend-inner-icon=""
          solo-inverted
      ></v-text-field>
      <v-icon>mdi-magnify</v-icon>
    </v-card-title>
    <br>
    <v-data-table
      class="ma-7"
      :headers="headers"
      :items="boards"
      :search="search"
      @click:row="read"
    ></v-data-table>
  </v-card>
  </v-col>
  </v-container>
</template>

<script>

export default {
  data () {
    return {
      search: '',
      headers: [
        { text: 'No', value: 'boardNo' },
        { text: 'Title', value: 'title' },
        { text: 'Writer', value: 'writer' }
      ]
    }
  },
  props: {
    boards: {
      type: Array
    }
  },
  methods: {
    read (item) {
      console.log(item.boardNo)
      this.$router.push({ name: 'BoardReadPage', params: { boardNo: item.boardNo } })
    }
  }
}
</script>
