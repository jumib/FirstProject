<template>
  <div id="board" class="ma-16" align="center">
        <br>
        <br>
        <h2>Info board</h2>
        <br>
        <br>
  <v-container>
    <v-col cols="8">
    <div class="ma-4" align="right">
        <v-btn text depressed small color="green"
             @click="start()">A collection of living articles by topic to read today</v-btn>
    </div>
    <v-card>
      <v-simple-table class="ma-7">
        <template v-slot:default>
          <thead>
          <tr>
            <th class="text-left">No.</th>
            <th class="text-left">제목</th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="list of lists" :key="list.title">
            <td style="color: gray">{{ list.newsNo }}</td>
            <td><a @click="clickNews(list.newsNo)">{{ list.title }}</a></td>
          </tr>
          </tbody>
        </template>
      </v-simple-table>

      <div class="btn-cover">
        <button :disabled="pageNum === 0"
                @click="prevPage" class="page-btn">
          이전
        </button>
        <span class="page-count">{{ pageNum + 1 }} / {{ pageCount }} 페이지</span>
        <button :disabled="pageNum >= pageCount - 1"
                @click="nextPage" class="page-btn">
          다음
        </button>
      </div>
    </v-card>
    </v-col>
      </v-container>
  </div>
</template>

<script>
import { mapState } from 'vuex'

export default {
  data () {
    return {
      pageNum: 0
    }
  },
  props: {
    listArray: {
      type: Array,
      required: true
    },
    pageSize: {
      type: Number,
      required: true,
      default: 5
    }
  },
  component: { },
  computed: {
    ...mapState({
      lists: state => state.lists
    })
  },
  methods: {
    clickNews (newsNo) {
      console.log('clickNews: ' + newsNo)
      this.$store.dispatch('crawlFindOne', newsNo)
    },
    start () {
      this.$store.dispatch('crawlFind')
    },
    nextPage () {
      this.pageNum += 1
    },
    prevPage () {
      this.pageNum -= 1
    }
  }
}
</script>
