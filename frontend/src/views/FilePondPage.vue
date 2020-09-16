<template>
  <div>
    <h2 align="center">사진올리기</h2>
    <div class="" align="right">
      <v-btn depressed small
            @click="$router.push('MainPage')">메인으로</v-btn>
      <v-btn depressed small
            @click="$router.push('PondForm')">메인으로</v-btn>
      <PondForm/>
    </div>
  </div>
</template>

<script>
import PondForm from '@/components/PondForm.vue'

export default {
  name: 'FilePondPage',
  components: {
    PondForm
  }
}
</script>
