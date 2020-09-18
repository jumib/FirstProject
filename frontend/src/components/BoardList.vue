<template>
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
          class="mr-6"
          flat
          hide-details
          label="Search ..."
          prepend-inner-icon=""
          solo-inverted
      ></v-text-field>
    </v-card-title>
    <v-data-table
      class="ma-7"
      :headers="headers"
      :items="boards"
      :search="search"
      @click:row="readcontent"
    ></v-data-table>
  </v-card>
</template>

<script>

export default {
  data () {
    return {
      search: '',
      headers: [
        {},
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
    readcontent (item) {
      console.log(item.boardNo)
      // alert('즐')
      this.$router.push({ name: 'BoardReadPage', params: { boardNo: item.boardNo } })
    }
  }
}
</script>
