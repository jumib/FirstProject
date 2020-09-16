<template>
  <v-app>
    <!--  <div id="header">
      <layout/>
    </div>
    -->
    <div id="content" >
      <router-view/>
    </div>
  </v-app>
</template>
// 레이아웃의 헤더부분만 고정하고 싶은데
// 전체 영역이 고정돼서 내용이 함께 보임 (수정하기)

<script>
// import Layout from '@/components/Layout'
// export default {
//   components: {
//     Layout
//   }
// }
</script>

<style scoped>
div {
  border: //1px solid #ccc;
}
#content {
}
</style>
