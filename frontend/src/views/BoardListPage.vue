<template>
  <v-container>
    <v-content>
      <div id="board" class="ma-16" align="center">
          <h2>Text board</h2>
          <br>
          <br>
        <board-list :boards="boards"/>
      </div>
    </v-content>
  </v-container>
</template>

<script>
import BoardList from '@/components/BoardList'
import { mapState, mapActions } from 'vuex'

export default {
  name: 'BoardListPage',
  components: {
    BoardList
  },
  computed: {
    ...mapState(['boards'])
  },
  mounted () {
    this.fetchBoardList()
  },
  methods: {
    ...mapActions(['fetchBoardList'])
  }
}

</script>
