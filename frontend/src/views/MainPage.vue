<template>
  <Layout>
    <template #content>
    </template>
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
  }
}
</script>

<style scoped lang="scss">
.container {
  height: 40px;
  width: 40px;
  background-image: url("/home/bitai/Downloads/background.jpg");
}
</style>
