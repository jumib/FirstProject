<template>
  <div id="board" class="ma-16" align="center">
        <br>
        <br>
        <h2>Info board</h2>
        <br>
        <br>
  <v-container>
    <v-col cols="8">
    <div class="ma-2" align="right">
        <v-btn text depressed small color="#81C784"
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
          <tr v-for="list of paginatedData" :key="list.title" >
            <td style="color: gray">{{ list.newsNo }}</td>
            <td><a :href="list.address"  target="_blank">{{ list.title }}</a></td>
          </tr>
          </tbody>
        </template>
      </v-simple-table>
      <div class="btn-cover">
        <v-btn text :disabled="pageNum === 0"
                @click="prevPage" class="page-btn" depressed small>
          <v-icon>mdi-chevron-double-left</v-icon>
        </v-btn>
        <span class="page-count">{{ pageNum + 1 }} / {{ pageCount }} </span>
        <v-btn text :disabled="pageNum >= pageCount - 1"
                @click="nextPage" class="page-btn" depressed small>
          <v-icon>mdi-chevron-double-right</v-icon>
        </v-btn>
      </div>
      <br>
    </v-card>
    </v-col>
      </v-container>
  </div>
</template>

<script>
import { mapState } from 'vuex'

export default {
  name: '',
  data () {
    return {
      pageNum: 0
    }
  },
  props: {
    pageSize: {
      type: Number,
      required: true,
      default: 10
    }
  },
  component: { },
  computed: {
    ...mapState({
      lists: state => state.lists
    }),
    pageCount () {
      const listLen = this.lists.length
      const listSize = this.pageSize
      let page = Math.floor(listLen / listSize)
      if (listLen % listSize > 0) {
        page += 1
      }
      return page
    },
    paginatedData () {
      const start = this.pageNum * this.pageSize
      const end = start + this.pageSize
      return this.lists.slice(start, end)
    }
  },
  methods: {
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
