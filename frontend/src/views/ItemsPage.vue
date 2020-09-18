<template>
  <div id="board" class="ma-16" align="center">
    <div class="ma-3" align="left">
      <v-btn depressed small color="#FFFFFF"
             @click="start()">불러오기</v-btn>
      <v-btn depressed small color="#FFFFFF"
             @click="$router.push('MainPage')">메인으로</v-btn>
    </div>
    <v-card>
      <v-card-title>
        news
      </v-card-title>
      <v-simple-table>
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
    </v-card>
  </div>
</template>

<script>
import { mapState } from 'vuex'

export default {
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
    }
  }
}
</script>
