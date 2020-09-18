<template>
 <div class="ma-16" align="center">
      <v-btn @click="$router.push('PondRegisterPage')" color="#000000" dark>upload
        <v-icon>mdi-upload</v-icon>
      </v-btn>
      <v-btn
      @click="$router.push('MainPage')">메인으로</v-btn>
 </div>
</template>

<script>

export default {
  name: 'PondListPage',
  components: {
  }
}
</script>
