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
}
#app {
  height: 0px;
}
#footer {
    position:absolute;
    bottom:0;
    width:100%;
}
</style>
