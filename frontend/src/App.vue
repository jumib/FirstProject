<template>
  <v-app>
    <div id="header">
      <layout/>
    </div>
    <div id="content" >
      <router-view/>
    </div>
  </v-app>
</template>
<script>
import Layout from '@/components/Layout'
export default {
  components: {
    Layout
  }
}
</script>
<style scoped>
div {
  border: //1px solid #ccc;
}
#header {
  height:
}
#content {
}
</style>
