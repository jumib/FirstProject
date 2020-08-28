<template>
  <div align="center">
    <h2>자유게시판</h2>
      <div class="my-2" align="right">
        <v-btn depressed small
        @click="$router.push('BoardRegisterPage')">작성하기</v-btn>
        <v-spacer></v-spacer>
        <v-btn depressed small
        @click="$router.push('MainPage')">메인으로</v-btn>
      </div>
    <board-list-page-form :list-array="pageArray"/>
    <!-- 라우터는 게시판, 실질적 페이지네이션은 바로윗줄
    요렇게 다 다른데서 긁어올 수 있는게(연결 가능) 뷰의 장점이다 -->
  </div>
</template>

<script>
import axios from 'axios'
import BoardListPageForm from '@/components/BoardListPageForm.vue'

export default {
  name: 'VuetifyBoardListPage',
  components: {
    BoardListPageForm
  },
  data () {
    return {
      pageArray: []
    }
  },
  created () {
    // 여기서 받아오는 게 젤 중요. 액션, 뮤테이션 등 스토어에 분리하는게 좋다
    axios.get('http://localhost:7777/boards')
      .then(res => {
        console.log(res)
        this.pageArray = res.data
        // 위 유알엘에서 받아 온 값
      })
      .catch(err => {
        console.log(err)
      })
  }
}
</script>
