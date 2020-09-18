<template>
  <v-card>
    <v-card-title>
      BOARD
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
  }
}
</script>
