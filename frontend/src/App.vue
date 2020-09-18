<template>
  <v-app>
    <div id="header">
      <Header/>
    </div>
    <div id="content" >
      <router-view/>
    </div>
    <div id="footer">
      <Footer/>
    </div>
  </v-app>
</template>

<script>
import Header from '@/components/Header'
import Footer from '@/components/Footer'

export default {
  components: {
    Header,
    Footer
  }
}
</script>

<style scoped>
#content {
  margin-left: 120px;
  margin-right: 120px;
}
#app {
  height: 0px;
}
</style>
