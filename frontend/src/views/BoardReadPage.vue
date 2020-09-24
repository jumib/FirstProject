<template>
  <v-container>
    <v-content>
  <div class="ma-16" align="center">
    <h2>Read page</h2>
    <br>
    <br>
    <br>
    <board-read v-if="board" :board="board"/>
    <p v-else>Loading ...</p>
    <v-row justify="center">
    <v-btn depressed small color="green" dark router-link :to="{ name: 'BoardModifyPage', params: { boardNo } }">
      edit
    </v-btn>
    </v-row>
    <br>
    <v-row justify="center">
    <v-btn depressed small color="green" router-link :to="{ name: 'BoardListPage' }">
      back
    </v-btn>
    </v-row>
    <br>
    <v-row justify="center">
    <v-btn text depressed small @click="onDelete">Are you sure you want to delete?</v-btn>
    </v-row>
  </div>
   </v-content>
    </v-container>
</template>

<script>
import BoardRead from '@/components/BoardRead'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
  name: 'BoardReadPage',
  props: {
    boardNo: {
      type: String,
      required: true
    }
  },
  computed: {
    ...mapState([
      'board'
    ])
  },
  created () {
    console.log('BoardReadPage created(): ' + this.boardNo)
    this.fetchBoard(this.boardNo)
      .catch(err => {
        alert(err.response.data.message)
        this.$router.push()
      })
  },
  methods: {
    ...mapActions([
      'fetchBoard'
    ]),
    onDelete () {
      const { boardNo } = this.board
      axios.delete(`http://localhost:7777/boards/${boardNo}`)
        .then(res => {
          alert('Delete Success')
          this.$router.push({ name: 'BoardListPage' })
        })
        .catch(err => {
          alert(err.response.data.message)
        })
    }
  },
  components: {
    BoardRead
  }
}
</script>
