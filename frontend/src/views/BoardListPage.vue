<template>
  <div id="board" align="center">
    <div class="my-2" align="right">
      <v-btn depressed small
      @click="$router.push('BoardRegisterPage')">작성하기</v-btn>
      <v-btn depressed small
      @click="$router.push('MainPage')">메인으로</v-btn>
    </div>
    <board-list :boards="boards"/>
  </div>
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
