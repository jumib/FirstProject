<template>
  <v-card>
    <v-card-title>
      BOARD
      <v-spacer></v-spacer>
      <v-spacer></v-spacer>
      <v-text-field
        v-model="search"
        append-icon="mdi-magnify"
        label="Search"
        single-line
        hide-details
      ></v-text-field>
    </v-card-title>
    <v-data-table
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
        {
          text: '',
          align: 'start',
          sortable: false,
          value: 'name'
        },
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
