<template>
  <Layout>
    <template #menubar>
      <v-btn id="login" @click="$router.push('LoginPage')" text color="black"
        style="padding: 10px; width: 70px;">login</v-btn>
      <v-btn @click="start('politics')" text color="black"
        style="padding: 10px; width: 90px;"> signup</v-btn>
    </template>
    <template #content>
      <v-simple-table> <!-- 옆을 작성했기때문에 테이블형태 가능 -->
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
    </template>
    <div
          class="card-image"
          :style="{ backgroundImage: 'url(' + require('/home/bitai/Downloads/background.jpg') + ')' }"></div>
  </Layout>
</template>

<script>
import Layout from '../components/Layout'
import { mapState } from 'vuex'
export default {
  components: { Layout },
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
    start (category) {
      this.$store.dispatch('crawlFind', category)
    }
  }
}
</script>

<style scoped lang="scss">
.container {
  height: 40px;
  width: 40px;
  background-image: url('/home/bitai/Downloads/background.jpg');
}
</style>
