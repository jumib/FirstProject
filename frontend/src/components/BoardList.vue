<template>
  <div>
    <v-simple-table>
      <template v-slot:default>
        <thead>
          <tr>
            <th align="center" width="80">No</th>
            <th align="center" width="300">Title</th>
            <th align="center" width="100">Writer</th>
          </tr>
        </thead>
         <tbody>
              <tr v-for="board in boards" :key="board.boardNo" align="center">
                <td>{{ board.boardNo }}</td>
                <td>
                  <router-link :to="{ name: 'BoardReadPage',
                          params: { boardNo: board.boardNo.toString() } }">
                    {{ board.title }}
                  </router-link>
                </td>
                <td>{{ board.writer }}</td>
              </tr>
        </tbody>
      </template>
    </v-simple-table>
  </div>
</template>

<script>
export default {
  name: 'BoardList',
  props: {
    boards: {
      type: Array
    }
  }
}
</script>
