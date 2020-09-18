<template>
 <div class="ma-16" align="center">
    <h2>사진 업로드 페이지</h2>
    <div class="my-2" align="right">
      <v-btn depressed small
      @click="$router.push('MainPage')">메인으로</v-btn>
      <PondRegisterForm/>
    </div>
 </div>
</template>

<script>
import PondRegisterForm from '@/components/PondRegisterForm.vue'

export default {
  name: 'PondRegisterPage',
  components: {
    PondRegisterForm
  }
}
</script>
