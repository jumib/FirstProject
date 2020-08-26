<template>
  <div>
    <h3>Board List View</h3>
    <table border="1">
      <tr>
        <th align="center" width="80">No</th>
        <th align="center" width="320">Title</th>
        <th align="center" width="100">Writer</th>
        <th align="center" width="180">Registration Date</th>
      </tr>
      <tr v-for="page in paginatedData" :key="page.boardNo">
        <td>{{ page.boardNo }}</td>
        <td>{{ page.title }}</td>
        <td>{{ page.writer }}</td>
        <td>{{ page.regDate }}</td>
      </tr>
    </table>
    <div class="btn-cover">
      <button :disabled="pageNum === 0"
        @click="prevPage" class="page-btn">
        이전
      </button>
      <span class="page-count">{{ pageNum + 1 }}<!-- 0부터 시작하니까 +1 해줌--> / {{ pageCount }} 페이지</span>
      <button :disabled="pageNum >= pageCount - 1"
        @click="nextPage" class="page-btn">
        다음
      </button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'VuetifyListPageForm',
  data () {
    return {
      pageNum: 0
    }
  },
  props: {
    // 작대기 없어지고 대문자로 바뀜
    listArray: {
      type: Array,
      required: true
    },
    pageSize: {
      type: Number,
      required: true,
      default: 10
    }
  },
  methods: {
    nextPage () {
      this.pageNum += 1
    },
    prevPage () {
      this.pageNum -= 1
    }
  },
  // 디비 가져오는거랑 컴퓨티드에 코드가 사실상 전부다.
  computed: {
    pageCount () {
      // listArray는 전체 디비에서 들어온 어레이길이
      const listLen = this.listArray.length
      const listSize = this.pageSize
      let page = Math.floor(listLen / listSize)
      if (listLen % listSize > 0) {
        page += 1
      }
      return page
    },
    paginatedData () {
      // 0(처음페이지넘버) * 5 = 0 (start)
      const start = this.pageNum * this.pageSize
      // 0 + 5 = 5
      // 0부터 5까지 끊어서 첫 페이지에 보여주고 next를 누르면 pageNum
      const end = start + this.pageSize
      return this.listArray.slice(start, end)
    }
  }
}
</script>
